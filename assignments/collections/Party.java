import java.util.*;
import java.util.stream.Collectors;

public class Party {

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

    public List<Character> getAlive() {
        List<Character> alive = new ArrayList<>();
        for (Character c : members) {
            if (c.isAlive()) {
                alive.add(c);
            }
        }
        return alive;
    }

    public List<Character> sortByHp() {
        List<Character> sorted = new ArrayList<>(members);
        sorted.sort((a, b) -> Integer.compare(b.getHp(), a.getHp()));
        return sorted;
    }

    public long getAliveStream() {
        return members.stream()
                .filter(Character::isAlive)
                .count();
    }
}