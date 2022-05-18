package com.init.jobX;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.init.jobX.segurity.entity.Rol;
import com.init.jobX.segurity.entity.User;
import com.init.jobX.segurity.enums.RolName;
import com.init.jobX.segurity.service.RolService;
import com.init.jobX.segurity.service.UserService;

@SpringBootApplication
public class JobXApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobXApplication.class, args);
	}
	@Bean
    CommandLineRunner runner(UserService userService, RolService rolService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/jobx-users.json");
            try {
                List<User> users = mapper.readValue(inputStream,typeReference);

                Set<Rol> newRole = new HashSet<>();
                newRole.add(rolService.getByRolName(RolName.ROLE_USER).get());


                for (User u: users) {
                    u.setRoles(newRole);
                    try {
                        userService.save(u);
                    }catch (Exception e){
                        e.getMessage();
                    }

                }
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
