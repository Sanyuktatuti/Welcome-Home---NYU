package Project3.com.welcome_home.model;

import lombok.Data;

import java.util.List;

@Data
public class Donation {
    public String iDescription;
    public String photo;
    public String color;
    public Boolean isNew;
    public Boolean hasPieces;
    public String material;
    public String mainCategory;
    public String subCategory;
    public String userName;
    public List<ItemPiece> pieces;
}
