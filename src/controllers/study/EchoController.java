package controllers.study;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Pet;

@Controller
@RequestMapping("/study")
@SessionAttributes("pet")	// 처리하고자 하는 컨트롤러에서 사용저 세션에 올라간 데이터를
public class EchoController {
	
	@RequestMapping("/11.do")
	public void study11handle(Pet pet) {
		System.out.println(pet);
		pet.setType(3);
	}
		
	@RequestMapping("/12.do")
	public String study12handle(Pet pet) {
		System.out.println(pet);	
		return "/WEB-INF/views/temp.jsp";
	}
	
}
