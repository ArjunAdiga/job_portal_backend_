package com.jon.job_portal_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Data
@Entity
@Table(name = "Employer")
public class UpdatejobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long createId;

    @Column(name = "company")
    private String company;

    @Column(name = "experience")
    private String experience;

    @Column(name = "skills")
    private String skills;

    @Column(name = "job_role")
    private String jobRole;

    @Column(name = "salary")
    private String salary;

    @Column(name = "description")
    private String description;

}


