package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * RequestMappingHandlerMapping 에 의해서 작동되게 될 컨트롤러 는
 *	특정 클래스를 상속을 받아서 만들어야 할 필요는 없고, POJO 형태의 설계가 가능하다.
 *	(Plain Old Java Object : 평범한 기본 자바 객체) 
 *
 */

@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public void indexHandle() {
		System.out.println("indexController.indexHandle()");
	}
	
}
