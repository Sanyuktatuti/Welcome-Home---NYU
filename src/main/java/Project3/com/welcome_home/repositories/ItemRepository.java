package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query(value = "SELECT * FROM Item i where i.ItemID=:ItemID", nativeQuery = true)
    Optional<Item> findByItemID(Integer ItemID);

    @Query("select i.ItemID from Item i where i.ItemID=:itemid")
    Optional<Item> findItemByItemID(@Param("itemid") Integer itemid);

    @Query(value = "SELECT * from Item i where i.mainCategory=:mainCategory and i.subCategory=:subCategory", nativeQuery = true)
    Optional<List<Item>> findItemByMainCategoryAndSubCategory(String mainCategory, String subCategory);
}
