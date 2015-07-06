package com.example.service;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.UserDAO;
import com.example.dao.UserTreatMaterialDAO;
import com.example.domain.UserTreatMaterial;
import com.example.model.Material;
import com.example.model.User;
import com.example.model.UserTreat;

@Service(value = "userTreatMaterialService")
@Transactional(readOnly = true)
public class UserTreatMaterialServiceImpl implements UserTreatMaterialService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserTreatMaterialDAO userTreatMaterialDAO;
	
	private Set<Material> picPaths = new HashSet<Material>();
	@Transactional(readOnly = true)
	public void save(UserTreatMaterial userTreatMaterial, MultipartFile[] files, HttpServletRequest request) {
		// �ж�file���鲻��Ϊ�ղ��ҳ��ȴ���0
		if (files != null && files.length > 0) {
			// ѭ����ȡfile�����е��ļ�
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// �����ļ�
				String picPath = saveFile(file,request);
				if(picPath != null){
				Material material = new Material(picPath);
				picPaths.add(material);
				}
			}
		}
		UserTreat userTreat = new UserTreat();
		userTreat.setClassType(userTreatMaterial.getClassType());
		userTreat.setDescription(userTreatMaterial.getDescription());
		userTreat.setMaterials(picPaths);
		User user = (User) request.getSession().getAttribute("user");
		userTreat.setUser(user);
		userTreatMaterialDAO.save(userTreat);
		
		
	}

	private String saveFile(MultipartFile file, HttpServletRequest request) {
		 // �ж��ļ��Ƿ�Ϊ��  
		String picPath = null;
        if (!file.isEmpty()) {  
            try {  
                // �ļ�����·��  
               picPath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
                        + file.getOriginalFilename();  
                // ת���ļ�  
                file.transferTo(new File(picPath));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
        return picPath;
	}

}
