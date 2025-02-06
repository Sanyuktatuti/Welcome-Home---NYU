package Project3.com.welcome_home.model;

import lombok.Data;

@Data
public class ItemDT {
    public Integer ItemId;
    public String iDescription;
    public String photo;
    public String color;
    public Boolean isNew;
    public Boolean hasPieces;
    public String material;
    public String mainCategory;
    public String subCategory;
}
