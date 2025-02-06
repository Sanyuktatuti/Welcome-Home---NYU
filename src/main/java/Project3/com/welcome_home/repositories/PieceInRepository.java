package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.PieceIn;
import Project3.com.welcome_home.entities.PieceInId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceInRepository extends JpaRepository<PieceIn, PieceInId> {
    // Custom queries if needed
}
