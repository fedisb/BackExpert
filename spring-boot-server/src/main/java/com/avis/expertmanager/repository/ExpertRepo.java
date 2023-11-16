package com.avis.expertmanager.repository;

import com.avis.expertmanager.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpertRepo extends JpaRepository<Expert, Long> {
    void deleteExpertById(Long id);

    Optional<Expert> findExpertById(Long id);
    Optional<Expert> findByEmail(String email);
}

