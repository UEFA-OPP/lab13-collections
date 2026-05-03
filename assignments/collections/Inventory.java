import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    // Эд зүйлсийн нэр болон тоо ширхэг
    private Map<String, Integer> items = new HashMap<>();

    // ─────── 🟡 Stretch: item types ───────
    // Эд зүйлсийн нэр болон түүний төрөл (ItemType)
    private Map<String, ItemType> itemTypes = new HashMap<>();

    // Үндсэн нэмэх функц (Core)
    public void addItem(String name) {
        items.merge(name, 1, Integer::sum);
    }

    // Төрөлтэйгээр нэмэх функц (Stretch)
    public void addItem(String name, ItemType type) {
        addItem(name);
        itemTypes.put(name, type);
    }

    public void removeItem(String name) {
        if (items.containsKey(name)) {
            int count = items.get(name) - 1;
            if (count <= 0) {
                items.remove(name);
                // itemTypes.remove(name); // Шаардлагатай бол төрлийг нь бас устгаж болно
            } else {
                items.put(name, count);
            }
        }
    }

    public boolean hasItem(String name) {
        return items.getOrDefault(name, 0) > 0;
    }

    public int getCount(String name) {
        return items.getOrDefault(name, 0);
    }

    // ─────── 🟡 Stretch (30 оноо) ───────

    /**
     * Төрөл тус бүрээр эд зүйлсийг бүлэглэх
     * Зөвхөн одоо inventory-д байгаа (count > 0) зүйлсийг авна.
     */
    public Map<ItemType, List<String>> groupByType() {
        Map<ItemType, List<String>> grouped = new HashMap<>();

        for (String itemName : items.keySet()) {
            ItemType type = itemTypes.get(itemName);
            if (type != null) {
                // Тухайн төрлийн жагсаалт байхгүй бол шинийг үүсгэнэ
                grouped.putIfAbsent(type, new ArrayList<>());
                grouped.get(type).add(itemName);
            }
        }

        return grouped;
    }
}
