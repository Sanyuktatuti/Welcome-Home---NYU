package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.PersonPhone;
import Project3.com.welcome_home.services.PersonPhoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person-phones")
public class PersonPhoneController {

    private final PersonPhoneService personPhoneService;

    public PersonPhoneController(PersonPhoneService personPhoneService) {
        this.personPhoneService = personPhoneService;
    }

    @GetMapping
    public List<PersonPhone> getAllPersonPhones() {
        return personPhoneService.getAllPersonPhones();
    }

    @GetMapping("/{userName}/{phone}")
    public Optional<PersonPhone> getPersonPhone(@PathVariable String userName, @PathVariable String phone) {
        return personPhoneService.getPersonPhone(userName, phone);
    }

    @PostMapping
    public PersonPhone createPersonPhone(@RequestBody PersonPhone personPhone) {
        return personPhoneService.savePersonPhone(personPhone);
    }

    @DeleteMapping("/{userName}/{phone}")
    public void deletePersonPhone(@PathVariable String userName, @PathVariable String phone) {
        personPhoneService.deletePersonPhone(userName, phone);
    }
}
