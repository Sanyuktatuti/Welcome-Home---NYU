package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// JpaRepository<Entity, ID Type>
public interface PersonRepository extends JpaRepository<Person, String> {
    @Query(value = "select p.userName from Person p where p.userName=:userName", nativeQuery = true)
    Optional<String> findByUserName(String userName);

    @Query(value = "SELECT * FROM Person p where p.userName=:userName", nativeQuery = true)
    Optional<Person> findPersonByUserName(String userName);

    // Custom Query to find the full Person entity (including password) by userName using JPQL
    @Query("select p from Person p where p.userName = :userName")
    Optional<Person> findFullPersonByUserName(String userName);

}

