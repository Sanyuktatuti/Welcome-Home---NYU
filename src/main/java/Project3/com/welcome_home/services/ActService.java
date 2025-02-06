package Project3.com.welcome_home.services;

import Project3.com.welcome_home.commons.Constants;
import Project3.com.welcome_home.entities.Act;
import Project3.com.welcome_home.entities.ActId;
import Project3.com.welcome_home.entities.Person;
import Project3.com.welcome_home.model.Query4b;
import Project3.com.welcome_home.repositories.ActRepository;
import Project3.com.welcome_home.repositories.PersonPhoneRepository;
import Project3.com.welcome_home.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActService {

    private final ActRepository actRepository;
    private final PersonRepository personRepository;

    public ActService(ActRepository actRepository, PersonRepository personRepository) {
        this.actRepository = actRepository;
        this.personRepository = personRepository;
    }

    public List<Act> getAllActs() {
        return actRepository.findAll();
    }

    public Optional<Act> getAct(String userName, String roleID) {
        // Create ActId object
        ActId id = new ActId(userName, roleID);
        return actRepository.findById(id);
    }

    public Act saveAct(Act act) {
        return actRepository.save(act);
    }

    public void deleteAct(String userName, String roleID) {
        // Create ActId object
        ActId id = new ActId(userName, roleID);
        actRepository.deleteById(id);
    }

    public Map<Boolean, String> checkRegisteredUserAsDonor(String userName){
        HashMap<Boolean, String> map = new HashMap<>();
        Optional<String> personOptional = personRepository.findByUserName(userName);
        if(personOptional.isEmpty()){
            map.put(false, "No person found with this username found.");
            return map;
        }
        String personUsrName = personOptional.get();
        Optional<List<Query4b>> rolesOpt = actRepository.findRoleIDListByUserName(personUsrName);
        if(rolesOpt.isEmpty()){
            map.put(false, "No roles found for this username.");
            return map;
        }
        List<Query4b> roles = rolesOpt.get();
        for(Query4b role : roles){
            System.out.println(role.toString());
            if(role.getRoleID().equals(Constants.donorKey)){
                map.put(true, "Yes, this user is a donor.");
                return map;
            }
        }
        map.put(false, "No, this user is not a donor.");
        return map;
    }
}
