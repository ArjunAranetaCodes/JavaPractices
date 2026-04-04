package com.bookmark.repository;

import com.bookmark.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findByCategoryIgnoreCase(String category);

    List<Bookmark> findByTitleContainingIgnoreCaseOrUrlContainingIgnoreCase(String title, String url);
}
