# Lab 13 — Inventory & Party (Collections)

**Нийт оноо:** 100 | **Сэдэв:** `List`, `Set`, `Map`, generics, Iterator, enum

## 🎭 Түүх

Dungeon of OOP-ын баатар олон эм, зэвсэг авч эхэлсэн. Энэ бүгдийг **Inventory**-т цэгцтэй хадгалах шаардлагатай — ижил эмээс **хэд хэд** авч болно (Map<нэр, тоо>). Баатрууд **Party** болж нэгдэж, зөвхөн амьд (`hp > 0`) нь дараагийн байлдаанд ордог. Ялсан дайснаа `Set`-д хадгална — давхардуулахгүй.

---

## 📋 Урьдчилан бичигдсэн файл

### `Character.java` (бүү өөрчил)

```java
public class Character {
    private String name;
    private int hp;

    public Character(String name, int hp) { ... }
    public String getName() { ... }
    public int getHp() { ... }
    public void setHp(int hp) { ... }
    public boolean isAlive() { return hp > 0; }
}
```

---

## 🟢 Core (60 оноо) — 9 тест

### 1. `ItemType.java` — enum

```java
public enum ItemType {
    POTION, WEAPON, ARMOR, KEY
}
```

4 тогтмол утгатай enum.

### 2. `Inventory.java`

```java
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();

    public void addItem(String name) {
        items.merge(name, 1, Integer::sum);
    }

    public void removeItem(String name) {
        if (!items.containsKey(name)) return;
        int c = items.get(name) - 1;
        if (c <= 0) items.remove(name);
        else items.put(name, c);
    }

    public boolean hasItem(String name) {
        return items.containsKey(name) && items.get(name) > 0;
    }

    public int getCount(String name) {
        return items.getOrDefault(name, 0);
    }
}
```

**Шаардлага:**
- `items` талбар `Map<String, Integer>` төрөлтэй, `private`.
- `addItem(name)` нэмэх (давхардсан бол count нэмэгдэнэ).
- `removeItem(name)` — count буурна, 0 болвол entry устгана.
- `hasItem(name)` — true/false.
- `getCount(name)` — count эсвэл 0.

### 3. `Party.java`

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Party {
    private List<Character> members = new ArrayList<>();

    public void add(Character c) { members.add(c); }
    public void remove(Character c) { members.remove(c); }
    public int size() { return members.size(); }

    public List<Character> getAlive() {
        List<Character> alive = new ArrayList<>();
        for (Character c : members) {
            if (c.isAlive()) alive.add(c);
        }
        return alive;
    }
}
```

**Шаардлага:**
- `members` талбар `List<Character>` төрөлтэй, `private`.
- `add`, `remove`, `size` үндсэн method.
- `getAlive()` — `isAlive() == true` баатруудыг шүүнэ.

---

## 🟡 Stretch (30 оноо) — 3 тест

### 4. `Inventory.groupByType()`

```java
private Map<String, ItemType> itemTypes = new HashMap<>();

public void addItem(String name, ItemType type) {
    items.merge(name, 1, Integer::sum);
    itemTypes.put(name, type);
}

public Map<ItemType, List<String>> groupByType() {
    Map<ItemType, List<String>> result = new HashMap<>();
    for (Map.Entry<String, ItemType> e : itemTypes.entrySet()) {
        if (items.getOrDefault(e.getKey(), 0) > 0) {
            result.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }
    }
    return result;
}
```

- Нэмэлт талбар `itemTypes` (Map<String, ItemType>).
- Overload: `addItem(String name, ItemType type)`.
- `groupByType()` буцаана `Map<ItemType, List<String>>` — ItemType тус бүрд нэр нэмнэ.

### 5. `Party.sortByHp()` — Comparator

```java
public List<Character> sortByHp() {
    List<Character> sorted = new ArrayList<>(members);
    sorted.sort((a, b) -> Integer.compare(b.getHp(), a.getHp()));
    return sorted;
}
```

- HP-ээр **буурах эрэмбээр** ангилна.
- Анхны `members` жагсаалтыг өөрчилөхгүй (шинэ жагсаалт буцаана).

---

## 🔴 Bonus (10 оноо) — 2 тест

### 6. `Container<T>` — generic class

```java
import java.util.ArrayList;
import java.util.List;

public class Container<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) { items.add(item); }
    public T get(int idx) { return items.get(idx); }
    public int size() { return items.size(); }
}
```

- Generic параметр `<T>`.
- `Container<String>`, `Container<Integer>` зэрэг ашиглагдана.

### 7. `Party.getAliveStream()` — Stream API

```java
import java.util.stream.Stream;

public long getAliveStream() {
    return members.stream().filter(Character::isAlive).count();
}
```

- Stream API ашиглана (`stream()`, `filter()`, `count()`).

---

## 🧪 Тест ажиллуулах

```bash
bash scripts/run_tests.sh
bash scripts/run_tests.sh --tag core
bash scripts/run_tests.sh --tag stretch
bash scripts/run_tests.sh --tag bonus
```

---

## ✅ Шалгуурын жагсаалт (Checklist)

### Core
- [ ] `ItemType` enum 4 утгатай (POTION, WEAPON, ARMOR, KEY)
- [ ] `Inventory.items` нь `Map<String, Integer>` төрөлтэй, private
- [ ] `addItem`, `removeItem`, `hasItem`, `getCount` ажилна
- [ ] Давхардсан `addItem` — count нэмэгдэнэ
- [ ] `Party.members` нь `List<Character>` төрөлтэй, private
- [ ] `add`, `remove`, `size` ажилна
- [ ] `getAlive()` — `isAlive()` шүүлт

### Stretch
- [ ] `addItem(name, type)` overload
- [ ] `groupByType()` — `Map<ItemType, List<String>>`
- [ ] `sortByHp()` — HP буурах эрэмбээр (шинэ жагсаалт)

### Bonus
- [ ] `Container<T>` generic, `add/get/size`
- [ ] `getAliveStream()` — Stream API, `long` буцаана

---

## 🚫 Түгээмэл алдаанууд

1. **Raw type ашиглах** (`Map items = new HashMap()`) — generics заавал бичнэ
2. **`getAlive` үр дүнг `members`-с шууд өгөх** — тусгай шүүлт хий
3. **`sortByHp` анхны жагсаалтыг өөрчилөх** — `new ArrayList<>(members)` хуулбар бий болго
4. **enum-д семиколон мартах** — `enum ItemType { A, B, C, D }` байхад ок
5. **`Container<T>` дотор `T[]` ашиглах** — Java-д generic array бүтэхгүй, `List<T>` хэрэглэ
