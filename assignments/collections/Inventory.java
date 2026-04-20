import java.util.*;

public class Inventory {

    private Map<String, Integer> items = new HashMap<>();
    private Map<String, ItemType> itemTypes = new HashMap<>();

    // CORE
    public void addItem(String name) {
        items.merge(name, 1, Integer::sum);
    }

    // STRETCH overload
    public void addItem(String name, ItemType type) {
        items.merge(name, 1, Integer::sum);
        itemTypes.put(name, type);
    }

    public void removeItem(String name) {
        if (!items.containsKey(name)) return;

        int c = items.get(name) - 1;

        if (c <= 0) {
            items.remove(name);
            itemTypes.remove(name);
        } else {
            items.put(name, c);
        }
    }

    public boolean hasItem(String name) {
        return items.containsKey(name) && items.get(name) > 0;
    }

    public int getCount(String name) {
        return items.getOrDefault(name, 0);
    }

    // STRETCH
    public Map<ItemType, List<String>> groupByType() {
        Map<ItemType, List<String>> result = new HashMap<>();

        for (Map.Entry<String, ItemType> e : itemTypes.entrySet()) {
            String item = e.getKey();
            ItemType type = e.getValue();

            if (items.getOrDefault(item, 0) > 0) {
                result.computeIfAbsent(type, k -> new ArrayList<>()).add(item);
            }
        }

        return result;
    }
}