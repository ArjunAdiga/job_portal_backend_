package com.jon.job_portal_backend.service;

import com.jon.job_portal_backend.dto.CreatejobDto;
import com.jon.job_portal_backend.dto.UpdatejobDto;
import com.jon.job_portal_backend.entity.CreatejobEntity;
import com.jon.job_portal_backend.entity.GetJobsEntity;
import com.jon.job_portal_backend.entity.UpdatejobEntity;
import com.jon.job_portal_backend.repo.CreatejobRepo;
import com.jon.job_portal_backend.repo.GetJobRepo;
import com.jon.job_portal_backend.repo.UpdatejobRepo;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreatejobService {
    CreatejobRepo createjobRepo;
    @Autowired
    GetJobRepo getJobRepo;
    @Autowired
    UpdatejobRepo updatejobRepo;
    private static final Logger logger = LoggerFactory.getLogger(CreatejobService.class);

    public CreatejobService(CreatejobRepo createjobRepo){
        this.createjobRepo=createjobRepo;
    }

    public CreatejobEntity CreateJob (CreatejobDto createjobDto) {
        CreatejobEntity createjobEntity = new CreatejobEntity();
        createjobEntity.setCompany(createjobDto.getCompany());
        createjobEntity.setJobRole(createjobDto.getJobRole());
        createjobEntity.setExperience(createjobDto.getExperience());
        createjobEntity.setSkills(createjobDto.getSkills());
        createjobEntity.setSalary(createjobDto.getSalary());
        createjobEntity.setDescription(createjobDto.getDescription());
        createjobEntity.setEmail(createjobDto.getEmail());
       return createjobRepo.save(createjobEntity);
    }
    @Transactional
    public UpdatejobEntity updateJob(Long id, UpdatejobDto updatejobDto) {

        Optional<UpdatejobEntity> optionalJob = updatejobRepo.findById(id);
        logger.debug("Original Job: {}", optionalJob);
        if (optionalJob.isPresent()) {
            UpdatejobEntity job = optionalJob.get();
            job.setCompany(updatejobDto.getCompany());
            job.setJobRole(updatejobDto.getJobRole());
            job.setSkills(updatejobDto.getSkills());
            job.setSalary(updatejobDto.getSalary());
            job.setExperience(updatejobDto.getExperience());
            job.setDescription(updatejobDto.getDescription());
            System.out.println("Updated Entity: " + job.toString());
            return updatejobRepo.save(job);
        } else {
            logger.error("Job not found with id {}", id);
            throw new RuntimeException("Job not found with id " + id);
        }
    }

    public List<CreatejobDto> getJobs(String email) {
        List<GetJobsEntity> jobs = getJobRepo.findByEmail(email);
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<CreatejobDto> getJobById(int id){
        List<GetJobsEntity> specificJob = getJobRepo.findById(id);
        return specificJob.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<CreatejobDto> getAllJobs() {
        List<GetJobsEntity> getAllJobsPosted = getJobRepo.findAll();
        return getAllJobsPosted.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private CreatejobDto convertToDto(GetJobsEntity getJobsEntity) {
        CreatejobDto dto = new CreatejobDto();
        dto.setCompany(getJobsEntity.getCompany());
        dto.setJobRole(getJobsEntity.getJobRole());
        dto.setExperience(getJobsEntity.getExperience());
        dto.setSkills(getJobsEntity.getSkills());
        dto.setSalary(getJobsEntity.getSalary());
        dto.setDescription(getJobsEntity.getDescription());
        dto.setCreateId(getJobsEntity.getCreateId());
        dto.setEmail(getJobsEntity.getEmail());
        return dto;
    }


}
