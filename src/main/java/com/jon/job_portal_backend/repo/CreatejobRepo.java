package com.jon.job_portal_backend.repo;

import com.jon.job_portal_backend.dto.CreatejobDto;
import com.jon.job_portal_backend.entity.CreatejobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatejobRepo extends JpaRepository<CreatejobEntity, Long> {
    List<CreatejobEntity> findByEmail(String email);
}

