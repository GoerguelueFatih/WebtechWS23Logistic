package de.htwberlin.webtech.Logistic.web;

import de.htwberlin.webtech.Logistic.model.Item;
import de.htwberlin.webtech.Logistic.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/item")
@RequiredArgsConstructor
public class ItemRestController {

    private final ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @GetMapping
    public List<Item> findAll(@RequestParam(required = false) String name){
        if(name != null){
            return itemService.searchByName(name);
        }
        return itemService.getAllItems();
    }
}
