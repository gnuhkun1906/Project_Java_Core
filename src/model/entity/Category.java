package model.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = -5744273934121572170L;
    private int categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return
                "CategoryId: " + categoryId + "\t\t\t" + "Category Name: " + categoryName;
    }
}
