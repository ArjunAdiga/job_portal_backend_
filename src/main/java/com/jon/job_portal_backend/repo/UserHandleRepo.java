package com.jon.job_portal_backend.repo;

import com.jon.job_portal_backend.entity.UserHandleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserHandleRepo extends JpaRepository<UserHandleEntity, Long> {
    // Additional custom queries can be defined here if needed
    Optional<UserHandleEntity> findByEmail(String email);
}
