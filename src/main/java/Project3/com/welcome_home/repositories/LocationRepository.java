package Project3.com.welcome_home.repositories;

import Project3.com.welcome_home.entities.Location;
import Project3.com.welcome_home.entities.LocationId;
import Project3.com.welcome_home.model.Query2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, LocationId> {
    @Query(value = "select p.ItemID, p.pieceNum, p.pDescription, l.roomNum, l.shelfNum, l.shelfDescription from Piece p join Location l on p.roomNum = l.roomNum where p.ItemID=:itemId", nativeQuery = true)
    Optional<List<Query2>> findLocationsCustomByItemId(@Param("itemId") Integer itemId);

    @Query(value = "SELECT * from Location l where l.roomNum=:roomNum and l.shelfNum=:shelfNum", nativeQuery = true)
    Optional<Location> findByRoomNumAndShelfNum(Integer roomNum, Integer shelfNum);
}
