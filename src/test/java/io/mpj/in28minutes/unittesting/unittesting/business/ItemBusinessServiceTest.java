package io.mpj.in28minutes.unittesting.unittesting.business;

import io.mpj.in28minutes.unittesting.unittesting.data.ItemRepository;
import io.mpj.in28minutes.unittesting.unittesting.data.SomeDataService;
import io.mpj.in28minutes.unittesting.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
    @InjectMocks
    private ItemBusinessService business;
    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Ball", 10, 10),
                new Item(1, "Ball", 10, 50)
        ));
        List<Item> items = business.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());
        assertEquals(500, items.get(1).getValue());

    }
}
