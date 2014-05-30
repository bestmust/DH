package com.example.datamodels;

public class MedicinesClinicModel {
	
	private String MedicineName;
	private String mg;
	private String medicinesId="";
	
	
	
	public String getMedicinesId() {
		return medicinesId;
	}
	public void setMedicinesId(String medicinesId) {
		this.medicinesId = medicinesId;
	}
	public String getMedicineName() {
		return MedicineName;
	}
	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}
	public String getMg() {
		return mg;
	}
	public void setMg(String mg) {
		this.mg = mg;
	}
	
	

	

}
