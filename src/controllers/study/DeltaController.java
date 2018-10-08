package controllers.study;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import model.Pet;

/*
 * 	요청처리 메서드에 사용할수 있는 인자들을 좀더 살펴보자.
 */

@Controller
@RequestMapping("/study")
public class DeltaController {
	
	@RequestMapping("/09.do")
	public void study09handle(WebRequest web) {
		web.setAttribute("auth", true, WebRequest.SCOPE_SESSION);
		Map one =new HashMap<>();
			one.put("ID", "saan");
			one.put("NAME", "김기현");
			one.put("grade", 3);
		web.setAttribute("user", one, WebRequest.SCOPE_SESSION);
		
		Pet p = new Pet();
			p.setName("강백호");
		web.setAttribute("pet", p,WebRequest.SCOPE_SESSION);
	}
	//============================================
	
	/*
	 * 	@SessionAttribute
	 * 	사용자세션에 이미 존재하는 특정객체를 확보해서 요청처리를 하고자 할때 사용.
	 * 	(세션에 존재하지 않을 때는 , 객체확보 를 못하기 때문에 error 가 발생한다.
	 * 	 없는 상황일때 작동할수도 있다면 , required=false 를 설정하면 된다.)
	 * 
	 *  cf#
	 *  @RequestAttribute 도 이와 비슷하게 작동하게 되는데 , 
	 *  Request 객체에 setAttrubute 된 객체를 바로 확보해서 처리하고자 할때 사용한다.
	 *  지금같이 바로 사용자 요청에 의해서 메서드가 작동하게 될때는 확보할게 없고 , 
	 *  Filter 나 , Listener 나 , Intercepter (Spring에서 지원하는 필터객체)를 사용하게 되면
	 */
	@RequestMapping("/10.do")
	public void study10handle(@SessionAttribute(required=false) boolean auth, @SessionAttribute(required=false) Map user) {
		System.out.println(auth);
		System.out.println(user);
	}
	
	
	
}
