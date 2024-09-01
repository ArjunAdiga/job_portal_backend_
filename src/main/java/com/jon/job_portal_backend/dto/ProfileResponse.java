package com.jon.job_portal_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponse {
    private String message;
    private Long profileId;

    // Constructor
    public ProfileResponse(String message, Long profileId) {
        this.message = message;
        this.profileId = profileId;
    }
}
