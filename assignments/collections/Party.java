
import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Character> members = new ArrayList<>();

    public void add(Character c) { members.add(c); }
    public void remove(Character c) { members.remove(c); }
    public int size() { return members.size(); }

    public List<Character> getAlive() {
        List<Character> alive = new ArrayList<>();
        for (Character c : members) {
            if (c.isAlive()) alive.add(c);
        }
        return alive;
    }

    // 5-р даалгавар: HP-ээр нь буурах эрэмбээр эрэмбэлэх
    public List<Character> sortByHp() {
        // Анхны жагсаалтыг өөрчлөхгүйн тулд шинэ хуулбар жагсаалт үүсгэнэ
        List<Character> sorted = new ArrayList<>(members);

        // Comparator ашиглан эрэмбэлнэ (b.hp - a.hp)
        sorted.sort((a, b) -> Integer.compare(b.getHp(), a.getHp()));

        return sorted;
    }

    // Bonus даалгавар: Stream API ашиглах бол энд нэмж болно
    public long getAliveStream() {
        return members.stream().filter(Character::isAlive).count();
    }
}