package de.htwberlin.webtech.Logistic.service;

import de.htwberlin.webtech.Logistic.model.Item;
import de.htwberlin.webtech.Logistic.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.UUID;

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


    public Optional<Item> updateItem(String itemId, Item updatedItem) {
        Optional<Item> optionalItem = itemRepository.findById(Long.valueOf(itemId));
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setAbteilung(updatedItem.getAbteilung());
            existingItem.setAnzahl(updatedItem.getAnzahl());
            itemRepository.save(existingItem);
            return Optional.of(existingItem);
        } else {
            return Optional.empty();
        }
    }

    public void deleteItem(String itemId) {
        itemRepository.deleteById(Long.valueOf(itemId));
    }
}