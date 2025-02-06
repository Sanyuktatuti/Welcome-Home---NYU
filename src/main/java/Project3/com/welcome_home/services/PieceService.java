package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.Piece;
import Project3.com.welcome_home.entities.PieceId;
import Project3.com.welcome_home.repositories.PieceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PieceService {

    private final PieceRepository pieceRepository;

    public PieceService(PieceRepository pieceRepository) {
        this.pieceRepository = pieceRepository;
    }

    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }

    public Optional<Piece> getPiece(Integer itemID, Integer pieceNum) {
        PieceId id = new PieceId(itemID, pieceNum);
        return pieceRepository.findById(id);
    }

    public Piece savePiece(Piece piece) {
        return pieceRepository.save(piece);
    }

    public void deletePiece(Integer itemID, Integer pieceNum) {
        PieceId id = new PieceId(itemID, pieceNum);
        pieceRepository.deleteById(id);
    }
}
