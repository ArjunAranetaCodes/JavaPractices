package com.eventplanner.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "event_time")
    private LocalTime eventTime;

    @Column
    private String location;

    @Enumerated(EnumType.STRING)
    @Column
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status = Status.UPCOMING;

    @Enumerated(EnumType.STRING)
    @Column
    private Priority priority = Priority.MEDIUM;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Constructors
    public Event() {
    }

    public Event(String title, String description, LocalDate eventDate, LocalTime eventTime,
                 String location, Category category, Status status, Priority priority, String notes) {
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.location = location;
        this.category = category;
        this.status = status;
        this.priority = priority;
        this.notes = notes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public enum Category {
        MEETING, BIRTHDAY, WEDDING, CONFERENCE, WORKSHOP, CONCERT, SPORTS, 
        HOLIDAY, ANNIVERSARY, PARTY, SEMINAR, EXHIBITION, OTHER
    }

    public enum Status {
        UPCOMING, IN_PROGRESS, COMPLETED, CANCELLED
    }

    public enum Priority {
        HIGH, MEDIUM, LOW
    }
}

