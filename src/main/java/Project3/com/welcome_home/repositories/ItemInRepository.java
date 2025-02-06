package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.ItemIn;
import Project3.com.welcome_home.entities.ItemInId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemInRepository extends JpaRepository<ItemIn, ItemInId> {
    @Query(value = "SELECT * from ItemIn i where i.ItemId=:itemID", nativeQuery = true)
    Optional<ItemIn> findByItemID(Integer itemID);
}
