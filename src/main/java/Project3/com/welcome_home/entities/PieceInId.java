package Project3.com.welcome_home.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PieceInId implements Serializable {

    private int pieceNum;
    private int roomNum;
    private int shelfNum;

    public PieceInId() {}

    public PieceInId(int pieceNum, int roomNum, int shelfNum) {
        this.pieceNum = pieceNum;
        this.roomNum = roomNum;
        this.shelfNum = shelfNum;
    }

    // Getters and Setters
    public int getPieceNum() {
        return pieceNum;
    }

    public void setPieceNum(int pieceNum) {
        this.pieceNum = pieceNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getShelfNum() {
        return shelfNum;
    }

    public void setShelfNum(int shelfNum) {
        this.shelfNum = shelfNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceInId that = (PieceInId) o;
        return pieceNum == that.pieceNum && roomNum == that.roomNum && shelfNum == that.shelfNum;
    }

    @Override
    public int hashCode() {
        return 31 * pieceNum + 31 * roomNum + 31 * shelfNum;
    }
}
