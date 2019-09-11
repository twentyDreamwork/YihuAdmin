package cn.yihu.microboot.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.yihu.microboot.util.OSSClientUtil;
import cn.yihu.microboot.util.Results;
import io.swagger.annotations.Api;

@Api(value = "上传管理")
@RestController
@RequestMapping("/upload")
public class UploadController {
	
	
	 
	  /**
		 * 上传文件
		 */
		@RequestMapping("/fileUpload")
		public Results<String> fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
			//上传文件
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String url = OSSClientUtil.uploadSuffix(file.getBytes(), suffix);
			return Results.resultSucc(url);
		}
		

}
