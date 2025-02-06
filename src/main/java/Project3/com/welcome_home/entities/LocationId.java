package Project3.com.welcome_home.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LocationId implements Serializable {

    private int roomNum;
    private int shelfNum;

    public LocationId() {
    }

    public LocationId(int roomNum, int shelfNum) {
        this.roomNum = roomNum;
        this.shelfNum = shelfNum;
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
        LocationId that = (LocationId) o;
        return roomNum == that.roomNum && shelfNum == that.shelfNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNum, shelfNum);
    }
}
