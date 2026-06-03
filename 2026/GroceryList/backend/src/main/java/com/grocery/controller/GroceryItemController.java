package com.grocery.controller;

import com.grocery.model.GroceryItem;
import com.grocery.service.GroceryItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:4200")
public class GroceryItemController {

    private final GroceryItemService service;

    public GroceryItemController(GroceryItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> byId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<GroceryItem>> byCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.getByCategory(category));
    }

    @GetMapping("/purchased/{purchased}")
    public ResponseEntity<List<GroceryItem>> byPurchased(@PathVariable boolean purchased) {
        return ResponseEntity.ok(service.getByPurchased(purchased));
    }

    @GetMapping("/search")
    public ResponseEntity<List<GroceryItem>> search(@RequestParam String q) {
        return ResponseEntity.ok(service.search(q));
    }

    @PostMapping
    public ResponseEntity<GroceryItem> create(@RequestBody GroceryItem item) {
        GroceryItem created = service.create(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> update(@PathVariable Long id, @RequestBody GroceryItem item) {
        try {
            return ResponseEntity.ok(service.update(id, item));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
