package model.RoleInterface;

import model.role.Role;
import model.role.RoleName;

import java.util.ArrayList;
import java.util.List;

public class RoleIPLM implements IRole {
    public static List<Role> listRole = new ArrayList<>();

    static {
        listRole.add(new Role(1, RoleName.ADMIN));
        listRole.add(new Role(2, RoleName.USER));
    }

    @Override
    public List<Role> findAll() {
        return listRole;
    }

    @Override
    public Role findByName(RoleName name) {
        for (Role roles : listRole) {
            if (roles.getName() == name) {
                return roles;
            }
        }
        return null;
    }
}
