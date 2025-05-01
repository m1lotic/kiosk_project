package basic;

import basic.model.Menu;
import basic.model.MenuItem;
import basic.service.Kiosk;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // main 메서드는 메뉴판 관리
        // 실 처리는 kiosk에서, 메뉴 생성하여 kiosk에서 List 관련 객체 사용할 때 NullPointerException 에러 예방

        List<Menu> menus = new ArrayList<>();

        Menu burgers = new Menu("Burgers");
        burgers.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinks = new Menu("Drinks");
        drinks.addMenuItem(new MenuItem("Coke", 2.0, "시원한 코카콜라"));
        drinks.addMenuItem(new MenuItem("Sprite", 2.0, "상큼한 스프라이트"));

        menus.add(burgers);
        menus.add(drinks);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}