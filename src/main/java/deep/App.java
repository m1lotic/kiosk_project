package deep;

import deep.model.Menu;
import deep.model.MenuItem;
import deep.service.Kiosk;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();

        Menu burgers = new Menu("Burgers");
        burgers.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinks = new Menu("Drinks");
        drinks.addMenuItem(new MenuItem("Coke", 2.0, "시원한 코카콜라"));
        drinks.addMenuItem(new MenuItem("Sprite", 2.0, "상큼한 스프라이트"));

        Menu desserts = new Menu("Desserts");
        desserts.addMenuItem(new MenuItem("Ice Cream", 3.0, "바닐라 아이스크림"));
        desserts.addMenuItem(new MenuItem("Shake", 4.0, "초코 쉐이크"));

        menus.add(burgers);
        menus.add(drinks);
        menus.add(desserts);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
