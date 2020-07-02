package com.yun.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yun.dao.UserDao;
import com.yun.pojo.User;
@Service
public class FileService {
    //文件相对前缀
    public static final String PREFIX = "WEB-INF" + File.separator + "file" + File.separator;
    //新用户注册默认文件夹
    public static final String[] DEFAULT_DIRECTORY = { "vido", "music", "source", "image", User.RECYCLE };
    @Autowired
    private UserDao userDao;

    /*
     * 新用户新建文件
     * 
     * @param request
     * @param namespace
     * */
    public void addNewNameSpace(HttpServletRequest request, String namespace) {
        String fileName = getRootPath(request);
        File file = new File(fileName, namespace);
        file.mkdirs();
        for (String newFileName : DEFAULT_DIRECTORY) {
            File newFile = new File(file, newFileName);
            newFile.mkdirs();
        }
    }
    
    /*
     * 获得文件路径
     * */
	public String getRootPath(HttpServletRequest request) {
		String rootpath2=request.getSession().getServletContext().getContextPath()+"/WebContent/"+PREFIX;
		System.out.println(rootpath2);
		return rootpath2;
	}
  

    
}
