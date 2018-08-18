package com.crustserver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

@Entity
public class ClassEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String className;
    private String description;
    @ElementCollection
    private List<SubjectEntity> subjectEntities = new ArrayList<>();
    @ElementCollection
    private List<UserEntity> classList = new ArrayList<>();
    @ElementCollection
    private List<MarkSheetEntity> markSheetEntities = new ArrayList<>();
    private String classAdmin;

    public ClassEntity () {}

    public ClassEntity(String className, String description, List<SubjectEntity> subjectEntities, List<UserEntity> classList,List<MarkSheetEntity> markSheetEntities, String classAdmin) {
        this.className = className;
        this.description = description;
        this.subjectEntities = subjectEntities;
        this.classList = classList;
        this.classAdmin = classAdmin;
        this.markSheetEntities = markSheetEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SubjectEntity> getSubjectEntities() {
        return subjectEntities;
    }

    public void setSubjectEntities(List<SubjectEntity> subjectEntities) {
        this.subjectEntities = subjectEntities;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserEntity> getClassList() {
        return classList;
    }

    public void setClassList(List<UserEntity> classList) {
        this.classList = classList;
    }

    public String getClassAdmin() {
        return classAdmin;
    }

    public void setClassAdmin(String classAdmin) {
        this.classAdmin = classAdmin;
    }

    public List<MarkSheetEntity> getMarkSheetEntities() {
        return markSheetEntities;
    }

    public void setMarkSheetEntities(List<MarkSheetEntity> markSheetEntities) {
        this.markSheetEntities = markSheetEntities;
    }

    public void newMarkSheetEntry(MarkSheetEntity markSheetEntity) {
        this.markSheetEntities.add(markSheetEntity);
    }
}
