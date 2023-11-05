package de.htwberlin.webtech.Logistic.service;

import de.htwberlin.webtech.Logistic.REST.ItemManipulationRequest;
import de.htwberlin.webtech.Logistic.model.Item;
import de.htwberlin.webtech.Logistic.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Item create(ItemManipulationRequest request) {
        var item = new Item(
                request.getAbteilung(),
                request.getAnzahl(),
                request.getName());
        itemRepository.save(item);
        return transformEntity(item);
    }

    public Item transformEntity(Item item) {
        return new Item(
                item.getAbteilung(),
                item.getAnzahl(),
                item.getName());
    }

    public Item findById(Long id) {
        var item = itemRepository.findById(id);
        return item.map(this::transformEntity).orElse(null);
    }


    public Item update(Long id, ItemManipulationRequest request) {
        var itemOptional = itemRepository.findById(id);
        if(itemOptional.isEmpty()){
            return null;
        }
        var item = itemOptional.get();
        item.setAbteilung(request.getAbteilung());
        item.setAnzahl(request.getAnzahl());
        item.setName(request.getName());
        itemRepository.save(item);

        return transformEntity(item);
    }

    public boolean deleteById(Long id) {
        var itemOptional = itemRepository.findById(id);
        if(itemOptional.isEmpty()){
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }

}