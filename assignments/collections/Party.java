import java.util.ArrayList;
import java.util.List;

public class Party {
    // List ашиглан багийн гишүүдийг хадгалах
    private List<Character> members = new ArrayList<>();

    public void add(Character c) { 
        members.add(c); 
    }

    public void remove(Character c) { 
        members.remove(c); 
    }

    public int size() { 
        return members.size(); 
    }

    // Энгийн loop ашиглан амьд баатруудыг шүүх
    public List<Character> getAlive() {
        List<Character> alive = new ArrayList<>();
        for (Character c : members) {
            if (c.isAlive()) alive.add(c);
        }
        return alive;
    }

    // HP-ээр буурах эрэмбээр эрэмбэлсэн шинэ жагсаалт буцаах
    public List<Character> sortByHp() {
        List<Character> sorted = new ArrayList<>(members);
        sorted.sort((a, b) -> Integer.compare(b.getHp(), a.getHp()));
        return sorted;
    }

    // Bonus: Stream API ашиглан амьд баатруудыг тоолох
    public long getAliveStream() {
        return members.stream()
                      .filter(Character::isAlive)
                      .count();
    }
}