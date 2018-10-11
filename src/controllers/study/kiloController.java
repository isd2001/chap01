package controllers.study;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import models.AlertService;

/*
 * Multipart 처리 (File upload)
 *  - Spring은 Multipart 요청도 처리하게 편하게 처리해서 요청처리 메서드에 Inject 해준다.
 *  어떤 라이브러리를 써서 분석할껀지만 설정해주면 된다.
 *  
 *  Spring에서는 멀티파트 parsing 라이브러리로 Commons File Upload lib 로 처리한다.
 *  
 *  maven repository 에서 Apache commons fileupload (+Apache commons IO) 
 *  를 찾아서 pom.xml 에 등록후,
 *  
 *  Spring bean configuration 파일에 가서
 *  
 *  multipartResolver 를 등록
 */
@Controller
@RequestMapping("/study")
public class kiloController {
	@Autowired
	ServletContext ctx;
	@Autowired
	AlertService service;
	
	@RequestMapping("/26.do")
	public String study26Handle() {
		String json="{\"mode\":\"upload\"}";
		service.sendAll(json);
		return "upload";
	}
	
	@RequestMapping("/27.do")
	public void study27Handle(@RequestParam String info, 
			@RequestParam MultipartFile attach) throws IOException {
		System.out.println("info = " + info );
		System.out.println("attach = " + attach +"/ " + attach.isEmpty() );
		// MultipartFile 객체는 첨부된 파일데이터가 없어도 생성된다, Empty 체크할것.
		// 기본적으로 임시 디렉터리에 저장되고, 
		String type= attach.getContentType();	// 파일종류
		String fileName= attach.getOriginalFilename();	// 파일명
		String name= attach.getName();	// 파라미터명임 (attach)
		long size = attach.getSize();	// 파일크기
		
		System.out.println("type >"+type+",filename > "+fileName+", name > "+name+",size > "+size);
		
		// 파일정보들은 database같은걸 이용해서 기록을 해두겠지만 ,실제 업로드 처리를 하려면..
		// attach.transferTo(dest);		
		// 이 파일을 어디로 옮길껀지 설정해서 경로와 파일명 지정해서 File객체를 만들어서 설정
		// file객체를 만들어서 설정 , 실제 서버내부로 저장하기 위해선
		// application.getRealPath를 이용해서 경로를 얻어야 하는데,
		// ServletContext 객체는 따로 매개변수로 설정해서 사용하는게 아니라 Autowired 처리해서
		
		String path=ctx.getRealPath("/storage");
		System.out.println("path > "+ path);
		
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File dst = new File(dir,fileName);
		attach.transferTo(dst);
	}
	
	@RequestMapping("/28.do")
	public String study28Handle() {
		return "upload2";
	}
	
	@RequestMapping("/29.do")
	public void study29Handle(@RequestParam MultipartFile[] attach) {
		if (attach.length==1 && attach[0].isEmpty()) {
			System.out.println("업로드된 파일이 없다.");
		}else {
			System.out.println("업로드된 파일 갯수 >> "+attach.length);
			for (int i = 0; i < attach.length; i++) {
				System.out.println("->"+attach[i].getOriginalFilename());
				// attach[i].transferTo();
				
			}
		}		
	}
	
	
}








