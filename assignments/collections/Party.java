import java.util.ArrayList;
import java.util.List;

public class Party {

    // TODO: private List<Character> members
    // - new ArrayList<>() -ээр initialize хий

    // TODO: add(Character c) → void
    // - members.add(c)

    // TODO: remove(Character c) → void
    // - members.remove(c)

    // TODO: size() → int
    // - members.size()

    // TODO: getAlive() → List<Character>
    // - зөвхөн c.isAlive() == true баатруудыг агуулсан шинэ List буцаах

    // ─────── 🟡 Stretch (30 оноо) ───────

    // TODO: sortByHp() → List<Character>
    // - members-ын хуулбар дээр hp-ээр буурах эрэмбээр sort хийнэ
    // - Comparator эсвэл lambda ашиглана
    // - жишээ: sorted.sort((a, b) -> Integer.compare(b.getHp(), a.getHp()))

    // ─────── 🔴 Bonus (10 оноо) ───────

    // TODO: getAliveStream() → long
    // - members.stream().filter(Character::isAlive).count()
}
