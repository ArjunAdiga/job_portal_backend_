package com.jon.job_portal_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatejobDto {
    private Long createId;
    private String company;
    private String experience;
    private String skills;
    private String jobRole;
    private String salary;
    private String description;
}
