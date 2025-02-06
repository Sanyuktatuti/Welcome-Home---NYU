package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Location;
import Project3.com.welcome_home.model.Query2;
import Project3.com.welcome_home.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{roomNum}/{shelfNum}")
    public Optional<Location> getLocation(@PathVariable int roomNum, @PathVariable int shelfNum) {
        return locationService.getLocation(roomNum, shelfNum);
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @DeleteMapping("/{roomNum}/{shelfNum}")
    public void deleteLocation(@PathVariable int roomNum, @PathVariable int shelfNum) {
        locationService.deleteLocation(roomNum, shelfNum);
    }

    @GetMapping("/item/{itemId}")
    public List<Query2> getLocation(@PathVariable Integer itemId) throws Exception {
        return locationService.getLocationsByItemId(itemId);
    }
}
