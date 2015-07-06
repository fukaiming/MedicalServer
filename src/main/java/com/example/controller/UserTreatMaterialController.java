package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.UserTreatMaterial;
import com.example.model.Doctor;
import com.example.service.DoctorService;
import com.example.service.UserTreatMaterialService;

@Controller
@RequestMapping(value="/userTreatMaterial")
public class UserTreatMaterialController {
	@Autowired
	private UserTreatMaterialService userTreatMaterialService;
	@Autowired
	private DoctorService doctorService;
	@ResponseBody
	@RequestMapping(value="/saveUserTreatMaterial",method=RequestMethod.GET)
	public List<Doctor> saveUserTreatMaterial(@ModelAttribute UserTreatMaterial userTreatMaterial,@RequestParam("files") MultipartFile[] files,HttpServletRequest request){

		userTreatMaterialService.save(userTreatMaterial,files,request);
		//获取所有匹配的医生
		String classType = userTreatMaterial.getClassType();
		List<Doctor> doctors = doctorService.findRelativedDoctors(classType);
		return doctors;
	}


}
