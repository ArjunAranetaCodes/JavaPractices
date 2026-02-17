package com.blog.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private String author;

    @Enumerated(EnumType.STRING)
    @Column
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String tags; // Comma-separated

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "reading_time")
    private Integer readingTime; // in minutes

    @Column
    private Boolean featured;

    @Column(columnDefinition = "TEXT")
    private String excerpt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) {
            status = Status.DRAFT;
        }
        if (featured == null) {
            featured = false;
        }
        if (readingTime == null && content != null) {
            readingTime = calculateReadingTime(content);
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
        if (readingTime == null && content != null) {
            readingTime = calculateReadingTime(content);
        }
    }

    private Integer calculateReadingTime(String content) {
        if (content == null || content.isEmpty()) {
            return 0;
        }
        // Average reading speed: 200 words per minute
        int wordCount = content.split("\\s+").length;
        return Math.max(1, (int) Math.ceil(wordCount / 200.0));
    }

    // Constructors
    public BlogPost() {
    }

    public BlogPost(String title, String content, String author, Category category,
                   String tags, Status status, LocalDate publicationDate, Integer readingTime,
                   Boolean featured, String excerpt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.tags = tags;
        this.status = status;
        this.publicationDate = publicationDate;
        this.readingTime = readingTime;
        this.featured = featured != null ? featured : false;
        this.excerpt = excerpt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        if (content != null) {
            this.readingTime = calculateReadingTime(content);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getReadingTime() {
        return readingTime != null ? readingTime : 0;
    }

    public void setReadingTime(Integer readingTime) {
        this.readingTime = readingTime;
    }

    public Boolean getFeatured() {
        return featured != null ? featured : false;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured != null ? featured : false;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public enum Status {
        DRAFT, PUBLISHED, ARCHIVED
    }

    public enum Category {
        TECHNOLOGY, LIFESTYLE, TRAVEL, FOOD, HEALTH, BUSINESS, EDUCATION, ENTERTAINMENT, OTHER
    }
}


