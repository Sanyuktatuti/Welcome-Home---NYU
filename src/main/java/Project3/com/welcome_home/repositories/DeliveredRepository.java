package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Delivered;
import Project3.com.welcome_home.entities.DeliveredId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveredRepository extends JpaRepository<Delivered, DeliveredId> {
    // Custom queries if needed
}
