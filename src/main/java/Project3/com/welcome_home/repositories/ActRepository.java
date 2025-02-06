package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Act;
import Project3.com.welcome_home.entities.ActId;
import Project3.com.welcome_home.model.Query4b;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ActRepository extends JpaRepository<Act, ActId> {
    @Query(value = "select a.roleID from Act a where a.userName=:userName", nativeQuery = true)
    Optional<List<Query4b>> findRoleIDListByUserName(String userName);

    @Query(value = "SELECT * FROM Act a where a.userName=:username", nativeQuery = true)
    Optional<List<Act>> findByUserName(String username);

    @Query("SELECT a FROM Act a WHERE a.person.userName = :userName")
    Optional<String> findRoleByUserName(String userName);
}
