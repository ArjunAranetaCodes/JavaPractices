package com.contact.service;

import com.contact.model.Contact;
import com.contact.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public List<Contact> getAll() {
        return repository.findAll();
    }

    public Contact getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id " + id));
    }

    public List<Contact> searchByName(String term) {
        if (term == null || term.isBlank()) {
            return getAll();
        }
        return repository.findByLastNameContainingIgnoreCase(term.trim());
    }

    public List<Contact> searchByCompany(String term) {
        if (term == null || term.isBlank()) {
            return getAll();
        }
        return repository.findByCompanyContainingIgnoreCase(term.trim());
    }

    public List<Contact> getFavorites() {
        return repository.findByFavoriteTrue();
    }

    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    public Contact update(Long id, Contact data) {
        Contact existing = getById(id);
        existing.setFirstName(data.getFirstName());
        existing.setLastName(data.getLastName());
        existing.setEmail(data.getEmail());
        existing.setPhone(data.getPhone());
        existing.setCompany(data.getCompany());
        existing.setJobTitle(data.getJobTitle());
        existing.setNotes(data.getNotes());
        existing.setFavorite(data.isFavorite());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Contact existing = getById(id);
        repository.delete(existing);
    }
}

