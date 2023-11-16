package com.avis.expertmanager.resources;

import com.avis.expertmanager.model.Expert;
import com.avis.expertmanager.model.LoginRequest;
import com.avis.expertmanager.service.ExpertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expert")
public class ExpertResource {

    private final ExpertService expertService;


    public ExpertResource(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expert>> getAllExpert(){
        List<Expert> experts =expertService.findAllExpert();
        return  new ResponseEntity<>(experts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Expert> getExpertByID(@PathVariable("id") Long id){
        Expert expert = expertService.findExpertByID(id);
        return new ResponseEntity<>(expert,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Expert> addExpert(@RequestBody Expert expert){
        Expert newExpert = expertService.addExpert(expert);
        return  new ResponseEntity<>(newExpert, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Expert> updateExpert(@RequestBody Expert expert){
        Expert updateExpert = expertService.updateExpert(expert);
        return new ResponseEntity<>(updateExpert, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExpert(@PathVariable("id") Long id) {
        expertService.deleteExpert(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<Expert> registerExpert(@RequestBody Expert expert) {
        Expert registeredExpert = expertService.registerExpert(expert);
        return ResponseEntity.ok(registeredExpert);
    }

    @PostMapping("/login")
    public ResponseEntity<Expert> login(@RequestBody LoginRequest loginRequest) {

        Expert expert = expertService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (expert != null) {
            return ResponseEntity.ok(expert);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
