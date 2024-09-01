package com.jon.job_portal_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Job_seekerProfileDto {
    private Long profileId;
    private String name;
    private String experience;
    private String role;
    private String salary;
    private String skills;
    private String email;
}
