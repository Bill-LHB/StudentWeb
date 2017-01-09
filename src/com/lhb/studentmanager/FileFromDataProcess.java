package com.lhb.studentmanager;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lhb.studentmanager.utils.FileUtil;

public class FileFromDataProcess {
	private static String SystemSeparator = new Character(File.separatorChar).toString();// 系统分割符
	public static ArrayList<String> fileNames = new ArrayList<>();// 文件列表

	public static HashMap<String, String> getFileFromData(HttpServletRequest request)
			throws UnsupportedEncodingException {
		HashMap<String, String> parameterMap = new HashMap<>();
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> fileItemLists = null;
		try {
			fileItemLists = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> iterator = fileItemLists.iterator();
		while (iterator.hasNext()) {
			FileItem fileItem = iterator.next();
			// 如果是表单数
			if (fileItem.isFormField()) {
				FormDataDispose(fileItem, parameterMap);
			} else {// 文件操作
				FileDataDispose(fileItem, request, parameterMap);
			}
		}
		return parameterMap;
	}

	/**
	 * 表单数据处理
	 * 
	 * @param fileItem
	 * @throws UnsupportedEncodingException
	 */
	private static void FormDataDispose(FileItem fileItem, HashMap<String, String> parameterMap)
			throws UnsupportedEncodingException {
		String filedName = fileItem.getFieldName();

		String fileValue = fileItem.getString("UTF-8");

		parameterMap.put(filedName, fileValue);
	}

	/**
	 * 文件数据处理
	 * 
	 * @param fileItem
	 * @param request
	 */
	private static void FileDataDispose(FileItem fileItem, HttpServletRequest request,
			HashMap<String, String> parameterMap) {
		// 判断是否有上传文件。如果没有则parameterMap中对应值置为""。并结束方法
		String filename = fileItem.getFieldName();// 文件名
		fileNames.add(filename);// 将字段名传入文件字段数组中
		if (fileItem.getName() == null || fileItem.getName().equals("")) {
			parameterMap.put(filename, "");
			return;
		}

		String fileName = getFileNameByPath(fileItem.getName());// 文件名
		String rootDir = request.getServletContext().getRealPath(SystemSeparator);
		String fileDir = "upload" + SystemSeparator + fileName;
		File file = new File(rootDir + fileDir);
		FileUtil.createFile(file);
		try {
			fileItem.write(file);
		} catch (Exception e) {
			e.printStackTrace();

		}
		parameterMap.put(filename, fileDir);
	}

	/**
	 * 判断是否上传新文件 是否删除原文件
	 * 
	 * @param oldFile
	 * @param name
	 * @param parameterMap
	 * @param request
	 */
	public static void deleteOldFile(HashMap<String, String> parameterMap, String propertyname, String oldFile,
			String rootPath) {
		
		String newFile = parameterMap.get(propertyname);// 从parameterMap获取newFile的值

		if (newFile.equals("")) {// 当值为空时，不予删除，并将原字段值传入parameterMap中
			parameterMap.put(propertyname, oldFile);
			return;
		}

		String header_file = rootPath + oldFile;

		File file = new File(header_file);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 
	 * @param path
	 *            传入文件路径或文件名 F:\img\123.jpg ;223.jpg
	 * @return 文件名 123.jpg；223.jpg
	 */
	private static String getFileNameByPath(String path) {
		if (!path.contains("/") && !path.contains("\\")) {
			return path;
		}
		int a = path.lastIndexOf("/");
		int b = path.lastIndexOf("\\");
		int index = a > b ? a : b;
		return path.substring(index + 1);
	}

}
