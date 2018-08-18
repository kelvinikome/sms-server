package com.crustserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crustserver.model.ClassEntity;
import com.crustserver.repository.ResultSlipRepository;

@Service
public class ResultSlipService {

	@Autowired
	private ResultSlipRepository resultSlipRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private ClassService classService;
	
	public void generateClassResults(Long classId) {
		ClassEntity classEntity = this.classService.getClassById(classId);
		
	}

}
