package cn.yihu.microboot.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

/**
 * 阿里云 OSS工具类
 * 
 * @author Monkey
 * @date 2017年9月30日下午3:38:09
 * @version 1.0
 */
public class OSSClientUtil {

	public static final Logger logger = LoggerFactory.getLogger(OSSClientUtil.class);
	private static String endpoint = "oss-cn-beijing.aliyuncs.com";
	private static String accessKeyId = "LTAI4Fs3cRyRg8BDGxGE28jD";
	private static String accessKeySecret = "rpSDKfWczgGiaXTAHfPm4vkUDGGb0F";
	private static String bucketName = "yihuapp";
	
	private static String bucketDomain = "https://yihuapp.oss-cn-beijing.aliyuncs.com";
	// 文件存储目录
	private static String filedir = "upload";

	private static SimpleDateFormat smt = new SimpleDateFormat("yyyyMMdd");

	private OSSClient ossClient;

	public OSSClientUtil() {
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	/**
	 * 初始化
	 */
	public void init() {
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	/**
	 * 销毁
	 */
	public void destory() {
		ossClient.shutdown();
	}

	/**
	 * 上传图片
	 *
	 * @param url
	 * @throws Exception
	 */
	public void uploadImg2Oss(String url) throws Exception {
		File fileOnServer = new File(url);
		FileInputStream fin;
		try {
			fin = new FileInputStream(fileOnServer);
			String[] split = url.split("/");
			this.uploadFile2OSS(fin, split[split.length - 1]);
		} catch (FileNotFoundException e) {
			throw new Exception("图片上传失败");
		}
	}

	public String uploadImg2Oss(MultipartFile file) throws Exception {
		String originalFilename = file.getOriginalFilename();
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
		try {
			InputStream inputStream = file.getInputStream();
			this.uploadFile2OSS(inputStream, name);
			return name;
		} catch (Exception e) {
			throw new Exception("图片上传失败");
		}
	}

	/**
	 * 获得图片路径
	 *
	 * @param fileUrl
	 * @return
	 */
	public String getImgUrl(String fileUrl) {
		System.out.println(fileUrl);
		if (!StringUtils.isEmpty(fileUrl)) {
			String[] split = fileUrl.split("/");
			return this.getUrl(this.filedir + smt.format(new Date()) + "/" + split[split.length - 1]);
		}
		return null;
	}

	/**
	 * 上传到OSS服务器 如果同名文件会覆盖服务器上的
	 *
	 * @param instream 文件流
	 * @param fileName 文件名称 包括后缀名
	 * @return 出错返回"" ,唯一MD5数字签名
	 */
	public String uploadFile2OSS(InputStream instream, String fileName) {
		String ret = "";
		try {
			// 创建上传Object的Metadata
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(instream.available());
			objectMetadata.setCacheControl("no-cache");
			objectMetadata.setHeader("Pragma", "no-cache");
			objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf(".") + 1)));
			objectMetadata.setContentDisposition("inline;filename=" + fileName);
			// 上传文件
			PutObjectResult putResult = ossClient.putObject(bucketName,
					filedir + smt.format(new Date()) + "/" + fileName, instream, objectMetadata);
			ret = putResult.getETag();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (instream != null) {
					instream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * Description: 判断OSS服务文件上传时文件的contentType
	 *
	 * @param filenameExtension 文件后缀
	 * @return String
	 */
	public static String getcontentType(String filenameExtension) {
		if (filenameExtension.equalsIgnoreCase("bmp")) {
			return "image/bmp";
		} else if (filenameExtension.equalsIgnoreCase("gif")) {
			return "image/gif";
		} else if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
				|| filenameExtension.equalsIgnoreCase("png")) {
			return "image/jpeg";
		} else if (filenameExtension.equalsIgnoreCase("html")) {
			return "text/html";
		} else if (filenameExtension.equalsIgnoreCase("txt")) {
			return "text/plain";
		} else if (filenameExtension.equalsIgnoreCase("vsd")) {
			return "application/vnd.visio";
		} else if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
			return "application/vnd.ms-powerpoint";
		} else if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
			return "application/msword";
		} else if (filenameExtension.equalsIgnoreCase("xml")) {
			return "text/xml";
		} else if (filenameExtension.equalsIgnoreCase("xls") || filenameExtension.equalsIgnoreCase("xlsx")) {
			return "application/x-xls";
		} else if (filenameExtension.equalsIgnoreCase("pdf")) {
			return "application/pdf";
		} else {
			return "image/jpeg";
		}
	}

	public static String upload(byte[] data, String path) {
		return upload(new ByteArrayInputStream(data), path);
	}

	public static String upload(InputStream inputStream, String path) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		ossClient.putObject(bucketName, path, inputStream);
		return  bucketDomain + "/" + path;
	}

	public static String uploadSuffix(byte[] data, String suffix) {
		return upload(data, getPath(filedir,suffix));
	}

	public String uploadSuffix(InputStream inputStream, String suffix) {
		return upload(inputStream, getPath(filedir,suffix));
	}
	
	  /**
     * 文件路径
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回上传路径
     */
    public static String getPath(String prefix, String suffix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
        String path = smt.format(new Date()) + "/" + uuid;

        if(StringUtils.isNotBlank(prefix)){
            path = prefix + "/" + path;
        }

        return path + suffix;
    }
    
    /**
	 * 获得url链接
	 *
	 * @param key
	 * @return
	 */
	public String getUrl(String key) {
		// 设置URL过期时间为10年 3600l* 1000*24*365*10

		Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
		// 生成URL
		URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			return url.toString();
		}
		return null;
	}
}
