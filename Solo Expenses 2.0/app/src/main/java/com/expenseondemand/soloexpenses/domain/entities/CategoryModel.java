package com.expenseondemand.soloexpenses.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {

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

    protected CategoryModel(Parcel in) {
        categoryId = in.readInt();
        resId = in.readInt();
        categoryName = in.readString();
        isFav = in.readByte() != 0;
        baseCategory = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(categoryId);
        dest.writeInt(resId);
        dest.writeString(categoryName);
        dest.writeByte((byte) (isFav ? 1 : 0));
        dest.writeInt(baseCategory);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel in) {
            return new CategoryModel(in);
        }

        @Override
        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
        }
    };

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
