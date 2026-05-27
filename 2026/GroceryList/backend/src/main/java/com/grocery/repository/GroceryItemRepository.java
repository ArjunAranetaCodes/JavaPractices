package com.grocery.repository;

import com.grocery.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

    List<GroceryItem> findByCategoryIgnoreCase(String category);

    List<GroceryItem> findByPurchased(boolean purchased);

    List<GroceryItem> findByNameContainingIgnoreCase(String name);
}
