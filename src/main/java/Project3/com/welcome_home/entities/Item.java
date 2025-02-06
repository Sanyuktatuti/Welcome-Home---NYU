package Project3.com.welcome_home.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID", nullable = false)
    private Integer ItemID;

    @Column(name = "iDescription")
    private String iDescription;

    @Column(name = "photo")
    private String photo;

    @Column(name = "color")
    private String color;

    @Column(name = "isNew", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isNew = true;

    @Column(name = "hasPieces")
    private Boolean hasPieces;

    @Column(name = "material")
    private String material;

    @Column(name = "mainCategory", insertable = false, updatable = false)
    private String mainCategory;

    @Column(name = "subCategory", insertable = false, updatable = false)
    private String subCategory;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "mainCategory", referencedColumnName = "mainCategory", nullable = false),
            @JoinColumn(name = "subCategory", referencedColumnName = "subCategory", nullable = false)
    })
    private Category category;

    // Getters and Setters
    public Integer getItemID() {
        return ItemID;
    }

    public void setItemID(Integer itemID) {
        this.ItemID = itemID;
    }

    public String getiDescription() {
        return iDescription;
    }

    public void setiDescription(String iDescription) {
        this.iDescription = iDescription;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getHasPieces() {
        return hasPieces;
    }

    public void setHasPieces(Boolean hasPieces) {
        this.hasPieces = hasPieces;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
