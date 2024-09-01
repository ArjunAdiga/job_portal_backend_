package com.jon.job_portal_backend.repo;

import com.jon.job_portal_backend.entity.Job_seekerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Job_seekerApplyRepo extends JpaRepository<Job_seekerEntity,Long> {
    List<Job_seekerEntity> findAllByProfileId(Long profileId);

    List<Job_seekerEntity> findAllByCreateId(Long createId);
}
