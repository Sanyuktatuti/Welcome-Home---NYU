package Project3.com.welcome_home.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;

@Entity
public class PieceIn {

    @EmbeddedId
    private PieceInId pieceInId;

    // Constructors, Getters, Setters
    public PieceIn() {}

    public PieceIn(PieceInId pieceInId) {
        this.pieceInId = pieceInId;
    }

    public PieceInId getPieceInId() {
        return pieceInId;
    }

    public void setPieceInId(PieceInId pieceInId) {
        this.pieceInId = pieceInId;
    }
}
