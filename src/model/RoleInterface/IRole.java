package model.RoleInterface;

import model.role.Role;
import model.role.RoleName;

import java.util.List;

public interface IRole {
    List<Role> findAll();
    Role findByName(RoleName name);

}
