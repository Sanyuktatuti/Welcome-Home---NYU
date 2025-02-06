package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Person;
import Project3.com.welcome_home.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Endpoint to get all persons
    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
}
