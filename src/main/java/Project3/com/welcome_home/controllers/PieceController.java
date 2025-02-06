package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Piece;
import Project3.com.welcome_home.services.PieceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pieces")
public class PieceController {

    private final PieceService pieceService;

    public PieceController(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @GetMapping
    public List<Piece> getAllPieces() {
        return pieceService.getAllPieces();
    }

    @GetMapping("/{itemID}/{pieceNum}")
    public Optional<Piece> getPiece(@PathVariable Integer itemID, @PathVariable Integer pieceNum) {
        return pieceService.getPiece(itemID, pieceNum);
    }

    @PostMapping
    public Piece createPiece(@RequestBody Piece piece) {
        return pieceService.savePiece(piece);
    }

    @DeleteMapping("/{itemID}/{pieceNum}")
    public void deletePiece(@PathVariable Integer itemID, @PathVariable Integer pieceNum) {
        pieceService.deletePiece(itemID, pieceNum);
    }
}
