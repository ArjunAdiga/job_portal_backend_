package com.jon.job_portal_backend.controler;


import com.jon.job_portal_backend.dto.LoginResponse;
import com.jon.job_portal_backend.service.AuthHandleService;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("/")
@RestController
@CrossOrigin
public class AuthHandleController {

    private final AuthHandleService authHandleService;
    private static final Logger logger = LoggerFactory.getLogger(AuthHandleController.class);
    // Constructor injection of the AuthService
    public AuthHandleController(AuthHandleService authHandleService) {
        this.authHandleService = authHandleService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) {
        try {
            authHandleService.registerUser(userDto);  // Delegate to service
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during registration");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest){
        boolean isValidUser = authHandleService.validateUser(loginRequest.getEmail(),loginRequest.getPassword(),loginRequest.getRole());

        if (isValidUser) {
            LoginResponse response = new LoginResponse("Login successful", loginRequest.getRole(),loginRequest.getEmail());
            return ResponseEntity.ok(response);

        } else {
            return ResponseEntity.status(401).body(new LoginResponse("Invalid credentials", null,null));
        }
    }
}
