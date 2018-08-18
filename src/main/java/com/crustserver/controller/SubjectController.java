package com.crustserver.controller;

import com.crustserver.model.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crustserver.service.SubjectService;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value="/subject")
    public List<SubjectEntity> getAllEntries() {
        return this.subjectService.getAllSubjects();
    }

    @GetMapping(value="/subject/{id}")
    public SubjectEntity getEntry(@PathVariable Long id) {
        return this.subjectService.getSubject(id);
    }

    @PostMapping(value="/subject")
    public void addEntry(@RequestBody SubjectEntity subjectEntity) {
        this.subjectService.newSubject(subjectEntity);
    }

    @PutMapping(value="/subject/{id}")
    public void updateEntry(@RequestBody SubjectEntity subjectEntity) {
        this.subjectService.updateSubject(subjectEntity);
    }

    @DeleteMapping(value="/subject/{id}")
    public void deleteEntry(@PathVariable Long id) {
        this.subjectService.removeSubject(id);
    }
}
