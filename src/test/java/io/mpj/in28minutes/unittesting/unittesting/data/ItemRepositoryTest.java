package io.mpj.in28minutes.unittesting.unittesting.data;

import io.mpj.in28minutes.unittesting.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(6, items.size());
    }

    @Test
    public void testFindById() {
        Item item = repository.findById(20001).orElse(null);
        assertEquals("Item 1 test", item.getName());
    }
}
