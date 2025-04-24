package Domain.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Controller.file.Properties;


public class FileServiceImpl {
	//싱글톤 패턴
	private static FileServiceImpl instance;
	private FileServiceImpl() throws Exception {
		System.out.println("[SERVICE] UserServiceImpl init...");
	};
	public static FileServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance = new FileServiceImpl();
		return instance ;
	}
	
	public boolean upload(HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException {
		
		LocalDateTime now = LocalDateTime.now();
		//yyyyMMdd_HHmmss 폴더명
		String folderName =now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		//업로드 경로 설정
		String UploadPath = Properties.ROOT_PATH
							+File.separator // '/'
							+Properties.UPLOAD_PATH
							+File.separator
							+folderName 
							+File.separator;
		//디렉토리 생성( c:\\upload\\20250421_102933\\ )
		File dir = new File(UploadPath);
		if(!dir.exists())
			dir.mkdirs();
		
		
		Collection<Part> parts =  req.getParts();
		for(Part part :parts) {
			
			System.out.println("PART's NAME : " + part.getName());
			System.out.println("PART's SIZE : " + part.getSize());
			String contentDisp = part.getHeader("content-disposition");
			String [] tokens =contentDisp.split(";");
			String filename = tokens[2].trim().substring(10 , tokens[2].trim().length()-1);
			System.out.println("contentDisp : " + contentDisp);
			System.out.println("tokens[2] : " + tokens[2]);
			System.out.println("filename : " + filename);
			
			part.write(UploadPath+filename);
		}

		return true;
	}
	public Map<String , List<File> > getFileList() {
		
		Map<String , List<File> > map = new LinkedHashMap();
		
		String UploadPath = Properties.ROOT_PATH
				+File.separator // '/'
				+Properties.UPLOAD_PATH;
		
		File dir = new File(UploadPath);
		if(dir.exists()&&dir.isDirectory()) {
			File [] folders =  dir.listFiles();	//폴더찾기
//			Arrays.stream(folders).forEach(System.out::println);
			for(File folder : folders) {
				File [] list = folder.listFiles();	//폴더 내 파일
				System.out.println("DIR : " + folder.getName());
				Arrays.stream(list).forEach(System.out::println);
				map.put(folder.getName(), Arrays.stream(list).collect(Collectors.toList()) );		
			}
			
		}
				
		return map;
	}
	
	
	public boolean download(HttpServletRequest req, HttpServletResponse response) throws IOException {
		String folder = req.getParameter("folder");
		String filename = req.getParameter("filename");
		System.out.println("FILENAME : " + filename + " folder : " + folder);
		
		String downloadPath = ""; // ROOTPATH(c:) + / + UPLOAD_PATH + / + FOLDER + / + FILENAME 
		downloadPath= 	Properties.ROOT_PATH 
						+ File.separator
						+ Properties.UPLOAD_PATH
						+ File.separator
						+ folder
						+ File.separator
						+ filename;
		
		response.setHeader("Content-Type","application/octet-stream;charset-utf-8");
		response.setHeader("Content-Disposition","attachment; filename="+ URLEncoder.encode(filename,"UTF-8").replaceAll("\\+", "")   );

		FileInputStream in = new FileInputStream(downloadPath);
		ServletOutputStream bout =  response.getOutputStream();
		byte[] buff = new byte[4096];
		while(true){
			int data = in.read(buff);
			if(data==-1)
				break;
			bout.write(buff,0,data);
			bout.flush();
		}
		bout.close();
		in.close();
		
		return true;
	}
}







