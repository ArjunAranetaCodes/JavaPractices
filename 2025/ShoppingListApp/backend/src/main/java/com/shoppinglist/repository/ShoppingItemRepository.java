package com.shoppinglist.repository;

import com.shoppinglist.model.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
    @Query("SELECT s FROM ShoppingItem s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<ShoppingItem> searchByName(@Param("query") String query);

    List<ShoppingItem> findByCategory(String category);
    List<ShoppingItem> findByCompleted(Boolean completed);
    List<ShoppingItem> findByPriority(ShoppingItem.Priority priority);
}







