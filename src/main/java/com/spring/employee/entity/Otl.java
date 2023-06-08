package com.spring.employee.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "otl")

public class Otl 
{
	@Id
	@GeneratedValue
	private int otlId;
	private float monday;
	private float tuesday;
	private float wednesday;
	private float thursday;
	private float friday;
	private float sowd;
	private float sowe;
	private float cowd;
	private float cowe;
	private float soph;
	private float coph;
	public int getOtlId() {
		return otlId;
	}
	public void setOtlId(int otlId) {
		this.otlId = otlId;
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
	public float getSowd() {
		return sowd;
	}
	public void setSowd(float sowd) {
		this.sowd = sowd;
	}
	public float getSowe() {
		return sowe;
	}
	public void setSowe(float sowe) {
		this.sowe = sowe;
	}
	public float getCowd() {
		return cowd;
	}
	public void setCowd(float cowd) {
		this.cowd = cowd;
	}
	public float getCowe() {
		return cowe;
	}
	public void setCowe(float cowe) {
		this.cowe = cowe;
	}
	public float getSoph() {
		return soph;
	}
	public void setSoph(float soph) {
		this.soph = soph;
	}
	public float getCoph() {
		return coph;
	}
	public void setCoph(float coph) {
		this.coph = coph;
	}
	public Otl(int otlId, float monday, float tuesday, float wednesday, float thursday, float friday, float sowd,
			float sowe, float cowd, float cowe, float soph, float coph) {
		super();
		this.otlId = otlId;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.sowd = sowd;
		this.sowe = sowe;
		this.cowd = cowd;
		this.cowe = cowe;
		this.soph = soph;
		this.coph = coph;
	}
	public Otl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
