package com.synergisticit.actuator.info;

import com.synergisticit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInfoContributor implements InfoContributor {

    @Autowired
    UserRepository userRepository;
    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("users", userRepository.findAll()).build().getDetails();

        builder.withDetail("Project", "Spring boot actuator").build().getDetails();
        builder.withDetail("instructor", "Dinesh").build().getDetails();
        builder.withDetail("HR", "Mousumi").build().getDetails();
        builder.withDetail("Employees", List.of("Benjamin, Nilay, Gesang, David")).build().getDetails();



    }
}
