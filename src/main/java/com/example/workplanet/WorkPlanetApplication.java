package com.example.workplanet;

import com.example.workplanet.entities.AppUser;
import com.example.workplanet.entities.JobPost;
import com.example.workplanet.repositories.AppUserRepository;
import com.example.workplanet.repositories.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class WorkPlanetApplication implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(WorkPlanetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser MustiG = new AppUser("MustiG", passwordEncoder.encode("pass"));
        AppUser TimG = new AppUser("TimG", passwordEncoder.encode("pass"));
        System.out.println("Krypterat lösenrod med Bcrypt:" + MustiG.getPassword());
        appUserRepository.saveAll(List.of(MustiG, TimG));

        JobPost jobPost = new JobPost("Programmera", "Java utvecklare", "Hörby", TimG);

        JobPost jobPost1 = new JobPost("Lagerarbetare", "Truckförare", "Rosengård", MustiG);

        jobPostRepository.saveAll(List.of(jobPost,jobPost1));

    }



}
