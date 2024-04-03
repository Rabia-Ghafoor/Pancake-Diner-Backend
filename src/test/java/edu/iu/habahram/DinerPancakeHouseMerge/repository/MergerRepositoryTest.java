package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MergerRepositoryTest {

    @Test
    void test1() {

        MenuComponent allMenus = new Menu("ALL MENUS", "ALL menus combined");

        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU","Breakfast"));



    }

    while(iterator.hasNext()){
        MenuComponent menuComponent = iterator.next();

        System.out.println(menuComponent.getName());
    }
}