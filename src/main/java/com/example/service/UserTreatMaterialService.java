package com.example.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.example.domain.UserTreatMaterial;

public interface UserTreatMaterialService {
	//�����û�������Ϣ
	public void save(UserTreatMaterial userTreatMaterial, MultipartFile[] files, HttpServletRequest request);

}
