package com.contact.controller;

import com.contact.model.Contact;
import com.contact.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> byId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> search(@RequestParam String q) {
        return ResponseEntity.ok(service.searchByName(q));
    }

    @GetMapping("/company")
    public ResponseEntity<List<Contact>> searchByCompany(@RequestParam String q) {
        return ResponseEntity.ok(service.searchByCompany(q));
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Contact>> favorites() {
        return ResponseEntity.ok(service.getFavorites());
    }

    @PostMapping
    public ResponseEntity<Contact> create(@RequestBody Contact contact) {
        Contact created = service.create(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact) {
        try {
            return ResponseEntity.ok(service.update(id, contact));
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

