package com.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer stdId;
	private String stdName;
	private Double stdFee;
	private String stdCourse;
	private String stdAddress;
	private String stdGen;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> stdSlot;

}
