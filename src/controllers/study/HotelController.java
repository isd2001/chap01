package controllers.study;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/study")
public class HotelController {
	/*
	 * 	응답에 관여하게 되는 어노테이션(@)
	 *  @ResponseBody 어노테이션은 return type 을 String 으로 설정하고 붙이게 되는데
	 *  이럴 경우 에는 이 return 되는 문자열을 처리해야될 view 이름으로 생각하지 않고,
	 *  바로 write() 를 해준다.	
	 *  
	 *  기본 contentType="text/html;charset=ISO-8859-1" 형태로 출력이 일어나서,
	 *  ResponseBody 로 출력하고자 하는 String 에 한글이 있다면 제대로 응답으로 전달되지 않는다.
	 *  (Servlet으로 만들던 MVC에서는 response.setContentType 에 설정을 했었다.)
	 *  Spring 에서는 RequsetMapping 에 옵션으로 설정을 해야된다.
	 *  (path만 잡는거면 String 으로 밸류 하나 설정하면 되지만,
	 *    produces 까지 설정 해야되다면 , String 값들이 어떤걸 의미하는건지 설정을 해야한다.)
	 */
	@RequestMapping(path="/94.do",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String study94Handle() {
		return "{\"rst\":true,\"keyword\":\"개천절\"";
	}
	/*
	 * @RequestBody 와 @ResponsBody 는 AJAX 처리를 돕기 위해서 만들어진 어노테이션 이다.
	 */
	@RequestMapping("/93.do")
	public String study93Handle(Map map) {
		map.put("json", "{\"rst\": true, \"keyword\":\"개천절\"}");
		return "printJson";
	}
	
	
}
