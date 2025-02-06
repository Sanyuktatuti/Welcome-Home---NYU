package Project3.com.welcome_home.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Id;

@Entity
@IdClass(CategoryId.class)
public class Category {

    @Id
    private String mainCategory;

    @Id
    private String subCategory;

    private String catNotes;

    // Default constructor
    public Category() {}

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

    public String getCatNotes() {
        return catNotes;
    }

    public void setCatNotes(String catNotes) {
        this.catNotes = catNotes;
    }
}
