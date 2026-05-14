
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();
    private Map<String, ItemType> itemTypes = new HashMap<>(); // Төрлийг хадгалах нэмэлт Map

    public void addItem(String name) {
        items.merge(name, 1, Integer::sum);
    }

    // 4-р даалгавар: Overload addItem - Төрөлтэй нь хамт нэмэх
    public void addItem(String name, ItemType type) {
        addItem(name);
        itemTypes.put(name, type);
    }

    public void removeItem(String name) {
        if (!items.containsKey(name)) return;
        int count = items.get(name) - 1;
        if (count <= 0) {
            items.remove(name);
            itemTypes.remove(name); // Тоо нь 0 болвол төрлийг нь бас устгана
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

    // 4-р даалгавар: Төрлөөр нь бүлэглэж буцаах
    public Map<ItemType, List<String>> groupByType() {
        Map<ItemType, List<String>> result = new HashMap<>();
        for (Map.Entry<String, ItemType> entry : itemTypes.entrySet()) {
            String itemName = entry.getKey();
            ItemType type = entry.getValue();

            // Хэрэв тухайн зүйл inventory-д байгаа бол бүлэглэлд нэмнэ
            if (hasItem(itemName)) {
                result.computeIfAbsent(type, k -> new ArrayList<>()).add(itemName);
            }
        }
        return result;
    }
}