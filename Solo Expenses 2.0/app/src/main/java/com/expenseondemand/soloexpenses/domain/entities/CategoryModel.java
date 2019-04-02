package com.expenseondemand.soloexpenses.domain.entities;

public class CategoryModel {

    private int categoryId;
    private int resId;
    private String categoryName;
    private boolean isFav;

    public CategoryModel(int categoryId, int resId, String categoryName, boolean isFav) {
        this.categoryId = categoryId;
        this.resId = resId;
        this.categoryName = categoryName;
        this.isFav = isFav;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getResId() {
        return resId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public boolean isFav() {
        return isFav;
    }
}
