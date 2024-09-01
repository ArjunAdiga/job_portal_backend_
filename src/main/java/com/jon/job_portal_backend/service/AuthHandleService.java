package com.jon.job_portal_backend.service;

import com.jon.job_portal_backend.controler.UserDto;
import com.jon.job_portal_backend.entity.UserHandleEntity;
import com.jon.job_portal_backend.repo.UserHandleRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
    public class AuthHandleService {

        private final UserHandleRepo userHandleRepo;

        // Constructor injection
        public AuthHandleService(UserHandleRepo userHandleRepo) {
            this.userHandleRepo = userHandleRepo;
        }

        public void registerUser(UserDto userDto) {
            // Convert UserDto to UserHandleEntity
            UserHandleEntity user = new UserHandleEntity();
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setName(userDto.getName());
            user.setRole(userDto.getRole());
            // Save the user to the database
            userHandleRepo.save(user);

        }
        public boolean validateUser(String email, String password, String role){
            Optional<UserHandleEntity> userOptional=userHandleRepo.findByEmail(email);

            if(userOptional.isPresent()){
                UserHandleEntity user=userOptional.get();
                if(password.equals(user.getPassword()) && role.equals(user.getRole())){
                    return true;
                }
            }
            return false;
        }
    }

