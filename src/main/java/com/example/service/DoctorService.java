package com.example.service;

import java.util.List;

import com.example.model.Doctor;

public interface DoctorService {
	//获取医生擅长类型为classType的所有医生
	public List<Doctor> findRelativedDoctors(String classType);
	
}
