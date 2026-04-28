package Week13;
import java.util.ArrayList;

public class ListDemo {
    static void main() {
        // Даалгавар 1: ArrayList үүсгэх
        ArrayList<String> list = new ArrayList<>();

        // Даалгавар 2: Data нэмэх
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Даалгавар 3: Data авах
        System.out.println("Эхний элемент: " + list.getFirst());

        // Даалгавар 4: Data устгах
        list.remove(1); // Banana-г устгана
        System.out.println("Устгасны дараах жагсаалт: " + list);

        // Даалгавар 5: Давталт хийх
        System.out.println("Бүх элементүүд:");
        for (String item : list) {
            System.out.println(item);
        }
    }
}
