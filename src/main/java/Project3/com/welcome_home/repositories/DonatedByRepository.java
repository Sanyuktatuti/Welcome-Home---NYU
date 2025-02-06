package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.DonatedBy;
import Project3.com.welcome_home.entities.DonatedById;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonatedByRepository extends JpaRepository<DonatedBy, DonatedById> {
}
