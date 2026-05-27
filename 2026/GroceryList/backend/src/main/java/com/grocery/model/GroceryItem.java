package com.grocery.model;

import javax.persistence.*;

@Entity
@Table(name = "grocery_items")
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer quantity = 1;

    @Column(length = 20)
    private String unit;

    @Column(length = 100)
    private String category;

    @Column(nullable = false)
    private boolean purchased = false;

    public GroceryItem() {
    }

    public GroceryItem(String name, Integer quantity, String unit, String category, boolean purchased) {
        this.name = name;
        this.quantity = quantity != null ? quantity : 1;
        this.unit = unit;
        this.category = category;
        this.purchased = purchased;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity != null ? quantity : 1;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
}
