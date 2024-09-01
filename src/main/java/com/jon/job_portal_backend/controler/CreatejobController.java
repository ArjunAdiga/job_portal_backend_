package com.jon.job_portal_backend.controler;

import com.jon.job_portal_backend.dto.CreatejobDto;
import com.jon.job_portal_backend.dto.UpdatejobDto;
import com.jon.job_portal_backend.entity.CreatejobEntity;
import com.jon.job_portal_backend.entity.UpdatejobEntity;
import com.jon.job_portal_backend.repo.CreatejobRepo;
import com.jon.job_portal_backend.service.CreatejobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
@CrossOrigin
public class CreatejobController {
    private static final Logger logger = LoggerFactory.getLogger(CreatejobController.class);
    @Autowired
    private CreatejobService createjobService;
  // create job
   @PostMapping("/create")
    public ResponseEntity<String>  CreateJob(@RequestBody CreatejobDto createjobDto) {
        try {
            createjobService.CreateJob((createjobDto));
            return ResponseEntity.status(HttpStatus.CREATED).body("Job post created successfully");
        }
        catch(Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during creating post");
       }
    }
    //  edit job post based on id
    @PutMapping("/editPost/{id}")
    public ResponseEntity<UpdatejobEntity> editJob(@PathVariable Long id, @RequestBody UpdatejobDto updatejobDto) {
        try {

            UpdatejobEntity updatedJob = createjobService.updateJob(id, updatejobDto);
            System.out.println("Updated Job: " + updatedJob);
            return ResponseEntity.ok(updatedJob);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    // get job based on employer email
    @GetMapping("/{email}")
    public List<CreatejobDto> getJobsByEmail(@PathVariable String email) {
       return createjobService.getJobs(email);
    }
   // open specific job
    @GetMapping("/post/{id}")
    public List<CreatejobDto> getSpecificJobById(@PathVariable int id){
       return createjobService.getJobById(id);
    }
    // get all jobs posted by all
    @GetMapping()
    public List<CreatejobDto> getAllListedJobs() {
       return createjobService.getAllJobs();
    }
}
