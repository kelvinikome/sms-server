package com.crustserver.controller;

import com.crustserver.model.UserEntity;
import com.crustserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/auth")
    public UserEntity login(@PathParam("username") String username, @PathParam("password") String password, HttpServletResponse response) {

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return this.userService.auth(username, password);
    }

    @GetMapping(value="/init")
    public void init() {
        this.userService.newUser(new UserEntity("admin", "admin", UserEntity.ADMIN));
    }

    @GetMapping(value="/user/teacher")
    public List<UserEntity> getAllTeachers() {
        return this.userService.getAllTeachers();
    }

    @PostMapping(value="/user/teacher")
    public void addTeacher(@RequestBody UserEntity userEntity) {
        userEntity.setEntityType(UserEntity.TEACHER);
        this.userService.newUser(userEntity);
    }

    @GetMapping(value="/user/student")
    public List<UserEntity> getAllStudents() {
        return this.userService.getAllStudents();
    }

    @PostMapping(value="/user/student")
    public void addStudent(@RequestBody UserEntity userEntity) {
        userEntity.setEntityType(UserEntity.STUDENT);
        this.userService.newUser(userEntity);
    }

    @GetMapping(value="/user")
    public List<UserEntity> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping(value="/user/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return this.userService.getUser(id);
    }

    @PostMapping(value="/user")
    public void addUser(@RequestBody UserEntity userEntity) {
        this.userService.newUser(userEntity);
    }

    @PutMapping(value="/user/{id}")
    public void updateUser(@RequestBody UserEntity userEntity) {
        this.userService.updateUser(userEntity);
    }

    @DeleteMapping(value="/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.removeUser(id);
    }
}
