package io.mpj.in28minutes.unittesting.unittesting.data;

import io.mpj.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
