package cn.yihu.microboot.common.controller;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.yihu.microboot.util.FileUtils;
import cn.yihu.microboot.util.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "上传管理")
@RestController
@RequestMapping("/upload")
public class UploadController {

	/**
	 *
	 * @param file 上传的文件
	 * @return
	 */
	@ApiOperation(value = "上传接口")
	@RequestMapping("/fileUpload")
	public Results upload(@RequestParam("file") MultipartFile file) {
		boolean success = false;
		int code = 1;
		String msg = "上传失败";
		// 1定义要上传文件 的存放路径
		String localPath = "D:\\upload\\images";
		File dir = new File(localPath);

		//如果文件夹不存在则创建    
		if (!dir.exists() && !dir.isDirectory()) {
			System.out.println("//不存在");
			dir.mkdir();
		} else {
			System.out.println("//目录存在");
		}
		// String localPath = "/data/images";
		String newFileName = "";
		if (file.getSize() > 100000000) { // 设置上传限制 ： 1M
			msg = "最大上传1M的图片";
		} else {
			// 2获得文件名字
			String fileName = file.getOriginalFilename();
			// 2上传失败提示
			newFileName = FileUtils.upload(file, localPath, fileName);
			if (newFileName != null) {
				// 上传成功
				success = true;
				code = 0;
				msg = "上传成功";
			}
		}

		return Results.resultDTO(success, code, msg, newFileName);
	}

}
