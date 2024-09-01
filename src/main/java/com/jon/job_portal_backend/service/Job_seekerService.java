package com.jon.job_portal_backend.service;


import com.jon.job_portal_backend.dto.Job_seekerDto;
import com.jon.job_portal_backend.dto.Job_seekerProfileDto;
import com.jon.job_portal_backend.entity.Job_seekerEntity;
import com.jon.job_portal_backend.entity.Job_seekerProfileEntity;
import com.jon.job_portal_backend.repo.Job_seekerApplyRepo;
import com.jon.job_portal_backend.repo.Job_seekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Job_seekerService {
    @Autowired
    Job_seekerRepo job_seekerRepo;
    @Autowired
    Job_seekerApplyRepo job_seekerApplyRepo;
    public Job_seekerProfileEntity CreateProfile(Job_seekerProfileDto job_seekerProfileDto) {
        Job_seekerProfileEntity job_seekerProfileEntity = new Job_seekerProfileEntity();
        job_seekerProfileEntity.setName(job_seekerProfileDto.getName());
        job_seekerProfileEntity.setExperience(job_seekerProfileDto.getExperience());
        job_seekerProfileEntity.setSalary(job_seekerProfileDto.getSalary());
        job_seekerProfileEntity.setSkills(job_seekerProfileDto.getSkills());
        job_seekerProfileEntity.setRole(job_seekerProfileDto.getRole());
        job_seekerProfileEntity.setEmail(job_seekerProfileDto.getEmail());
       return job_seekerRepo.save(job_seekerProfileEntity);
    }
    public List<Job_seekerProfileDto> getAllProfile() {
        List<Job_seekerProfileEntity> getAllProfilesEntity=job_seekerRepo.findAll();
        return getAllProfilesEntity.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    private Job_seekerProfileDto convertToDto(Job_seekerProfileEntity getAllProfilesEntity) {
        Job_seekerProfileDto dto=new Job_seekerProfileDto();
        dto.setName(getAllProfilesEntity.getName());
        dto.setEmail(getAllProfilesEntity.getEmail());
        dto.setExperience(getAllProfilesEntity.getExperience());
        dto.setSalary(getAllProfilesEntity.getSalary());
        dto.setSkills(getAllProfilesEntity.getSkills());
        dto.setRole(getAllProfilesEntity.getRole());
        dto.setProfileId(getAllProfilesEntity.getProfileId());
        return dto;
    }

    public void applyJob(Job_seekerDto jobSeekerDto) {
        Job_seekerEntity job_seekerEntity=new Job_seekerEntity();
        job_seekerEntity.setApplyId(jobSeekerDto.getApplyId());
        job_seekerEntity.setCreateId(jobSeekerDto.getCreateId());
        job_seekerEntity.setProfileId(jobSeekerDto.getProfileId());
        job_seekerEntity.setName(jobSeekerDto.getName());
        job_seekerEntity.setEmail(jobSeekerDto.getEmail());
        job_seekerEntity.setExperience(jobSeekerDto.getExperience());
        job_seekerEntity.setSalary(jobSeekerDto.getSalary());
        job_seekerEntity.setSkills(jobSeekerDto.getSkills());
        job_seekerEntity.setRole(jobSeekerDto.getRole());
        job_seekerApplyRepo.save(job_seekerEntity);
    }

    public List<Job_seekerDto> getAllAppliedJobsById(Long profileId) {
        List<Job_seekerEntity> getAllJobs=job_seekerApplyRepo.findAllByProfileId(profileId);
        return getAllJobs.stream().map(this::convertToDtoJob).collect(Collectors.toList());
    }
    public List<Job_seekerDto> getAllAppliedSeekers(Long createId) {
        List <Job_seekerEntity> getAllAppliedSeek=job_seekerApplyRepo.findAllByCreateId(createId);
        return getAllAppliedSeek.stream().map(this::convertToDtoJob).collect(Collectors.toList());
    }
    private Job_seekerDto convertToDtoJob(Job_seekerEntity job_seekerEntity) {
        Job_seekerDto dto=new Job_seekerDto();
        dto.setName(job_seekerEntity.getName());
        dto.setEmail(job_seekerEntity.getEmail());
        dto.setExperience(job_seekerEntity.getExperience());
        dto.setSalary(job_seekerEntity.getSalary());
        dto.setSkills(job_seekerEntity.getSkills());
        dto.setRole(job_seekerEntity.getRole());
        dto.setCreateId(job_seekerEntity.getCreateId());
        dto.setProfileId(job_seekerEntity.getProfileId());
        dto.setApplyId(job_seekerEntity.getApplyId());
        return dto;
    }


}
