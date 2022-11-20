package com.cursoplazi.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Category {
    public int categoryId;
    private String category;
    private boolean active;

    public int getcategoryId() {
        return categoryId;
    }

    public void setcategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
