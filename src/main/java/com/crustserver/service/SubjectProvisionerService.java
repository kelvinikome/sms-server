package com.crustserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crustserver.model.MarkSheetEntity;
import com.crustserver.model.SubjectEntity;
import com.crustserver.model.UserEntity;

@Service
public class SubjectProvisionerService {

    @Autowired 
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private MarkSheetService markSheetService;
    
    public SubjectProvisionerService () {
    	
    }
    
    public void provisionMarkSheetForStudent(UserEntity userEntity) {
        for (SubjectEntity entity : this.subjectService.getAllSubjects())
        	this.markSheetService.newEntry(new MarkSheetEntity(
        			userEntity.getStudentClass(),
        			entity.getId(),
        			userEntity.getId(),
        			userEntity.getFirstName()+" "+userEntity.getLastName(),
        			userEntity.getClassNumber(),
        			0
        			));
    }

	public void provisionMarkSheetForAllStudents(SubjectEntity subjectEntity) {
        for (UserEntity entity : this.userService.getAllStudents())
        	this.markSheetService.newEntry(new MarkSheetEntity(
        			entity.getStudentClass(),
        			subjectEntity.getId(),
        			entity.getId(),
        			entity.getFirstName()+" "+entity.getLastName(),
        			entity.getClassNumber(),
        			0
        			));
	}

}
