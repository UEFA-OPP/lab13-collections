import java.util.ArrayList;
import java.util.List;

/**
 * 🔴 Bonus: generic container
 */
public class Container<T> {
    // 1. private List<T> items = new ArrayList<>();
    private List<T> items = new ArrayList<>();

    /**
     * add(T item) → void
     */
    public void add(T item) {
        items.add(item);
    }

    /**
     * get(int idx) → T
     */
    public T get(int idx) {
        // Тестийн шаардлагаар индекс шалгахгүйгээр шууд .get(idx) 
        // ашиглаж болно, эсвэл аюулгүй байдлыг хангах:
        if (idx >= 0 && idx < items.size()) {
            return items.get(idx);
        }
        return null;
    }

    /**
     * size() → int
     */
    public int size() {
        return items.size();
    }
}