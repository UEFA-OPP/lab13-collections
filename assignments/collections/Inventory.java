import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private Map<String, Integer> items = new HashMap<>();
    private Map<String, ItemType> itemTypes = new HashMap<>();

    public void addItem(String name) {
        items.merge(name, 1, Integer::sum);
    }

    public void removeItem(String name) {
        if (!items.containsKey(name)) return;
        int count = items.get(name) - 1;
        if (count <= 0) items.remove(name);
        else items.put(name, count);
    }

    public boolean hasItem(String name) {
        return items.containsKey(name) && items.get(name) > 0;
    }

    public int getCount(String name) {
        return items.getOrDefault(name, 0);
    }

    public void addItem(String name, ItemType type) {
        items.merge(name, 1, Integer::sum);
        itemTypes.put(name, type);
    }

    public Map<ItemType, List<String>> groupByType() {
        Map<ItemType, List<String>> result = new HashMap<>();
        for (Map.Entry<String, ItemType> entry : itemTypes.entrySet()) {
            String name = entry.getKey();
            ItemType type = entry.getValue();
            if (items.getOrDefault(name, 0) > 0) {
                result.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
            }
        }
        return result;
    }
}