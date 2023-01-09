package io.mpj.in28minutes.unittesting.unittesting.controller;

import io.mpj.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import io.mpj.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }
    @GetMapping("/item-from-business-service")
    public Item itemForBusinessService() {
        return itemBusinessService.retrieveHarcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return itemBusinessService.retrieveAllItems();
    }
}
