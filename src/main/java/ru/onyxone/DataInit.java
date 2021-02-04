package ru.onyxone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.onyxone.models.Role;
import ru.onyxone.models.User;
import ru.onyxone.services.UserManager;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInit {
    private final PasswordEncoder passwordEncoder;
    private final UserManager userManager;

    @Autowired
    public DataInit(UserManager userManager, PasswordEncoder passwordEncoder) {
        this.userManager = userManager;
        this.passwordEncoder = passwordEncoder;

        User admin = new User("Admin", "Adminov", "admin@mail.com", passwordEncoder.encode("adminPassword"));
        admin.setRoles(getAddRole(new String[]{"ADMIN", "USER"}));
        this.userManager.create(admin);

        User user = new User("User", "Userov", "user@mail.com", passwordEncoder.encode("userPassword"));
        user.setRoles(getAddRole(new String[]{"USER"}));
        this.userManager.create(user);
    }

    private Set<Role> getAddRole(String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (int i = 0; i < roles.length; i++) {
            int finalI = i;
            roleSet.add(this.userManager.getRoleByName(roles[i]).orElseGet(() -> {
                this.userManager.createRole(new Role(roles[finalI]));
                return this.userManager.getRoleByName(roles[finalI]).get();
            }));
        }
        return roleSet;
    }
}
