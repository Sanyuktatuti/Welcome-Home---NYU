package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.PersonPhone;
import Project3.com.welcome_home.entities.PersonPhoneId;
import Project3.com.welcome_home.repositories.PersonPhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonPhoneService {

    private final PersonPhoneRepository personPhoneRepository;

    public PersonPhoneService(PersonPhoneRepository personPhoneRepository) {
        this.personPhoneRepository = personPhoneRepository;
    }

    public List<PersonPhone> getAllPersonPhones() {
        return personPhoneRepository.findAll();
    }

    public PersonPhone savePersonPhone(PersonPhone personPhone) {
        return personPhoneRepository.save(personPhone);
    }

    public void deletePersonPhone(String userName, String phone) {
        PersonPhoneId id = new PersonPhoneId(userName, phone);
        personPhoneRepository.deleteById(id);
    }

    public Optional<PersonPhone> getPersonPhone(String userName, String phone) {
        PersonPhoneId id = new PersonPhoneId(userName, phone);
        return personPhoneRepository.findById(id);
    }
}
