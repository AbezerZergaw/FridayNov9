package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MessageRepo messageRepo;

    @Override
    public void run(String...strings) throws Exception{
        roleRepo.save(new Role("USER"));
        roleRepo.save(new Role("ADMIN"));

        Role adminRole = roleRepo.findByRole("ADMIN");
        Role userRole = roleRepo.findByRole("USER");

        User user = new User("jim@jim.com","password", "jim", "Jimmerson"
        ,true, "jim");

        user.setRoles(Arrays.asList(userRole));
        userRepo.save(user);


        user = new User("admin@admin.com", "password", "Admin", "User",
                true, "admin");

        user.setRoles(Arrays.asList(adminRole));
        userRepo.save(user);


        Message message =new Message("Hello world!", "User", "11-09-2018" );

        messageRepo.save(message);

    }

}
