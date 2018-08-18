package com.crustserver.controller;

import com.crustserver.model.MarkSheetEntity;
import com.crustserver.service.ClassService;
import com.crustserver.service.MarkSheetService;
import com.crustserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MarkSheetController {

//    @Autowired
//    private ClassService classService;
//    @Autowired
//    private UserService userService;
    @Autowired
    private MarkSheetService markSheetService;

    @GetMapping(value="/class/{id}/marksheet")
    public List<MarkSheetEntity> getAllEntriesForClass(@PathVariable Long id) {
        return this.markSheetService.getAllEntries(id);
    }

    @GetMapping(value="/class/{id}/marksheet/{subjectId}")
    public List<MarkSheetEntity> getAllEntriesForSubject(@PathVariable Long id, @PathVariable Long subjectId) {
        return this.markSheetService.getAllEntries(id, subjectId);
    }

    @PostMapping(value="/class/{id}/marksheet")
    public void newEntry(@PathVariable int id, @RequestBody MarkSheetEntity markSheetEntity) {
        this.markSheetService.newEntry(markSheetEntity);
    }
}
