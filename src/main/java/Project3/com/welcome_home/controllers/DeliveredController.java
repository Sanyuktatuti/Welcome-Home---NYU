package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Delivered;
import Project3.com.welcome_home.entities.DeliveredId;
import Project3.com.welcome_home.services.DeliveredService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/delivered")
public class DeliveredController {

    private final DeliveredService deliveredService;

    public DeliveredController(DeliveredService deliveredService) {
        this.deliveredService = deliveredService;
    }

    @GetMapping("/{userName}/{orderID}")
    public Optional<Delivered> getDelivered(@PathVariable String userName, @PathVariable int orderID) {
        // Create the composite key DeliveredId
        DeliveredId deliveredId = new DeliveredId(userName, orderID);
        return deliveredService.getDelivered(deliveredId);
    }

    @PostMapping
    public Delivered saveDelivered(@RequestBody Delivered delivered) {
        return deliveredService.saveDelivered(delivered);
    }
}
