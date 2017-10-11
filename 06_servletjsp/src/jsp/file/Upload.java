package jsp.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/jsp/file/upload")
public class Upload extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이클립스 소스 관련 작업 디렉토리 활용 - 이미지 업로드시 바로 적용이 되지 않는다.		
		// String uploadPath = "D:/git/bit-java90/06_servletjsp/WebContent/upload";
		
		// 실제 웹 어플리케이션(컨텍스트, 프로젝트)가 실행되는 경로 활용
//		String uploadPath = "C:/java90/tomcat-work/wtpwebapps/06_servletjsp/upload";
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		System.out.println("uploadPath : " + uploadPath);
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		System.out.println("datePath : " + datePath);
		
		uploadPath += datePath;
		
		// uploadPath에 해당하는 디렉토리가 존재하지 않는다면 생성
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				uploadPath, 
				1024 * 1024 * 100, 
				"utf-8", 
				new MlecFileRenamePolicy()
//				new DefaultFileRenamePolicy()
		);
		System.out.println("파일이 정상적으로 업로드  되었습니다.");
		
		// 데이터베이스에 정보를 저장하기 위해서 정보 추출하기
		/* 기본 제공되는 API 사용이 불가능
		String msg = request.getParameter("msg");
		System.out.println("msg : " + msg);
		
		String attachFile = request.getParameter("attachFile");
		System.out.println("attachFile : " + attachFile);
		*/
		
		String msg = mRequest.getParameter("msg");
		System.out.println("msg : " + msg);
		
		// 사용자 화면의 file 타입의 name 속성값을 설정
		// <input type="file" name="attachFile" />
		File file = mRequest.getFile("attachFile");
		// file 이 null이라면 사용자가 파일을 선택하지 않은 경우임
		// 따라서 file의 정보를 추출하려면 null이 아닐 경우에 진행한다.
		if (file != null) {
			// 사용자가 선택한 파일 정보를 추출
			String oriFileName = mRequest.getOriginalFileName("attachFile");
			// 서버에 저장된 파일 이름
			String fileSystemName = mRequest.getFilesystemName("attachFile");
			// 파일의 바이트 크기
			long size = file.length();
			System.out.println("--------------------------------");
			System.out.println("oriFileName : " + oriFileName);
			System.out.println("fileSystemName : " + fileSystemName);
			System.out.println("size : " + size);
			System.out.println("--------------------------------");
		}
	}
	
	/*  파일 업로드 스트림 확인용
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		InputStream in = request.getInputStream();
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			out.println(sc.nextLine());
		}
		out.close();
	}
	*/
}













