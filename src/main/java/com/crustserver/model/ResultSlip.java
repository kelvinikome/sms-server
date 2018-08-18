package com.crustserver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ResultSlip {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private UserEntity userEntity;
	private List<MarkSheetEntity> MarkSheetEntities = new ArrayList<>();
	private double totalMarks;
	private double totalCoefficient;
	private int classPosition;
	private Remark remark;
	
	public enum Remark {
		PASSED,
		FAILED
	}
	
	public ResultSlip() {
		
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<MarkSheetEntity> getMarkSheetEntities() {
		return MarkSheetEntities;
	}

	public void setMarkSheetEntities(List<MarkSheetEntity> markSheetEntities) {
		MarkSheetEntities = markSheetEntities;
	}

}
