
package de.htwberlin.webtech.Logistic.service;

import de.htwberlin.webtech.Logistic.model.Item;
import de.htwberlin.webtech.Logistic.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    public Item createItem(Item item) {
        item.setId(UUID.randomUUID().toString());
        itemRepository.save(item);
        return item;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> searchByName(String name) {
        return itemRepository.findItemsByNameContaining(name);
    }

}