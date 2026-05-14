import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();
    private Map<String, ItemType> itemTypes = new HashMap<>();

    public void addItem(String name) {
        items.merge(name, 1, Integer::sum);
    }

    public void addItem(String name, ItemType type) {
        addItem(name);
        itemTypes.put(name, type);
    }

    public void removeItem(String name) {
        if (!items.containsKey(name)) return;
        int count = items.get(name) - 1;
        if (count <= 0) {
            items.remove(name);
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

    public Map<ItemType, List<String>> groupByType() {
        Map<ItemType, List<String>> result = new HashMap<>();
        for (Map.Entry<String, ItemType> entry : itemTypes.entrySet()) {
            if (hasItem(entry.getKey())) {
                result.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                      .add(entry.getKey());
            }
        }
        return result;
    }
}