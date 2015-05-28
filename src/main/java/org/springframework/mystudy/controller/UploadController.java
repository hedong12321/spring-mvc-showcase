package org.springframework.mystudy.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mystudy.utils.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/mystudy")
public class UploadController {

	@RequestMapping("/upload")
	public String toAjaxPage() {
		return "/mystudy/upload";
	}

	@RequestMapping(value = "/upload/up", method = RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam(value = "files", required = false) MultipartFile[] files) {
		try {
			for (int i = 0; i < files.length; i++) {
				FileUploadUtil.upload(request, files[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/mystudy/success";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletRequest request,
			HttpServletResponse response, String fileName) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		String newFileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		String ctxPath = request.getSession().getServletContext().getRealPath("/")
				+ FileUploadUtil.defaultBaseDir;
		String downLoadPath = ctxPath + "/" + newFileName;
		long fileLength = new File(downLoadPath).length();
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(newFileName.getBytes("gb2312"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));
		
		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}

}
