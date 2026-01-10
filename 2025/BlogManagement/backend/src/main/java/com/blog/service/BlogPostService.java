package com.blog.service;

import com.blog.model.BlogPost;
import com.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getPostById(Long id) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        return post.orElse(null);
    }

    public List<BlogPost> searchPosts(String query) {
        return blogPostRepository.searchPosts(query);
    }

    public List<BlogPost> getPostsByStatus(BlogPost.Status status) {
        return blogPostRepository.findByStatus(status);
    }

    public List<BlogPost> getPostsByCategory(BlogPost.Category category) {
        return blogPostRepository.findByCategory(category);
    }

    public List<BlogPost> getPostsByAuthor(String author) {
        return blogPostRepository.findByAuthor(author);
    }

    public List<BlogPost> getFeaturedPosts() {
        return blogPostRepository.findByFeatured(true);
    }

    public BlogPost createPost(BlogPost post) {
        if (post.getStatus() == null) {
            post.setStatus(BlogPost.Status.DRAFT);
        }
        if (post.getFeatured() == null) {
            post.setFeatured(false);
        }
        return blogPostRepository.save(post);
    }

    public BlogPost updatePost(Long id, BlogPost postDetails) {
        Optional<BlogPost> optionalPost = blogPostRepository.findById(id);
        if (optionalPost.isPresent()) {
            BlogPost post = optionalPost.get();
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            post.setAuthor(postDetails.getAuthor());
            post.setCategory(postDetails.getCategory());
            post.setTags(postDetails.getTags());
            post.setStatus(postDetails.getStatus());
            post.setPublicationDate(postDetails.getPublicationDate());
            post.setReadingTime(postDetails.getReadingTime());
            post.setFeatured(postDetails.getFeatured() != null ? postDetails.getFeatured() : false);
            post.setExcerpt(postDetails.getExcerpt());
            return blogPostRepository.save(post);
        }
        return null;
    }

    public boolean deletePost(Long id) {
        if (blogPostRepository.existsById(id)) {
            blogPostRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

