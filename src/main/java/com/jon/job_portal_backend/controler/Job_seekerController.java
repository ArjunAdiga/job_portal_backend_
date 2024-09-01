package com.jon.job_portal_backend.controler;

import com.jon.job_portal_backend.dto.Job_seekerDto;
import com.jon.job_portal_backend.dto.Job_seekerProfileDto;
import com.jon.job_portal_backend.dto.ProfileResponse;
import com.jon.job_portal_backend.entity.Job_seekerProfileEntity;
import com.jon.job_portal_backend.service.Job_seekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job_seeker")
@CrossOrigin
public class Job_seekerController {
    @Autowired
    Job_seekerService job_seekerService;
    // create profile
    @PostMapping("/profile")
    public ResponseEntity<ProfileResponse> CreateProfile(@RequestBody Job_seekerProfileDto job_SeekerProfileDto){
        try {

           Job_seekerProfileEntity profileEntity =job_seekerService.CreateProfile((job_SeekerProfileDto));
           Long profileId=profileEntity.getProfileId();
            ProfileResponse response=new ProfileResponse("Profile created successfully",profileId);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProfileResponse("Error during creating post",null));
        }
    }
    // get profile
    @GetMapping()
    public List<Job_seekerProfileDto> getAllProfil() {
        return job_seekerService.getAllProfile();
    }
    // apply job
    @PostMapping("/apply")
    public ResponseEntity<String> ApplyJob(@RequestBody Job_seekerDto job_seekerDto){
        try {
            job_seekerService.applyJob((job_seekerDto));
            return ResponseEntity.status(HttpStatus.CREATED).body("Job applied successfully");
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during creating post");
        }
    }
   //  get all applied jobs by profile id
    @GetMapping("/applied/{profileId}")
    public List<Job_seekerDto> getAppliedJobs(@PathVariable Long profileId) {
        return job_seekerService.getAllAppliedJobsById(profileId);
    }
   // get all applicants for a job
    @GetMapping("/list/{createId}")
    public List<Job_seekerDto> getAllAppliedData(@PathVariable Long createId){
        return job_seekerService.getAllAppliedSeekers(createId);
    }

}
