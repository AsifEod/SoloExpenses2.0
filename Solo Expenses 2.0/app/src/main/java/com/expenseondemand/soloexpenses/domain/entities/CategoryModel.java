package com.expenseondemand.soloexpenses.domain.entities;

public class CategoryModel {

    private int categoryId;
    private int resId;
    private String categoryName;
    private boolean isFav;
    private int baseCategory;

    public CategoryModel(int categoryId, int resId, String categoryName, boolean isFav, int baseCategory) {
        this.categoryId = categoryId;
        this.resId = resId;
        this.categoryName = categoryName;
        this.isFav = isFav;
        this.baseCategory = baseCategory;
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

    public int getBaseCategory() {
        return baseCategory;
    }
}
