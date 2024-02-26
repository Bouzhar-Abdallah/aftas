package bouzhar.aftas.demo;

import bouzhar.aftas.demo.entity.Member;
import bouzhar.aftas.demo.enums.IdentityDocumentType;
import bouzhar.aftas.demo.enums.Role;
import bouzhar.aftas.demo.repository.MemberRepository;
import bouzhar.aftas.demo.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner initUser(MemberRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        return args -> {
            Member user = new Member();
            user.setName("John");
            user.setFamilyName("Doe");
            user.setEmail("user@example.com");
            user.setPassword(passwordEncoder.encode("password"));
            user.setAccessionDate(LocalDate.now());
            user.setNationality("US");
            user.setIdentityDocumentType(IdentityDocumentType.CIN);
            user.setIdentityNumber("123456789");
            user.setRole(Role.ADHERENT);
            repository.save(user);
            String jwt = jwtService.generateToken(user);
            System.out.println("JWT for new user: " + jwt);
            /*********/
            Member user2 = new Member();
            user2.setName("John");
            user2.setFamilyName("Doe");
            user2.setEmail("jury@example.com");
            user2.setPassword(passwordEncoder.encode("password"));
            user2.setAccessionDate(LocalDate.now());
            user2.setNationality("US");
            user2.setIdentityDocumentType(IdentityDocumentType.PASSPORT);
            user2.setIdentityNumber("123456789");
            user2.setRole(Role.JURY);
            repository.save(user2);
            String jury_jwt = jwtService.generateToken(user);
            System.out.println("JWT for new user: " + jury_jwt);

            /*********/
            Member user3 = new Member();
            user3.setName("John");
            user3.setFamilyName("Doe");
            user3.setEmail("manager@example.com");
            user3.setPassword(passwordEncoder.encode("password"));
            user3.setAccessionDate(LocalDate.now());
            user3.setNationality("US");
            user3.setIdentityDocumentType(IdentityDocumentType.PASSPORT);
            user3.setIdentityNumber("123456789");
            user3.setRole(Role.MANAGER);
            repository.save(user3);
            String manager_jwt = jwtService.generateToken(user);
            System.out.println("JWT for new user: " + manager_jwt);
        };
    }
}
