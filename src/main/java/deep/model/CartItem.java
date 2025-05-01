package deep.model;

public class CartItem {
    private MenuItem item;
    private int quantity;

    public CartItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    @Override
    public String toString() { //객체를 syso로 출력할 때 toString을 호출하기 때문에 재정의 하여 가독성 챙김
        return item.getName() + " | W " + item.getPrice() + " | 수량: " + quantity;
    }
}
