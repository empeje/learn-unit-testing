package io.mpj.in28minutes.unittesting.unittesting.business;

import io.mpj.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retrieveHarcodedItem(){
        return new Item(1, "Ball", 10, 100);
    }
}
