package com.crustserver.service;

import com.crustserver.model.ClassEntity;
import com.crustserver.model.UserEntity;
import com.crustserver.repository.ClassEntityRepository;
import com.crustserver.repository.MarkSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassEntityRepository classRepository;

    public List<ClassEntity> getAllClasses(){
        return (List<ClassEntity>) this.classRepository.findAll();
    }

    public void newClass(ClassEntity classEntity){
        classEntity.setId(null);
        this.classRepository.save(classEntity);
    }

    public ClassEntity getClassById(Long id){
        for (ClassEntity userEntity : this.classRepository.findAll())
            if (userEntity.getId() == id)
                return userEntity;
        return null;
    }

    public void removeClass(Long id){
        for (ClassEntity classEntity : this.classRepository.findAll())
            if (classEntity.getId() == id)
                this.classRepository.delete(classEntity);
    }

    public void updateClass(ClassEntity updatedUserEntity){
        for (ClassEntity userEntity : this.classRepository.findAll())
            if (userEntity.getId().equals(updatedUserEntity.getId()))
                this.classRepository.save(updatedUserEntity);
    }

    public List<UserEntity> getStudents(int id) {
        for (ClassEntity userEntity : this.classRepository.findAll())
            if (userEntity.getId() == id)
                return userEntity.getClassList();
        return null;
    }
}
