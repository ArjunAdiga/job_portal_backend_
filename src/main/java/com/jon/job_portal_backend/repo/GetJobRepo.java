package com.jon.job_portal_backend.repo;

import com.jon.job_portal_backend.entity.CreatejobEntity;
import com.jon.job_portal_backend.entity.GetJobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetJobRepo extends JpaRepository<GetJobsEntity, Integer> {
    List<GetJobsEntity> findByEmail(String email);
    List<GetJobsEntity> findById(int id);
//    List<GetJobsEntity> findAll();
}
