package com.emanager.domain;

import java.util.List;

/**
 * Created by cambas on 9/23/13.
 */
public class Category {
    private Integer categoryId;
    private String categoryName;
    private List<Category> subCategories;

    public Category() {
    }

    public Category(List<Category> subCategories, String categoryName, Integer categoryId) {
        this.subCategories = subCategories;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
       
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setName(String categoryName) {
        this.categoryName = categoryName;
    }
}
