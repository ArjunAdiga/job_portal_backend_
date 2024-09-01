package com.jon.job_portal_backend.entity;

import jakarta.persistence.*;
import lombok.*;



    @Entity
    @Table(name = "users")
    @Getter // Lombok will generate getters
    @Setter // Lombok will generate setters
    @NoArgsConstructor
    @Data
    public class UserHandleEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String email;
        private String password;
        private String name;
        private String role;

        // Getters and Setters
    }




