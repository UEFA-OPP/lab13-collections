import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Party {

    // Баатруудын жагсаалтыг ArrayList-ээр үүсгэх
    private List<Character> members = new ArrayList<>();

    /**
     * Шинэ баатар нэмэх
     */
    public void add(Character c) {
        members.add(c);
    }

    /**
     * Баатрыг жагсаалтаас хасах
     */
    public void remove(Character c) {
        members.remove(c);
    }

    /**
     * Нийт баатруудын тоог буцаах
     */
    public int size() {
        return members.size();
    }

    /**
     * Зөвхөн амьд байгаа (hp > 0) баатруудыг шүүж авах
     */
    public List<Character> getAlive() {
        List<Character> aliveOnes = new ArrayList<>();
        for (Character c : members) {
            if (c.isAlive()) {
                aliveOnes.add(c);
            }
        }
        return aliveOnes;
    }

    // ─────── 🟡 Stretch (30 оноо) ───────

    /**
     * Баатруудыг HP-ээр нь буурах дарааллаар эрэмбэлсэн хуулбар жагсаалт буцаах
     */
    public List<Character> sortByHp() {
        // Үндсэн жагсаалтыг өөрчлөхгүйн тулд хуулбар үүсгэнэ
        List<Character> sorted = new ArrayList<>(members);

        // b.getHp() ба a.getHp()-г харьцуулснаар ихээс бага руу (буурах) эрэмбэлнэ
        sorted.sort((a, b) -> Integer.compare(b.getHp(), a.getHp()));

        return sorted;
    }

    // ─────── 🔴 Bonus (10 оноо) ───────

    /**
     * Stream API ашиглан амьд баатруудын тоог олох
     */
    public long getAliveStream() {
        return members.stream()
                .filter(Character::isAlive)
                .count();
    }
}