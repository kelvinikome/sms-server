package com.crustserver.service;

import com.crustserver.model.UserEntity;
import com.crustserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubjectProvisionerService subjectProvisionerService;
    @Autowired
    private BroadcastService broadcastService;

    public List<UserEntity> getAllUsers(){
        return (List<UserEntity>) this.userRepository.findAll();
    }

    public void newUser(UserEntity userEntity){
        userEntity.setId(null);
        this.userRepository.save(userEntity);
        if (userEntity.getEntityType().equals("STUDENT")) {
        	this.subjectProvisionerService.provisionMarkSheetForStudent(userEntity);
        	this.broadcastService.broadCastMail(userEntity.getEmail(), this.broadcastService.getAdmissionLetter());
        }
    }

    public UserEntity getUser(Long id){
        for (UserEntity userEntity : this.userRepository.findAll())
            if (userEntity.getId() == id)
                return userEntity;
        return null;
    }

    public void removeUser(Long id){
        for (UserEntity userEntity : this.userRepository.findAll())
            if (userEntity.getId() == id)
                this.userRepository.delete(userEntity);
    }

    public void updateUser(UserEntity updatedUserEntity){
        try {
            for (UserEntity userEntity : this.userRepository.findAll())
                if (userEntity.getId() == updatedUserEntity.getId()) {
                    this.userRepository.save(updatedUserEntity);
                    if (userEntity.getEntityType().equals("STUDENT"))
                    	this.subjectProvisionerService.provisionMarkSheetForStudent(updatedUserEntity);
                }
        } catch (Exception e){

        }
    }

    public UserEntity auth(String username, String password){
        try {
            for (UserEntity userEntity : this.userRepository.findAll())
                if ((userEntity.getUsername().equals(username))&&(userEntity.getPassword().equals(password)))
                    return userEntity;
        } catch (Exception e){

        }
        return null;
    }

    public List<UserEntity> getAllTeachers() {
        List<UserEntity> entities = new ArrayList<>();
        for (UserEntity userEntity : this.userRepository.findAll())
            try {
                if (userEntity.getEntityType().equals(UserEntity.TEACHER))
                    entities.add(userEntity);
            } catch (Exception e) {

            }
        return entities;
    }

    public List<UserEntity> getAllStudents() {
        List<UserEntity> entities = new ArrayList<>();
        try {
            this.userRepository.findAll()
                    .forEach(userEntity -> {
                        if (userEntity.getEntityType().equals(UserEntity.STUDENT))
                            entities.add(userEntity);
                    });
        } catch (Exception e){

        }
        return entities;
    }

    public List<UserEntity> getAllStudentsInClass(Long id) {
        List<UserEntity> userEntities = new ArrayList<>();
        for (UserEntity userEntity : this.userRepository.findAll())
            try {
                if (userEntity.getStudentClass().equals(id))
                    userEntities.add(userEntity);
            } catch (Exception e) {
            }
        return userEntities;
    }
}
