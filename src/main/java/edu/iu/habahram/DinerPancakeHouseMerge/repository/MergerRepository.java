package edu.iu.habahram.DinerPancakeHouseMerge.repository;
import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
public class MergerRepository {

    public List<MenuItemRecord> getTheMenuItems() {
        Iterator<MenuComponent> iterator = getTheMenuIterator();

        List<MenuItemRecord> records = new ArrayList<>();

        while(iterator.hasNext()){
            MenuComponent menuComponent = iterator.next();
            if(menuComponent.getName()=="DINER MENU"){
                DinerMenu dinerMenu = (DinerMenu) menuComponent;
                Iterator<MenuItem> items = dinerMenu.createIterator();
                while(items.hasNext()){
                    MenuItem item = items.next();
                    MenuItemRecord menuItemRecord = new MenuItemRecord(item.getName(),
                            item.getDescription(),
                            item.isVegetarian(),
                            item.getPrice());

                    records.add(menuItemRecord);
                }
            }
            else if(menuComponent.getName()=="PANCAKE HOUSE MENU"){
                BreakfastMenu breakfastMenu = (BreakfastMenu) menuComponent;
                Iterator<MenuItem> items = breakfastMenu.createIterator();
                while(items.hasNext()){
                    MenuItem item = items.next();
                    MenuItemRecord menuItemRecord = new MenuItemRecord(item.getName(),
                            item.getDescription(),
                            item.isVegetarian(),
                            item.getPrice());

                    records.add(menuItemRecord);
                }
            }
            else if(menuComponent.getName()=="CAFE MENU"){
                VegetarianMenu vegetarianMenu = (VegetarianMenu) menuComponent;
                Iterator<MenuItem> items = vegetarianMenu.createIterator();
                while(items.hasNext()){
                    MenuItem item = items.next();
                    MenuItemRecord menuItemRecord = new MenuItemRecord(item.getName(),
                            item.getDescription(),
                            item.isVegetarian(),
                            item.getPrice());

                    records.add(menuItemRecord);
                }
            }
        }
        return records;
    }

    public Iterator<MenuComponent> getTheMenuIterator() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new BreakfastMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new VegetarianMenu("CAFE MENU", "Dinner"));
        return allMenus.createIterator();
    }
}
