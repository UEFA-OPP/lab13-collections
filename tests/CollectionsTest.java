import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@DisplayName("Lab 13: Inventory & Party (Collections)")
public class CollectionsTest {

    private Inventory inventory;
    private Party party;
    private Character alice;
    private Character bob;
    private Character dead;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        party = new Party();
        alice = new Character("Alice", 100);
        bob = new Character("Bob", 50);
        dead = new Character("Dead", 0);
    }

    // ==================== 🟢 CORE ====================

    @Test
    @Tag("core")
    @DisplayName("ItemType enum 4 тогтмолтой")
    void itemTypeHasFourValues() {
        ItemType[] values = ItemType.values();
        assertEquals(4, values.length, "ItemType нь 4 утгатай байх ёстой");
        assertNotNull(ItemType.valueOf("POTION"));
        assertNotNull(ItemType.valueOf("WEAPON"));
        assertNotNull(ItemType.valueOf("ARMOR"));
        assertNotNull(ItemType.valueOf("KEY"));
    }

    @Test
    @Tag("core")
    @DisplayName("Inventory.items талбар Map төрөлтэй, private")
    void inventoryItemsIsMap() throws Exception {
        Field f = Inventory.class.getDeclaredField("items");
        assertTrue(Modifier.isPrivate(f.getModifiers()), "items талбар private биш");
        assertTrue(Map.class.isAssignableFrom(f.getType()),
            "items талбар Map төрөлтэй байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("addItem давхардсан үед count нэмэгдэнэ")
    void addItemIncrementsDuplicates() {
        inventory.addItem("Potion");
        inventory.addItem("Potion");
        inventory.addItem("Potion");
        assertEquals(3, inventory.getCount("Potion"));
    }

    @Test
    @Tag("core")
    @DisplayName("hasItem, getCount зөв ажилна")
    void hasItemAndGetCount() {
        assertFalse(inventory.hasItem("Sword"));
        assertEquals(0, inventory.getCount("Sword"));
        inventory.addItem("Sword");
        assertTrue(inventory.hasItem("Sword"));
        assertEquals(1, inventory.getCount("Sword"));
    }

    @Test
    @Tag("core")
    @DisplayName("removeItem count буулгаж, 0 болвол устгана")
    void removeItemDecrementsAndDeletes() {
        inventory.addItem("Potion");
        inventory.addItem("Potion");
        inventory.removeItem("Potion");
        assertEquals(1, inventory.getCount("Potion"));
        inventory.removeItem("Potion");
        assertEquals(0, inventory.getCount("Potion"));
        assertFalse(inventory.hasItem("Potion"), "count=0 үед устгагдсан байх");
    }

    @Test
    @Tag("core")
    @DisplayName("Party.members талбар List төрөлтэй, private")
    void partyMembersIsList() throws Exception {
        Field f = Party.class.getDeclaredField("members");
        assertTrue(Modifier.isPrivate(f.getModifiers()), "members талбар private биш");
        assertTrue(List.class.isAssignableFrom(f.getType()),
            "members талбар List төрөлтэй байх ёстой");
    }

    @Test
    @Tag("core")
    @DisplayName("Party add/remove/size ажилна")
    void partyAddRemoveSize() {
        assertEquals(0, party.size());
        party.add(alice);
        party.add(bob);
        assertEquals(2, party.size());
        party.remove(alice);
        assertEquals(1, party.size());
    }

    @Test
    @Tag("core")
    @DisplayName("getAlive зөвхөн амьд баатруудыг шүүнэ")
    void getAliveFiltersByIsAlive() {
        party.add(alice);
        party.add(bob);
        party.add(dead);
        List<Character> alive = party.getAlive();
        assertEquals(2, alive.size());
        assertTrue(alive.contains(alice));
        assertTrue(alive.contains(bob));
        assertFalse(alive.contains(dead));
    }

    @Test
    @Tag("core")
    @DisplayName("getAlive нь бүгд үхсэн үед хоосон жагсаалт буцаана")
    void getAliveEmptyWhenAllDead() {
        party.add(dead);
        party.add(new Character("Ghost", 0));
        assertEquals(0, party.getAlive().size());
    }

    // ==================== 🟡 STRETCH ====================

    @Test
    @Tag("stretch")
    @DisplayName("groupByType ItemType-аар ангилна")
    void groupByTypeGroups() {
        inventory.addItem("Red Potion", ItemType.POTION);
        inventory.addItem("Blue Potion", ItemType.POTION);
        inventory.addItem("Sword", ItemType.WEAPON);
        inventory.addItem("Helmet", ItemType.ARMOR);

        Map<ItemType, List<String>> grouped = inventory.groupByType();
        assertNotNull(grouped);
        assertEquals(2, grouped.get(ItemType.POTION).size(),
            "POTION-д 2 item байх ёстой");
        assertEquals(1, grouped.get(ItemType.WEAPON).size());
        assertEquals(1, grouped.get(ItemType.ARMOR).size());
    }

    @Test
    @Tag("stretch")
    @DisplayName("sortByHp HP-ээр буурах эрэмбээр ангилна")
    void sortByHpDescending() {
        Character c1 = new Character("Low", 10);
        Character c2 = new Character("High", 200);
        Character c3 = new Character("Mid", 75);
        party.add(c1);
        party.add(c2);
        party.add(c3);

        List<Character> sorted = party.sortByHp();
        assertEquals(3, sorted.size());
        assertEquals(200, sorted.get(0).getHp(), "Хамгийн HP өндөр эхэнд");
        assertEquals(75, sorted.get(1).getHp());
        assertEquals(10, sorted.get(2).getHp());
    }

    @Test
    @Tag("stretch")
    @DisplayName("sortByHp анхны members жагсаалтыг өөрчилөхгүй")
    void sortByHpDoesNotMutate() throws Exception {
        Character c1 = new Character("A", 10);
        Character c2 = new Character("B", 200);
        party.add(c1);
        party.add(c2);

        party.sortByHp();

        Field f = Party.class.getDeclaredField("members");
        f.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<Character> original = (List<Character>) f.get(party);
        assertEquals(c1, original.get(0), "Анхны дараалал хадгалагдана");
        assertEquals(c2, original.get(1));
    }

    // ==================== 🔴 BONUS ====================

    @Test
    @Tag("bonus")
    @DisplayName("Container<T> generic String болон Integer-тэй ажилна")
    void containerGenericWorks() {
        Container<String> strs = new Container<>();
        strs.add("hello");
        strs.add("world");
        assertEquals(2, strs.size());
        assertEquals("hello", strs.get(0));

        Container<Integer> ints = new Container<>();
        ints.add(42);
        ints.add(100);
        assertEquals(2, ints.size());
        assertEquals(Integer.valueOf(100), ints.get(1));
    }

    @Test
    @Tag("bonus")
    @DisplayName("getAliveStream нь Stream API ашиглаж long буцаана")
    void getAliveStreamReturnsLongCount() throws Exception {
        party.add(alice);
        party.add(bob);
        party.add(dead);
        long count = party.getAliveStream();
        assertEquals(2L, count);

        // Метод нь long буцаадаг эсэхийг шалгах
        java.lang.reflect.Method m = Party.class.getMethod("getAliveStream");
        assertEquals(long.class, m.getReturnType(),
            "getAliveStream нь long буцаах ёстой");
    }
}
