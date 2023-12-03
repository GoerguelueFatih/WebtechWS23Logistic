package de.htwberlin.webtech.Logistic.web;

import de.htwberlin.webtech.Logistic.model.Item;
import de.htwberlin.webtech.Logistic.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemRestController {

    private final ItemService itemService;


    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @GetMapping
    public List<Item> getAllItems(@RequestParam(required = false) String name){
        if(name != null){
            return itemService.searchByName(name);
        }
        return itemService.getAllItems();
    }

    @PutMapping
    public Optional<Item> updateItem(@RequestParam String id, @RequestBody Item item){
        return itemService.updateItem(id, item);
    }

    @DeleteMapping
    public void deleteItem(String itemId) {
        itemService.deleteItem(itemId);
    }


}
