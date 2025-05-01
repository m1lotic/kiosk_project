package deep.service;

import deep.model.CartItem;
import deep.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(MenuItem item, int quantity) {
        for (CartItem ci : items) {
            if (ci.getItem().equals(item)) {
                return;
            }
        }
        items.add(new CartItem(item, quantity));
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum(); // getTotalPrice 호출 후 double로 변경 -> 합
    }

    public void printCart() {
        System.out.println("[ Orders ]");
        items.forEach(System.out::println); // 각 요소를 println으로 호출 = items -> System.out.println(item)
        System.out.println("\n[ Total ]");
        System.out.println("W " + getTotalPrice());
    }
}