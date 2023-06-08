package com.spring.employee.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity

@Table(name = "timex")

public class Timex 
{
	@Id
	@GeneratedValue
	private int timexId;
	private float monday;
	private float tuesday;
	private float wednesday;
	private float thursday;
	private float friday;
	private float overTime;
	public int getTimexId() {
		return timexId;
	}
	public void setTimexId(int timexId) {
		this.timexId = timexId;
	}
	public float getMonday() {
		return monday;
	}
	public void setMonday(float monday) {
		this.monday = monday;
	}
	public float getTuesday() {
		return tuesday;
	}
	public void setTuesday(float tuesday) {
		this.tuesday = tuesday;
	}
	public float getWednesday() {
		return wednesday;
	}
	public void setWednesday(float wednesday) {
		this.wednesday = wednesday;
	}
	public float getThursday() {
		return thursday;
	}
	public void setThursday(float thursday) {
		this.thursday = thursday;
	}
	public float getFriday() {
		return friday;
	}
	public void setFriday(float friday) {
		this.friday = friday;
	}
	public float getOverTime() {
		return overTime;
	}
	public void setOverTime(float overTime) {
		this.overTime = overTime;
	}
	public Timex(int timexId, float monday, float tuesday, float wednesday, float thursday, float friday,
			float overTime) {
		super();
		this.timexId = timexId;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.overTime = overTime;
	}
	public Timex() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
