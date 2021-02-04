package ru.onyxone.utils;

import ru.onyxone.models.Role;
import ru.onyxone.services.UserManager;

import java.util.HashSet;
import java.util.Set;

public class Util {
    public static Set<Role> getRoles(String[] roles, UserManager userManager) {
        Set<Role> roleSet = new HashSet<>();
        for (int i = 0; i < roles.length; i++) {
            int finalI = i;
            roleSet.add(userManager.getRoleByName(roles[i]).orElseGet(() -> {
                userManager.createRole(new Role(roles[finalI]));
                return userManager.getRoleByName(roles[finalI]).get();
            }));
        }
        return roleSet;
    }
}
