package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.Item;
import Project3.com.welcome_home.entities.Location;
import Project3.com.welcome_home.entities.LocationId;
import Project3.com.welcome_home.model.Query2;
import Project3.com.welcome_home.repositories.ItemRepository;
import Project3.com.welcome_home.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final ItemRepository itemRepository;

    public LocationService(LocationRepository locationRepository, ItemRepository itemRepository) {
        this.locationRepository = locationRepository;
        this.itemRepository = itemRepository = itemRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocation(int roomNum, int shelfNum) {
        // Create a LocationId object
        LocationId id = new LocationId(roomNum, shelfNum);
        return locationRepository.findById(id);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public void deleteLocation(int roomNum, int shelfNum) {
        // Create a LocationId object
        LocationId id = new LocationId(roomNum, shelfNum);
        locationRepository.deleteById(id);
    }

    public List<Query2> getLocationsByItemId(Integer itemId) throws Exception {
        Optional<Item> item = itemRepository.findItemByItemID(itemId);
        Optional<List<Query2>> optionalLocations = null;
        if(item.isPresent()) {
            optionalLocations = locationRepository.findLocationsCustomByItemId(itemId);
        } else {
            throw new Exception("No item with this itemID present.");
        }

        if(optionalLocations == null || optionalLocations.isEmpty()) {
            throw new Exception("No locations found.");
        }

        return optionalLocations.get();

    }
}
