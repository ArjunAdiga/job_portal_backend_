package com.jon.job_portal_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Data
@Entity
@Table(name = "Seeker")
public class Job_seekerProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "name")
    private String name;

    @Column(name = "experience")
    private String experience;

    @Column(name = "skills")
    private String skills;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private String salary;

    @Column(name = "email")
    private String email;
}
