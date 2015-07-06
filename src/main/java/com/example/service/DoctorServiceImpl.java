package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DoctorDao;
import com.example.model.Doctor;
@Service(value="doctorService")
@Transactional(readOnly = true)
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorDao doctorDao;
	public List<Doctor> findRelativedDoctors(String classType) {
		List<Doctor> doctors = doctorDao.findDoctorsByClassType(classType);
		return doctors;
	}

}
