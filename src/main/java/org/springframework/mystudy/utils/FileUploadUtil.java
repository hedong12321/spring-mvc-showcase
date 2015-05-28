package org.springframework.mystudy.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	// 默认大小 2M
	public static final long DEFAULT_MAX_SIZE = 2097152;
	// 默认上传的地址
	public static String defaultBaseDir = "upload";
	
	public static final String upload(HttpServletRequest req, MultipartFile file)
		throws Exception {
		String fileName = extractFileName(file, defaultBaseDir);
	    File desc = getAbsoluteFile(extractUploadDir(req), fileName);
	    file.transferTo(desc);
	    return fileName;
	}
	
	public static final File getAbsoluteFile(String uploadDir, String fileName)
		throws IOException{
		if(uploadDir.endsWith("/")) {
			uploadDir = uploadDir.substring(0, uploadDir.length() - 1);
		}
		
		if(fileName.startsWith("/")) {
			fileName = fileName.substring(1);
		}
		
		File desc = new File(uploadDir + "/" + fileName);
		if(!desc.getParentFile().exists()) {
			desc.getParentFile().mkdirs();
		}
		
		if(!desc.exists()) {
			desc.createNewFile();
		}
		
		return desc;
	}
	
	public static final String extractFileName(MultipartFile file, String baseDir)
			throws UnsupportedEncodingException {
		String fileName = file.getOriginalFilename();
		int slashIndex = fileName.indexOf("/");
		if (slashIndex >= 0) {
			fileName = fileName.substring(slashIndex + 1);
		}
		fileName = baseDir + "/" + fileName;
		
		return fileName;
	}
	
	public static final String extractUploadDir(HttpServletRequest req) {
		return req.getServletContext().getRealPath("/");
	}
}
