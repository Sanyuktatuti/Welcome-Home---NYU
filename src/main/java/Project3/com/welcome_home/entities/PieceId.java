package Project3.com.welcome_home.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PieceId implements Serializable {

    private Integer ItemID;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pieceNum;

    // Default constructor
    public PieceId() {}

    // Constructor
    public PieceId(Integer ItemId, Integer pieceNum) {
        this.ItemID = ItemId;
        this.pieceNum = pieceNum;
    }

    // Getters and Setters
    public Integer getItemID() {
        return ItemID;
    }

    public void setItemID(Integer itemID) {
        this.ItemID = itemID;
    }

    public Integer getPieceNum() {
        return pieceNum;
    }

    public void setPieceNum(Integer pieceNum) {
        this.pieceNum = pieceNum;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceId pieceId = (PieceId) o;
        return Objects.equals(ItemID, pieceId.ItemID) &&
                Objects.equals(pieceNum, pieceId.pieceNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ItemID, pieceNum);
    }
}
