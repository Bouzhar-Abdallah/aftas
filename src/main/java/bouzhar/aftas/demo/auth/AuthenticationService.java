package bouzhar.aftas.demo.auth;


import bouzhar.aftas.demo.entity.Member;
import bouzhar.aftas.demo.repository.MemberRepository;
import bouzhar.aftas.demo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Member user = new Member();
        user.setName(request.getName());
        user.setFamilyName(request.getFamilyName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAccessionDate(request.getAccessionDate());
        user.setNationality(request.getNationality());
        user.setIdentityDocumentType(request.getIdentityDocument());
        user.setIdentityNumber(request.getIdentityNumber());
        user.setRole(request.getRole());
        repository.save(user);
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().Token(jwt).build();
    }

    public HashMap<String, String> login(AuthenticationRequest request) {

        Member user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println(request.getEmail());
        System.out.println("form: ");
        System.out.println(passwordEncoder.encode(request.getPassword()));
        System.out.println("db: ");
        System.out.println(user.getPassword());
        System.out.println("Authentication Service");

        if (request.getEmail() == null || request.getEmail().isEmpty() || request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Email and password must not be empty");
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid email or password");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole().name());
        String jwt = jwtService.generateToken(claims, user);
        HashMap<String, String> loginInfo = new HashMap<>();

        loginInfo.put("token", String.valueOf(AuthenticationResponse.builder().Token(jwt).build().getToken()));
        loginInfo.put("role", user.getRole().name());
        return loginInfo;
    }

}
