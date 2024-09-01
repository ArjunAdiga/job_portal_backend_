package com.jon.job_portal_backend.repo;

import com.jon.job_portal_backend.dto.Job_seekerProfileDto;
import com.jon.job_portal_backend.entity.Job_seekerProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Job_seekerRepo extends JpaRepository<Job_seekerProfileEntity,Long> {
}


