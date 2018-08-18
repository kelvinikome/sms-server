package com.crustserver.service;

import com.crustserver.model.MarkSheetEntity;
import com.crustserver.repository.MarkSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkSheetService {
    @Autowired
    private ClassService classService;
    @Autowired
    private MarkSheetRepository markSheetRepository;

//    public void newEntry(int classId, MarkSheetEntity markSheetEntity){
//    	this.classService.getClassById(classId).newMarkSheetEntry(markSheetEntity);
//    }
//
//    public List<MarkSheetEntity> getAllEntries(int classId) {
//        return this.classService.getClassById(classId).getMarkSheetEntities();
//    }
//
//    public void removeEntry(int classId, MarkSheetEntity markSheetEntity){
//    	this.classService.getClassById(classId).getMarkSheetEntities().remove(markSheetEntity);
//    }
//
//    public void updateEntry(int classId, MarkSheetEntity markSheetEntity) {
//    	this.classService.getClassById(classId).getMarkSheetEntities().add(markSheetEntity);
//    }

    public void newEntry(MarkSheetEntity markSheetEntity){
    	markSheetEntity.setId(
    			markSheetEntity.getClassId()+
    			","+markSheetEntity.getStudentId()+
    			","+markSheetEntity.getSubjectId());
    	this.markSheetRepository.save(markSheetEntity);
    }

    public List<MarkSheetEntity> getAllEntries(Long classId) {
    	List<MarkSheetEntity> entries = new ArrayList<>();
    	for (MarkSheetEntity entry : this.markSheetRepository.findAll())
    		if (entry.getClassId() == classId)
    			entries.add(entry);
        return entries;
    }

    public void removeEntry(Long sheetId){
    	for (MarkSheetEntity entry : this.markSheetRepository.findAll())
    		if (entry.getId().equals(sheetId.toString()))
    			this.markSheetRepository.delete(entry);
    }

    public void updateEntry(MarkSheetEntity markSheetEntity) {
    	this.markSheetRepository.save(markSheetEntity);
    }

	public List<MarkSheetEntity> getAllEntries(Long classId, Long subjectId) {
    	List<MarkSheetEntity> entries = new ArrayList<>();
    	for (MarkSheetEntity entry : this.markSheetRepository.findAll())
    		if ((entry.getClassId() == classId)&&(entry.getSubjectId() == subjectId))
    			entries.add(entry);
        return entries;
	}
}
