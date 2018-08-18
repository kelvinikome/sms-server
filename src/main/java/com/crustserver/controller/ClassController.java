package com.crustserver.controller;

import com.crustserver.model.ClassEntity;
import com.crustserver.model.UserEntity;
import com.crustserver.service.ClassService;
import com.crustserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;
    @Autowired
    private UserService userService;

    @GetMapping(value="/class")
    public List<ClassEntity> getAllClasses() {
        return this.classService.getAllClasses();
    }

    @GetMapping(value="/class/{id}")
    public ClassEntity getClassById(@PathVariable Long id) {
        return this.classService.getClassById(id);
    }

    @GetMapping(value="/class/{id}/student")
    public List<UserEntity> getAllStudentsInClass(@PathVariable Long id) {
        return this.userService.getAllStudentsInClass(id);
    }

    @PostMapping(value="/class")
    public void addClass(@RequestBody ClassEntity classEntity) {
        System.out.println(classEntity.getClassName());
        this.classService.newClass(classEntity);
    }

    @PutMapping(value="/class/{id}")
    public void updateClass(@RequestBody ClassEntity classEntity) {
        this.classService.updateClass(classEntity);
    }

    @DeleteMapping(value="/class/{id}")
    public void deleteClass(@PathVariable Long id) {
        this.classService.removeClass(id);
    }
}
