package Project3.com.welcome_home.entities;

import java.io.Serializable;
import java.util.Objects;

public class CategoryId implements Serializable {

    private String mainCategory;
    private String subCategory;

    // Default constructor
    public CategoryId() {}

    // Constructor
    public CategoryId(String mainCategory, String subCategory) {
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
    }

    // Getters and Setters
    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryId that = (CategoryId) o;
        return Objects.equals(mainCategory, that.mainCategory) &&
                Objects.equals(subCategory, that.subCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainCategory, subCategory);
    }
}
