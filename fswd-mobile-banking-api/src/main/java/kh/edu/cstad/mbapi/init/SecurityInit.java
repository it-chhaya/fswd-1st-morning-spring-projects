package kh.edu.cstad.mbapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.cstad.mbapi.domain.Role;
import kh.edu.cstad.mbapi.domain.User;
import kh.edu.cstad.mbapi.repository.RoleRepository;
import kh.edu.cstad.mbapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SecurityInit {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    void init() {

        Role defaultRole = new Role();
        defaultRole.setRole("USER");
        Role admin = new Role();
        admin.setRole("ADMIN");
        Role staff = new Role();
        staff.setRole("STAFF");
        Role customer = new Role();
        customer.setRole("CUSTOMER");

        if (roleRepository.count() == 0) {
            roleRepository.saveAll(List.of(defaultRole,admin,staff,customer));
        }

        if (userRepository.count() == 0) {
            User userAdmin = new User();
            userAdmin.setUsername("admin");
            userAdmin.setPassword(passwordEncoder.encode("pwd@123"));
            userAdmin.setIsEnabled(true);
            userAdmin.setRoles(List.of(defaultRole, admin));

            User userStaff = new User();
            userStaff.setUsername("staff");
            userStaff.setPassword(passwordEncoder.encode("pwd@123"));
            userStaff.setIsEnabled(true);
            userStaff.setRoles(List.of(defaultRole, staff));

            User userCustomer = new User();
            userCustomer.setUsername("customer");
            userCustomer.setPassword(passwordEncoder.encode("pwd@123"));
            userCustomer.setIsEnabled(true);
            userCustomer.setRoles(List.of(defaultRole, customer));

            userRepository.saveAll(List.of(userAdmin,userStaff,userCustomer));
        }
    }

}
