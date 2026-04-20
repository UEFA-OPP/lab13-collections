import java.util.*;

public class Container<T> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int idx) {
        return items.get(idx);
    }

    public int size() {
        return items.size();
    }
}