package com.example.service;

import java.util.List;

import com.example.model.Doctor;

public interface DoctorService {
	//��ȡҽ���ó�����ΪclassType������ҽ��
	public List<Doctor> findRelativedDoctors(String classType);
	
}
