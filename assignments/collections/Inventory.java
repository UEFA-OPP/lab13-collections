import java.util.*;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();
    private Map<String, ItemType> itemTypes = new HashMap<>();

    public void addItem(String name) {
        items.merge(name, 1, Integer::sum);
    }

    // Stretch: Overloaded method to handle types
    public void addItem(String name, ItemType type) {
        addItem(name);
        itemTypes.put(name, type);
    }

    public void removeItem(String name) {
        if (!items.containsKey(name)) return;
        int count = items.get(name) - 1;
        if (count <= 0) {
            items.remove(name);
            itemTypes.remove(name); // Type-ийг бас цэвэрлэнэ
        } else {
            items.put(name, count);
        }
    }

    public boolean hasItem(String name) {
        return items.containsKey(name) && items.get(name) > 0;
    }

    public int getCount(String name) {
        return items.getOrDefault(name, 0);
    }

    // Stretch: Group items by their type
    public Map<ItemType, List<String>> groupByType() {
        Map<ItemType, List<String>> result = new HashMap<>();
        for (Map.Entry<String, ItemType> entry : itemTypes.entrySet()) {
            String name = entry.getKey();
            ItemType type = entry.getValue();

            // Зөвхөн одоо inventory-д байгаа (count > 0) item-уудыг л бүлэглэнэ
            if (hasItem(name)) {
                result.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
            }
        }
        return result;
    }
}