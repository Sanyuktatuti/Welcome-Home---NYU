package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRoleID(String roleID);
}
