package Project3.com.welcome_home.entities;

import jakarta.persistence.*;

@Entity
@IdClass(PieceId.class)
public class Piece {

    @Id
    @Column(name = "ItemID")
    private Integer ItemID;

    @Id
    @Column(name = "pieceNum")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pieceNum;

    @Column(name = "pDescription")
    private String pDescription;

    @Column
    private Integer length;

    @Column
    private Integer width;

    @Column
    private Integer height;

    @Column
    private String pNotes;

    // Foreign key references (if needed)
    @Column(name = "roomNum", insertable = false, updatable = false)
    private Integer roomNum;
    @Column(name = "shelfNum", insertable = false, updatable = false)
    private Integer shelfNum;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "roomNum", referencedColumnName = "roomNum", nullable = false),
            @JoinColumn(name = "shelfNum", referencedColumnName = "shelfNum", nullable = false)
    })
    private Location location;

    // Default constructor
    public Piece() {}

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

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getpNotes() {
        return pNotes;
    }

    public void setpNotes(String pNotes) {
        this.pNotes = pNotes;
    }

    public Integer getRoomNum() {
        return this.location.getRoomNum();
    }

    public void setRoomNum(Integer roomNum) {
        this.location.setRoomNum(roomNum);
    }

    public Integer getShelfNum() {
        return this.location.getShelfNum();
    }

    public void setShelfNum(Integer shelfNum) {
        this.location.setShelfNum(shelfNum);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
