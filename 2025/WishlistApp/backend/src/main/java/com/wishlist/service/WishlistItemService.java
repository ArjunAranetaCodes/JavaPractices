package com.wishlist.service;

import com.wishlist.model.WishlistItem;
import com.wishlist.repository.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistItemService {

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    public List<WishlistItem> getAllItems() {
        return wishlistItemRepository.findAll();
    }

    public WishlistItem getItemById(Long id) {
        Optional<WishlistItem> item = wishlistItemRepository.findById(id);
        return item.orElse(null);
    }

    public List<WishlistItem> searchItems(String query) {
        return wishlistItemRepository.searchByNameOrDescription(query);
    }

    public List<WishlistItem> getItemsByCategory(String category) {
        return wishlistItemRepository.findByCategory(category);
    }

    public List<WishlistItem> getItemsByStatus(WishlistItem.Status status) {
        return wishlistItemRepository.findByStatus(status);
    }

    public List<WishlistItem> getItemsByPriority(WishlistItem.Priority priority) {
        return wishlistItemRepository.findByPriority(priority);
    }

    public WishlistItem createItem(WishlistItem item) {
        return wishlistItemRepository.save(item);
    }

    public WishlistItem updateItem(Long id, WishlistItem itemDetails) {
        Optional<WishlistItem> optionalItem = wishlistItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            WishlistItem item = optionalItem.get();
            item.setName(itemDetails.getName());
            item.setDescription(itemDetails.getDescription());
            item.setPrice(itemDetails.getPrice());
            item.setPriority(itemDetails.getPriority());
            item.setStatus(itemDetails.getStatus());
            item.setCategory(itemDetails.getCategory());
            item.setLink(itemDetails.getLink());
            item.setNotes(itemDetails.getNotes());
            return wishlistItemRepository.save(item);
        }
        return null;
    }

    public WishlistItem markAsPurchased(Long id) {
        Optional<WishlistItem> optionalItem = wishlistItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            WishlistItem item = optionalItem.get();
            item.setStatus(WishlistItem.Status.PURCHASED);
            return wishlistItemRepository.save(item);
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        if (wishlistItemRepository.existsById(id)) {
            wishlistItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

