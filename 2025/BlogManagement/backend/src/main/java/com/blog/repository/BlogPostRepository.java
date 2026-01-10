package com.blog.repository;

import com.blog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    @Query("SELECT p FROM BlogPost p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(p.content) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(p.tags) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<BlogPost> searchPosts(@Param("query") String query);

    List<BlogPost> findByStatus(BlogPost.Status status);
    List<BlogPost> findByCategory(BlogPost.Category category);
    List<BlogPost> findByAuthor(String author);
    List<BlogPost> findByFeatured(Boolean featured);
}

