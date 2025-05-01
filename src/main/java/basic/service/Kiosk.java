package basic.service;

import basic.model.Menu;
import basic.model.MenuItem;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private Scanner scanner;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.scanner = new Scanner(System.in);
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