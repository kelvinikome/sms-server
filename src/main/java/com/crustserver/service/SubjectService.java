package com.crustserver.service;

import com.crustserver.model.SubjectEntity;
import com.crustserver.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired 
    private SubjectProvisionerService subjectProvisionerService;

    public List<SubjectEntity> getAllSubjects(){
        return (List<SubjectEntity>) this.subjectRepository.findAll();
    }

    public void newSubject(SubjectEntity subjectEntity){
    	subjectEntity.setId(null);
        this.subjectRepository.save(subjectEntity);
        this.subjectProvisionerService.provisionMarkSheetForAllStudents(subjectEntity);
    }

    public SubjectEntity getSubject(Long id){
        for (SubjectEntity userEntity : this.subjectRepository.findAll())
            if (userEntity.getId() == id)
                return userEntity;
        return null;
    }

    public void removeSubject(Long id){
        for (SubjectEntity classEntity : this.subjectRepository.findAll())
            if (classEntity.getId() == id)
                this.subjectRepository.delete(classEntity);
    }

    public void updateSubject(SubjectEntity updatedUserEntity){
        for (SubjectEntity subjectEntity : this.subjectRepository.findAll())
            if (subjectEntity.getId() == subjectEntity.getId())
                this.subjectRepository.save(updatedUserEntity);
    }
}
