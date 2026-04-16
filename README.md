# 🐉 Lab 13 — Collections: Inventory & Party

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![JUnit](https://img.shields.io/badge/JUnit-5-green?logo=junit5)
![Auto-Grader](https://img.shields.io/badge/Auto--Grader-Enabled-blue)
![AI Detection](https://img.shields.io/badge/AI%20Detection-Enabled-red)

> Dungeon of OOP-ын гүнд алга болсон зэвсэг, хуримтлалын эм, амьд/үхсэн баатар — энэ бүгдийг эмх цэгцтэй хадгалах хэрэгтэй. **Collections Framework** — `List`, `Set`, `Map`, `enum`, `Iterator` — нь чиний хэрэгсэл. Inventory-д эм (`Map<String, Integer>`), Party-д амьд баатрууд (`List<Character>`), ялагдсан дайснууд давхардахгүй (`Set`) хадгална.

## 📚 Суралцах материал

- **Теори:** [`UEFA-OPP-resources/docs/week-13-collections/`](https://github.com/UEFA-OPP/UEFA-OPP-resources/tree/main/docs/week-13-collections)
- **Git workflow заавар:** [`UEFA-OPP-resources/docs/git-workflow/`](https://github.com/UEFA-OPP/UEFA-OPP-resources/tree/main/docs/git-workflow)

## 🏗️ Хавтасны бүтэц

```
lab13-template/
├── README.md                           # Энэ файл
├── .gitignore
├── assignments/
│   └── collections/
│       ├── Character.java              # ← Урьдчилан бичигдсэн (бүү өөрчил)
│       ├── ItemType.java               # ← Та энд код бичнэ (enum)
│       ├── Inventory.java              # ← Та энд код бичнэ
│       ├── Party.java                  # ← Та энд код бичнэ
│       ├── Container.java              # ← Bonus: generic class
│       └── README.md                   # Даалгаврын дэлгэрэнгүй заавар
├── tests/
│   └── CollectionsTest.java            # JUnit 5 тестүүд (бүү өөрчил)
├── scripts/
│   ├── run_tests.sh
│   └── ai_detector.py
└── .github/workflows/grade.yml
```

## 🚀 Лаб хийх заавар (Алхам алхмаар)

### Алхам 1: Repo-г Fork хийх

1. Браузераар [`UEFA-OPP/lab13-template`](https://github.com/UEFA-OPP/lab13-template) руу орно
2. **Fork** товч дарна
3. Owner-ээр өөрийн account-ийг сонгоод **Create fork** дарна

### Алхам 2: Компьютер дээрээ Clone хийх

```bash
git clone https://github.com/<таны-username>/lab13-template.git
cd lab13-template
```

### Алхам 3: Branch үүсгэх

```bash
git checkout -b lab13/<өөрийн-нэр>
```

### Алхам 4: Даалгаврын зааврыг унших

```bash
cat assignments/collections/README.md
```

### Алхам 5: Код бичих

`assignments/collections/` хавтас дахь `// TODO` комментуудыг соль:

- 🟢 **Core (60 оноо)** — `ItemType` enum, `Inventory` (Map), `Party` (List)
- 🟡 **Stretch (30 оноо)** — `groupByType` (Map<ItemType, List<String>>), `sortByHp` (Comparator)
- 🔴 **Bonus (10 оноо)** — generic `Container<T>`, Stream API

### Алхам 6: Локал тест ажиллуулах

```bash
bash scripts/run_tests.sh
bash scripts/run_tests.sh --tag core
bash scripts/run_tests.sh --tag stretch
bash scripts/run_tests.sh --tag bonus
```

### Алхам 7: Commit хийх

```bash
git add assignments/
git commit -m "Implement collections - <your name>"
```

### Алхам 8: GitHub руу Push хийх

```bash
git push origin lab13/<өөрийн-нэр>
```

### Алхам 9: Pull Request (PR) үүсгэх

PR title-д **өөрийн нэр, бүлгийг** бичнэ. Жишээ: `Bat-Erdene - SE401`

### Алхам 10: Автомат шалгалтын дүнг харах

GitHub Actions автоматаар ажиллана. Үр дүн PR-т коммент болж гарна.

## 📊 Оноо тооцох систем

| Tier | Жин | Тайлбар |
|------|-----|---------|
| 🟢 **Core** | **60%** | enum, Map, List үндсэн үйлдэл |
| 🟡 **Stretch** | **30%** | groupByType, Comparator |
| 🔴 **Bonus** | **10%** | Generic class, Stream API |

**Формула:**
```
score = (core_passed / core_total) * 60
      + (stretch_passed / stretch_total) * 30
      + (bonus_passed / bonus_total) * 10
```

## 🤖 AI Detection policy

| Оноо | Түвшин | Үр дагавар |
|------|--------|------------|
| 0-19 | ✅ **LOW** | Асуудалгүй. |
| 20-39 | ⚠️ **MEDIUM** | Багш шалгана. |
| 40+ | 🚨 **HIGH** | Онооноос **50% хасна**. |

## ⚠️ Дүрэм

1. **Тест файлыг өөрчлөхгүй** — `tests/CollectionsTest.java`-г хөндөхгүй
2. **`Character.java`-г өөрчлөхгүй** — урьдчилан бичигдсэн
3. **AI ашиглахгүй**
4. **Өөрийн branch дээр ажиллана**

## 🛠️ Шаардлага

- **Java 17+**
- **Python 3.11+**
- **Bash**, **curl**, **Git**

## 📞 Асуулт байвал

Багшаасаа асуу. Амжилт хүсье, адвенчурер! 🗡️🛡️
