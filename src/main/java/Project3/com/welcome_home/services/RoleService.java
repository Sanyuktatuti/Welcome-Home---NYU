package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.Role;
import Project3.com.welcome_home.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRole(String roleID) {
        return roleRepository.findById(roleID).orElse(null);
    }
}
