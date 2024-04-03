package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    MergerRepository mergerRepository;
    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }
    @GetMapping
    public List <MenuItemRecord> getItems(){
        List <MenuItemRecord> items = (List<MenuItemRecord>) mergerRepository.getTheMenuItems();
        return items;
    }



//@RestController
//@CrossOrigin
//@RequestMapping("/merger")
//public class MergerController {
//
//    DinerRepository dinerRepository;
//    PancakeHouseRepository pancakeHouseRepository;
//
//    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
//        this.dinerRepository = dinerRepository;
//        this.pancakeHouseRepository = pancakeHouseRepository;
//    }

    @GetMapping
    public List<MenuItemRecord> getMenuItems() {
        return mergerRepository.getTheMenuItems();
    }


    @GetMapping("/vegeterian")
    public List<MenuItem> getVegetarianItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        Iterator<MenuItem> vegetarianItems = mergerRepository.getTheMenuIterator();
        while(vegetarianItems.hasNext()) {
            java.awt.MenuItem menuItem = vegetarianItems.next();
            if(menuItem.isVegetarian()) {
                menuItems.add(menuItem);
            }
        }

        Iterator<java.awt.MenuItem> breakfastItems = mergerRepository.getTheMenuIterator();
        while(breakfastItems.hasNext()) {
            java.awt.MenuItem menuItem = breakfastItems.next();
            if(menuItem.isVegetarian()) {
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }


    @GetMapping("/lunch")
    public List<MenuItem> getLunchItems() {
        List<java.awt.MenuItem> menuItems = new ArrayList<>();
        Iterator<java.awt.MenuItem> lunchItems = mergerRepository.getTheMenuIterator();
        while(lunchItems.hasNext()) {
            java.awt.MenuItem menuItem = lunchItems.next();
            if(menuItem.getDescription().equals("Lunch")) {
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }


    @GetMapping("/breakfast")
    public List<MenuItem> getBreakfastItems() {
        List<java.awt.MenuItem> menuItems = new ArrayList<>();

        Iterator<java.awt.MenuItem> breakfastItems = mergerRepository.getTheMenuIterator();

        while(breakfastItems.hasNext()) {
            java.awt.MenuItem menuItem = breakfastItems.next();
            if(menuItem.getDescription().equals("Breakfast")) {
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }

    @GetMapping("/supper")
    public List<MenuItem> getSupperItems() {

        List<java.awt.MenuItem> menuItems = new ArrayList<>();

        Iterator<java.awt.MenuItem> supperItems = mergerRepository.getTheMenuIterator();
        while(supperItems.hasNext()) {
            java.awt.MenuItem menuItem = supperItems.next();
            if(menuItem.getDescription().equals("Supper")) {
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }

    @GetMapping("/signup")
    public String signUp() {
        //  add name, username, password, email etc


        return "Sign up for the Diner Pancake House Merge!";
    }




}
