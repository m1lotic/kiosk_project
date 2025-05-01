package deep.service;

import deep.model.Menu;
import deep.model.MenuItem;
import deep.model.UserType;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private Scanner scanner;

    private final Cart cart = new Cart();

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.scanner = new Scanner(System.in);
    }

    private void handleOrderMenu() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다. 주문할 수 없습니다.");
            return;
        }
        cart.printCart();
        System.out.println("1. 주문  2. 메뉴판");
        int sel = readInt();

        if (sel == 1) {

            System.out.println("할인 정보를 입력해주세요.");
            System.out.println("1. 국가유공자 : 10%\n2. 군인 : 5%\n3. 학생 : 3%\n4. 일반 : 0%");
            int typeInput = readInt();

            try {
                UserType user = UserType.fromSelection(typeInput);
                double discountedPrice = cart.getTotalPrice() * (1 - user.getDiscountRate());
                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", discountedPrice);
                cart.clear();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void addItemToCart(MenuItem menuItem) {
        System.out.println("수량을 입력해주세요:");
        int quantity = readInt();
        cart.addItem(menuItem, quantity); // 장바구니에 아이템 추가
        System.out.println(menuItem.getName() + "가 장바구니에 추가되었습니다.");
    }


    public void start() {
        while (true) {
            System.out.println("\n[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료 | 종료");

            int categoryInput = readInt();
            if (categoryInput == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (categoryInput < 1 || categoryInput > menus.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            Menu selectedMenu = menus.get(categoryInput - 1);
            System.out.printf("\n[ %s MENU ]\n", selectedMenu.getCategoryName());
            List<MenuItem> items = selectedMenu.getMenuItems();

            for (int i = 0; i < items.size(); i++) {
                MenuItem item = items.get(i);
                System.out.printf("%d. %s | W %.1f | %s\n", i + 1, item.getName(), item.getPrice(), item.getDescription());
            }
            System.out.println("0. 뒤로가기");

            int itemInput = readInt();
            if (itemInput == 0) continue;
            if (itemInput < 1 || itemInput > items.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            MenuItem selectedItem = items.get(itemInput - 1);
            System.out.printf("선택한 메뉴: %s | W %.1f | %s\n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());

            //장바구니 기능 추가
            System.out.println("이 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 추가  2. 취소");
            int addChoice = readInt();
            if (addChoice == 1) {
                addItemToCart(selectedItem);  // 장바구니에 추가
            }

            // 주문 관련 처리
            System.out.println("장바구니를 확인하시겠습니까?");
            System.out.println("1. 장바구니  2. 메뉴판");
            int cartChoice = readInt();
            if (cartChoice == 1) {
                handleOrderMenu();  // 주문 처리
            }
        }
    }

    private int readInt() { // 오입력 help 메서드
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
