package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.PieceIn;
import Project3.com.welcome_home.entities.PieceInId;
import Project3.com.welcome_home.services.PieceInService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/piece-in")
public class PieceInController {

    private final PieceInService pieceInService;

    public PieceInController(PieceInService pieceInService) {
        this.pieceInService = pieceInService;
    }

    @GetMapping("/{pieceNum}/{roomNum}/{shelfNum}")
    public Optional<PieceIn> getPieceIn(@PathVariable int pieceNum, @PathVariable int roomNum, @PathVariable int shelfNum) {
        // Create the composite key PieceInId
        PieceInId pieceInId = new PieceInId(pieceNum, roomNum, shelfNum);
        return pieceInService.getPieceIn(pieceInId);
    }

    @PostMapping
    public PieceIn savePieceIn(@RequestBody PieceIn pieceIn) {
        return pieceInService.savePieceIn(pieceIn);
    }
}
