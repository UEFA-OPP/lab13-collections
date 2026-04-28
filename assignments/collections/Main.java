package Week13;
import java.util.*;

public class Main {
    static void main() {
        // --- 4-р хэсэг: List дотор object хадгалах (Даалгавар 14-15) ---
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 1000));
        products.add(new Product("Laptop", 2000));
        products.add(new Product("Tablet", 500));

        System.out.println("Бүх бүтээгдэхүүн:");
        for (Product p : products) {
            System.out.println(p.name + " - " + p.price);
        }

        // --- 5-р хэсэг: Integration Challenge (Даалгавар 16-18) ---

        // Shopping Cart: Нийт үнэ бодох
        int totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.price;
        }
        System.out.println("\nНийт үнэ: " + totalPrice);

        // Unique ID: HashSet ашиглах
        HashSet<Integer> productIds = new HashSet<>();
        productIds.add(101);
        productIds.add(102);
        productIds.add(101); // Давхардсан ID нэмэх оролдлого
        System.out.println("Давхардаагүй ID-нууд: " + productIds);

        // Product Map: HashMap ашиглах
        HashMap<String, Integer> productPriceMap = new HashMap<>();
        for (Product p : products) {
            productPriceMap.put(p.name, p.price);
        }

        System.out.println("\nMap-аас хэвлэх (keySet):");
        for (String name : productPriceMap.keySet()) {
            System.out.println("Бүтээгдэхүүн: " + name + ", Үнэ: " + productPriceMap.get(name));
        }
    }
}
