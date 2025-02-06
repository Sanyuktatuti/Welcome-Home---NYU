package Project3.com.welcome_home.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ItemPiece {
    public String pDescription;
    public Integer length;
    public Integer width;
    public Integer height;
    public String pNotes;
    public Integer roomNum;
    public Integer shelfNum;
}
