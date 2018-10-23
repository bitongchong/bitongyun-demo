package com.bitongyun.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bitongyun.bean.User;
import com.bitongyun.constvalue.ConstValue;
import com.bitongyun.utils.AliyunOSSUtil;
import com.bitongyun.utils.FileTypeJudgeUtil;
import com.bitongyun.utils.MybatisUtils;

@Controller
@SessionAttributes("current_user")
public class UploadController {
    /**
     * 文件上传
     * @param file
     */
    @RequestMapping(value = "upload",method = RequestMethod.POST)

    public ModelAndView upload(MultipartFile file,@ModelAttribute("current_user")User user){
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("upload_sucess");
            try {
            if(null != file){
                String filename = file.getOriginalFilename();
//              System.out.println(filename);
                if(!"".equals(filename.trim())){ 
//                	在这儿添加路径就行
                    File newFile = new File(ConstValue.TEMPFILEPATH+filename);
                    
//                    FileOutputStream os = new FileOutputStream(newFile);
//                    os.write(file.getBytes());
//                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    String uploadUrl = "https://"+ConstValue.BUCKETNAME+"."+ConstValue.ENDPOINT+"/"+AliyunOSSUtil.upload(newFile);
//                  这儿看一下是不是要写一个互斥锁
                    
                    MybatisUtils myUtils = new MybatisUtils();
    				SqlSession session = myUtils.getSession();
//    				下面注释的是一个识别文件类型的包，结果这玩意儿txt不能识别。。。
//    			    Magic parser = new Magic();  
//    				MagicMatch match = parser.getMagicMatch(newFile, false);  
//    				System.out.println(match.getMimeType()) ;  
    				String fileType = FileTypeJudgeUtil.getFileType(ConstValue.TEMPFILEPATH+filename);
    				if (fileType == null) {
						System.out.println("其他");
						String statement5 = "com.bitongyun.fileMapper.addOther";
	    				Date date=new Date();     //获取一个Date对象
	    				Timestamp timeStamp = new Timestamp(date.getTime());
	    				com.bitongyun.bean.File current_file = new com.bitongyun.bean.File(filename,uploadUrl,user.getUser_name(),timeStamp);
	    				int result = session.insert(statement5, current_file);
	    				//这儿是1，就是上传和保存成功
	    				System.out.println("+++++++"+result);
					} else if (fileType.equals("mp3")) {
						System.out.println("音乐");
						String statement5 = "com.bitongyun.fileMapper.addMusic";
	    				Date date=new Date();     //获取一个Date对象
	    				Timestamp timeStamp = new Timestamp(date.getTime());
	    				com.bitongyun.bean.File current_file = new com.bitongyun.bean.File(filename,uploadUrl,user.getUser_name(),timeStamp);
	    				int result = session.insert(statement5, current_file);
	    				//这儿是1，就是上传和保存成功
	    				System.out.println("+++++++"+result);
					} else if (fileType.equals("wav")||fileType.equals("mp41")||fileType.equals("mp42")||fileType.equals("avi")
							||fileType.equals("mpg")||fileType.equals("mkv")) {
						System.out.println("视频");
						String statement5 = "com.bitongyun.fileMapper.addVideo";
	    				Date date=new Date();     //获取一个Date对象
	    				Timestamp timeStamp = new Timestamp(date.getTime());
	    				com.bitongyun.bean.File current_file = new com.bitongyun.bean.File(filename,uploadUrl,user.getUser_name(),timeStamp);
	    				int result = session.insert(statement5, current_file);
	    				//这儿是1，就是上传和保存成功
	    				System.out.println("+++++++"+result);
					} else if (fileType.equals("pdf")||fileType.equals("xlsx")||fileType.equals("pdf")
							||fileType.equals("xls")||fileType.equals("txt")||fileType.equals("doc")
							||fileType.equals("docx")||fileType.equals("doc")) {
						System.out.println("文档");
						String statement5 = "com.bitongyun.fileMapper.addDoc";
	    				Date date=new Date();     //获取一个Date对象
	    				Timestamp timeStamp = new Timestamp(date.getTime());
	    				com.bitongyun.bean.File current_file = new com.bitongyun.bean.File(filename,uploadUrl,user.getUser_name(),timeStamp);
	    				int result = session.insert(statement5, current_file);
	    				//这儿是1，就是上传和保存成功
	    				System.out.println("+++++++"+result);
					}else if (fileType.equals("png")||fileType.equals("gif")||fileType.equals("jpg")
							||fileType.equals("ps")) {
						System.out.println("图片");
						String statement5 = "com.bitongyun.fileMapper.addPhoto";
	    				Date date=new Date();     //获取一个Date对象
	    				Timestamp timeStamp = new Timestamp(date.getTime());
	    				com.bitongyun.bean.File current_file = new com.bitongyun.bean.File(filename,uploadUrl,user.getUser_name(),timeStamp);
	    				int result = session.insert(statement5, current_file);
	    				//这儿是1，就是上传和保存成功
	    				System.out.println("+++++++"+result);
					}else if (fileType.equals("zip")||fileType.equals("rar")) {
						System.out.println("压缩包");
						String statement5 = "com.bitongyun.fileMapper.addZip";
	    				Date date=new Date();     //获取一个Date对象
	    				Timestamp timeStamp = new Timestamp(date.getTime());
	    				com.bitongyun.bean.File current_file = new com.bitongyun.bean.File(filename,uploadUrl,user.getUser_name(),timeStamp);
	    				int result = session.insert(statement5, current_file);
	    				//这儿是1，就是上传和保存成功
	    				System.out.println("+++++++"+result);
					}
    				newFile.delete();
                    modelAndView.addObject("file_url", uploadUrl);
                    System.out.println(uploadUrl);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return modelAndView; 
        }
        return modelAndView;
    }
 
    @RequestMapping(value = "upload",method = RequestMethod.GET)
    public String toUploadBlog(){
        return "upload";
    }
}
