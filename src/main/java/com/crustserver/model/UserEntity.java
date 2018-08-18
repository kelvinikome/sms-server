package com.crustserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String sex;
    private Long studentClass;
    @ElementCollection
    private List<String> teacherClass;
    private String admissionDate;
    private Long classNumber;
    private String entityType;

    public static final String TEACHER = "TEACHER";
    public static final String ADMIN = "ADMIN";
    public static final String STUDENT = "STUDENT";

    public UserEntity() {

    }

    public UserEntity(String username, String password, String entityType) {
        this.username = username;
        this.password = password;
        this.entityType = entityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Long studentClass) {
        this.studentClass = studentClass;
    }

    public List<String> getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(List<String> teacherClass) {
        this.teacherClass = teacherClass;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Long getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Long classNumber) {
		this.classNumber = classNumber;
	}
}