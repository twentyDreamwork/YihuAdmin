package cn.yihu.microboot.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	
	private static SimpleDateFormat smt = new SimpleDateFormat("yyyyMMddHHssmm");
	
	
	 /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }
 
    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return  smt.format(new Date())+ (new Random()).nextInt(10000) +getSuffix(fileOriginName);
    }
    
    /**
    *
    * @param file 文件
    * @param path   文件存放路径
    * @param fileName 原文件名
    * @return
    */
   public static String upload(MultipartFile file, String path, String fileName){

       String newFileName = getFileName(fileName);

       // 生成新的文件名
       String realPath = path + "/" + newFileName;

       File dest = new File(realPath);

       //判断文件父目录是否存在
       if(!dest.getParentFile().exists()){
           dest.getParentFile().mkdir();
       }

       try {
           //保存文件
           file.transferTo(dest);
           return newFileName;
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }

   }
}
