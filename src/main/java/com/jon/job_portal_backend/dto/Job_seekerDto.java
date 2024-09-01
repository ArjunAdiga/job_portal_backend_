package com.jon.job_portal_backend.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
public class Job_seekerDto {
    private Long applyId;
    private String name;
    private String experience;
    private String role;
    private String salary;
    private String skills;
    private String email;
    private Long createId;
    private Long profileId;
}
