package deep.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public String getCategoryName() { return categoryName; }
    public List<MenuItem> getMenuItems() { return menuItems; }
}
