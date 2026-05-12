package Week13;
import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        // Даалгавар 9: HashMap үүсгэх
        HashMap<String, Integer> map = new HashMap<>();

        // Даалгавар 10: Data нэмэх
        map.put("Apple", 10);
        map.put("Banana", 20);

        // Даалгавар 11: Data авах
        System.out.println("Apple-ийн үнэ: " + map.get("Apple"));
        System.out.println("Байхгүй key: " + map.get("Orange")); // null буцаана

        // Даалгавар 12: Давталт хийх
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
