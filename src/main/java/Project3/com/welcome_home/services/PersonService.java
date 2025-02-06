package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.Person;
import Project3.com.welcome_home.entities.Act;
import Project3.com.welcome_home.model.RegisterPersonDT;
import Project3.com.welcome_home.repositories.PersonRepository;
import Project3.com.welcome_home.repositories.ActRepository;
import Project3.com.welcome_home.repositories.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ActRepository actRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public PersonService(PersonRepository personRepository, ActRepository actRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.actRepository = actRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.roleRepository = roleRepository;
    }

    // Register a user (salt and hash the password)
    public Map<Boolean, String> registerUser(RegisterPersonDT person) {
        HashMap map = new HashMap<Boolean, String>();
        Person newPerson = new Person();
        if(personRepository.findByUserName(person.getUserName()).isPresent()) {
            map.put(false, "Username already exists");
            return map;
        }
        newPerson.setUserName(person.getUserName());
        newPerson.setPassword(passwordEncoder.encode(person.getPassword()));  // Hash the password before saving
        newPerson.setEmail(person.getEmail());
        newPerson.setFname(person.getFname());
        newPerson.setLname(person.getLname());
        this.personRepository.save(newPerson);

        Act newAct = new Act();
        newAct.setUserName(newPerson.getUserName());
        newAct.setRoleID(person.getRole());
        newAct.setPerson(newPerson);
        newAct.setRole(this.roleRepository.findById(person.getRole()).get());
        this.actRepository.save(newAct);

        map.put(true, "Successfully registered.");
        return map;
    }

    // Find user by username
    public Optional<Person> findFullPersonByUserName(String userName) {
        return personRepository.findFullPersonByUserName(userName);
    }

    // Validate the entered password with the stored hashed password
    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    // Get all persons
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Fetch roles associated with the user
    public Set<Act> getRolesByUserName(String userName) {
        Optional<Person> personOpt = personRepository.findFullPersonByUserName(userName);
        return personOpt.map(Person::getRoles).orElse(null);
    }
}
