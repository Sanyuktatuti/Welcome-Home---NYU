package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Act;
import Project3.com.welcome_home.services.ActService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/acts")
public class ActController {

    private final ActService actService;

    public ActController(ActService actService) {
        this.actService = actService;
    }

    @GetMapping
    public List<Act> getAllActs() {
        return actService.getAllActs();
    }

    @GetMapping("/{userName}/{roleID}")
    public Optional<Act> getAct(@PathVariable String userName, @PathVariable String roleID) {
        return actService.getAct(userName, roleID);
    }

    @PostMapping
    public Act createAct(@RequestBody Act act) {
        return actService.saveAct(act);
    }

    @DeleteMapping("/{userName}/{roleID}")
    public void deleteAct(@PathVariable String userName, @PathVariable String roleID) {
        actService.deleteAct(userName, roleID);
    }

    @GetMapping("/user/{userName}")
    public Map<Boolean, String> checkRegisteredUserAsDonor(@PathVariable String userName) {
        return actService.checkRegisteredUserAsDonor(userName);
    }
}
