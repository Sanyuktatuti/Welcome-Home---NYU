package Project3.com.welcome_home.controllers;

import Project3.com.welcome_home.entities.Role;
import Project3.com.welcome_home.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping("/{roleID}")
    public Role getRole(@PathVariable String roleID) {
        return roleService.getRole(roleID);
    }
}
