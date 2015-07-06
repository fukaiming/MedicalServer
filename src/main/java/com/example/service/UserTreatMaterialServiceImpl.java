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
		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// 保存文件
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
		 // 判断文件是否为空  
		String picPath = null;
        if (!file.isEmpty()) {  
            try {  
                // 文件保存路径  
               picPath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
                        + file.getOriginalFilename();  
                // 转存文件  
                file.transferTo(new File(picPath));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
        return picPath;
	}

}
