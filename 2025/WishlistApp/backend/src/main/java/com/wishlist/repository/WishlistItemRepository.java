package com.wishlist.repository;

import com.wishlist.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    @Query("SELECT w FROM WishlistItem w WHERE LOWER(w.name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(w.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<WishlistItem> searchByNameOrDescription(@Param("query") String query);

    List<WishlistItem> findByCategory(String category);
    List<WishlistItem> findByStatus(WishlistItem.Status status);
    List<WishlistItem> findByPriority(WishlistItem.Priority priority);
}

