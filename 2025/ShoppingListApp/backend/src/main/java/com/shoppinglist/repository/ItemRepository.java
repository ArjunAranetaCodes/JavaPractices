package com.shoppinglist.repository;

import com.shoppinglist.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNameContainingIgnoreCase(String name);
    List<Item> findByStatus(Item.Status status);
    List<Item> findByCategory(String category);
}

