package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.PieceIn;
import Project3.com.welcome_home.entities.PieceInId;
import Project3.com.welcome_home.repositories.PieceInRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PieceInService {

    private final PieceInRepository pieceInRepository;

    public PieceInService(PieceInRepository pieceInRepository) {
        this.pieceInRepository = pieceInRepository;
    }

    // This method should accept PieceInId, not Integer
    public Optional<PieceIn> getPieceIn(PieceInId pieceInId) {
        return pieceInRepository.findById(pieceInId);
    }

    public PieceIn savePieceIn(PieceIn pieceIn) {
        return pieceInRepository.save(pieceIn);
    }
}
