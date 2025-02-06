package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.DonatedBy;
import Project3.com.welcome_home.model.Donation;
import Project3.com.welcome_home.services.DonatedByService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/donations")
public class DonatedByController {

    private final DonatedByService donatedByService;

    public DonatedByController(DonatedByService donatedByService) {
        this.donatedByService = donatedByService;
    }

    @GetMapping
    public List<DonatedBy> getAllDonations() {
        return donatedByService.getAllDonations();
    }

    @GetMapping("/{itemID}/{userName}")
    public Optional<DonatedBy> getDonation(@PathVariable Integer itemID, @PathVariable String userName) {
        return donatedByService.getDonation(itemID, userName);
    }

    @PostMapping
    public DonatedBy createDonation(@RequestBody DonatedBy donatedBy) {
        return donatedByService.saveDonation(donatedBy);
    }

    @DeleteMapping("/{itemID}/{userName}")
    public void deleteDonation(@PathVariable Integer itemID, @PathVariable String userName) {
        donatedByService.deleteDonation(itemID, userName);
    }

    @PostMapping("/madeADonation")
    public Map<Boolean, String> madeADonation(@RequestBody Donation donation) throws Exception {
        return donatedByService.madeADonation(donation);
    }
}
