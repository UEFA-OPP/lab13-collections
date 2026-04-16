import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    // TODO: private Map<String, Integer> items
    // - HashMap<>() -ээр initialize хий

    // ─────── 🟡 Stretch: item types ───────
    // TODO: private Map<String, ItemType> itemTypes
    // - HashMap<>() -ээр initialize хий

    // TODO: addItem(String name) → void
    // - items.merge(name, 1, Integer::sum) эсвэл if/else

    // TODO: removeItem(String name) → void
    // - count буурна
    // - 0 болох эсвэл доош орвол entry устгана

    // TODO: hasItem(String name) → boolean
    // - Map-д байна уу, count > 0 уу гэдгийг шалгана

    // TODO: getCount(String name) → int
    // - items-с count эсвэл 0

    // ─────── 🟡 Stretch (30 оноо) ───────

    // TODO: addItem(String name, ItemType type) → void
    // - count нэмэх ба itemTypes-д type-ийг хадгална

    // TODO: groupByType() → Map<ItemType, List<String>>
    // - itemTypes-аас ItemType тус бүрд тухайн item нэрсийн жагсаалтыг цуглуулна
    // - зөвхөн одоо inventory-д count > 0 байгаа item-ийг тооно
}
