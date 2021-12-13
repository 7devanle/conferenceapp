package com.ridwan.conferenceApplicationByRidwan.repositories;

import com.ridwan.conferenceApplicationByRidwan.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepositories extends JpaRepository<Speaker, Long> {
}
