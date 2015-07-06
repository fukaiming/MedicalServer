package com.example.dao;

import java.util.List;

import com.example.model.Doctor;

public interface DoctorDao {

	public List<Doctor> findDoctorsByClassType(String classType);

}
