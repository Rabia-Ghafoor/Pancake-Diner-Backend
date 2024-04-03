package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController @CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    MergerRepository mergerRepository;
    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }
    @GetMapping
    public List<MenuItemRecord> get(){
        List <MenuItemRecord> items = mergerRepository.getTheMenuItems();
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
    public List<MenuItem> get() {
        List<MenuItem> menuItems = new ArrayList<>();
        Iterator<MenuItem> lunchItems = mergerRepository.getTheMenuIterator();
        while(lunchItems.hasNext()) {
            menuItems.add(lunchItems.next());
        }

        Iterator<MenuItem> breakfastItems = mergerRepository.getTheMenuIterator();
        while(breakfastItems.hasNext()) {
            menuItems.add(breakfastItems.next());
        }
        return menuItems;
    }
}
