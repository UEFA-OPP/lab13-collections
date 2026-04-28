package Week13;
import java.util.HashSet;

public class SetDemo {
    static void main() {
        // Даалгавар 6: HashSet үүсгэх
        HashSet<Integer> set = new HashSet<>();

        // Даалгавар 7: Data нэмэх (Ижил утга 2 удаа нэмэх)
        set.add(1);
        set.add(2);
        set.add(2); // Давхардал
        set.add(3);

        System.out.println("Set-ийн агуулга: " + set); // [1, 2, 3] гэж харагдана

        // Даалгавар 8: Давталт
        for (Integer num : set) {
            System.out.println("Элемент: " + num);
        }
    }
}
