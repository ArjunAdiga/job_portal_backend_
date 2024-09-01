package com.jon.job_portal_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Data
@Entity
@Table(name = "apply")
public class Job_seekerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applyId;

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

    @Column(name="create_id")
    private Long createId;

    @Column(name="profile_id")
    private Long profileId;
}
