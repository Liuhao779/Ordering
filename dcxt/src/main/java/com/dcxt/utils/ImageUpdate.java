package com.dcxt.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yyangcr on 17-10-14.
 */
public class ImageUpdate {
   public static String uploadfile(MultipartFile file,String path) throws IOException {
    String name = file.getOriginalFilename(); //获取文件的真实姓名
       String suffixName=name.substring(name.lastIndexOf("."));
       String saveFileName= UUID.randomUUID().toString()+suffixName;
       File  tempfile  = new File(path,saveFileName);
       if(!tempfile.getParentFile().exists()){
           tempfile.getParentFile().mkdir();
       }
       if(tempfile.exists()){
           tempfile.delete();
       }
       tempfile.createNewFile();
       file.transferTo(tempfile);
       return tempfile.getName();


   }
}
