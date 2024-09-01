package com.jon.job_portal_backend.repo;

import com.jon.job_portal_backend.entity.CreatejobEntity;
import com.jon.job_portal_backend.entity.UpdatejobEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Transactional
public interface UpdatejobRepo extends JpaRepository<UpdatejobEntity, Long> {

}
