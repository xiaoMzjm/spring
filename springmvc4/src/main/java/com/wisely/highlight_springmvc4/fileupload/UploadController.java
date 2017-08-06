package com.wisely.highlight_springmvc4.fileupload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(value="/toupload" , method = RequestMethod.POST)
	@ResponseBody
	public String toUpload(MultipartFile file) {
		try {
			System.out.println("接收文件中...");
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			FileUtils.writeByteArrayToFile(new File("D:/" + file.getOriginalFilename()), file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "ok";
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/upload
	 */
	@RequestMapping(value="/upload")
	public String upload() {
		return "upload";
	}
}
