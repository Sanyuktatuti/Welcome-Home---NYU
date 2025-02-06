package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<Ordered, Integer> {
}
