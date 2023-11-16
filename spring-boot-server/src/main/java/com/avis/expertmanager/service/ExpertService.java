package com.avis.expertmanager.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.avis.expertmanager.exception.UserNotFoundException;
import com.avis.expertmanager.model.Expert;
import com.avis.expertmanager.repository.ExpertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpertService {
    private final ExpertRepo expertRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ExpertService(ExpertRepo expertRepo, BCryptPasswordEncoder passwordEncoder) {

        this.expertRepo = expertRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Expert login(String email, String password) {
        Optional<Expert> expertOptional = expertRepo.findByEmail(email);

        if (expertOptional.isPresent()) {
            Expert expert = expertOptional.get();

            // Use the passwordEncoder to verify the entered password
            if (passwordEncoder.matches(password, expert.getPasswordHash())) {
                return expert;
            }
        }
        return null; // Invalid login
    }



    public Expert registerExpert(Expert expert) {
        // Generate a random salt securely
        String salt = generateRandomSalt();

        // Combine salt and password, and then hash
        String hashedPassword = hashPassword(expert.getPasswordHash(), salt);

        // Store the hashed password and salt
        expert.setPasswordHash(hashedPassword);
        expert.setSalt(salt);

        return expertRepo.save(expert);
    }

    private String generateRandomSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt) {
        // Combine salt and password, and then hash with BCrypt
        return passwordEncoder.encode(salt + password);
    }


    public Expert addExpert(Expert expert) {
        expert.setDescription(UUID.randomUUID().toString());
        return expertRepo.save(expert);
    }

    public List<Expert> findAllExpert() {
        return expertRepo.findAll();
    }

    public Expert updateExpert(Expert expert){
        return expertRepo.save(expert);
    }

    public Expert findExpertByID(Long id){
        return expertRepo.findExpertById(id)
                .orElseThrow(() -> new UserNotFoundException("User By Id "+id+" Was Not Found"));
    }
    @Transactional
    public void deleteExpert(Long id){
        expertRepo.delete(new Expert(id));
    }
}
