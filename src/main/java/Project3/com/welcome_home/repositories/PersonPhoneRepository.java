package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.PersonPhone;
import Project3.com.welcome_home.entities.PersonPhoneId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonPhoneRepository extends JpaRepository<PersonPhone, PersonPhoneId> {
}
