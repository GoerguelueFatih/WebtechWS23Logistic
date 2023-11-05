package de.htwberlin.webtech.Logistic.web;

import de.htwberlin.webtech.Logistic.model.Item;
import de.htwberlin.webtech.Logistic.REST.ItemManipulationRequest;
import de.htwberlin.webtech.Logistic.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ItemRestController {

    private final ItemService itemService;


    @GetMapping(path = "/api/v1/item")
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemService.findAll());
    }

    @PostMapping(path = "/api/v1/item")
    public ResponseEntity<Void> createItem(@RequestBody ItemManipulationRequest request){
        var item = itemService.create(request);
        URI  uri = URI.create("/api/v1/item/" + item.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id){
        var item = itemService.findById(id);
        return item != null? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/item/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable Long id, @RequestBody ItemManipulationRequest request){
        var item = itemService.update(id, request);
        return item != null? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/item/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        boolean success = itemService.deleteById(id);
        return success? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
