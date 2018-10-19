package controllers.study;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import models.RealTimeService;

@Controller
@RequestMapping("/study")
public class OscarController {

	@RequestMapping("/61.do")
	public void study61Handle() {
		String addr = "http://swopenapi.seoul.go.kr/api/subway/sample/json/realtimeStationArrival/0/5/서울";
		try {
			URL url = new URL(addr);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String rst="";
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				rst += line;
			}
			
			System.out.println(rst);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Autowired
	Gson gson;
	
	@RequestMapping("/62.do")
	public void study62Handle() {
		// OpenAPI 를 사용하기 위해서 요청을 보낼때 인자를 많이 설정해야된다면, 설정하기가 힘들꺼다.
		// RestTemplate 객체를 이용해서 처리하면, 좀더 쉬운 처리가 가능하다
		RestTemplate template = new RestTemplate();
		String addr = "http://swopenapi.seoul.go.kr/api/subway/{key}/json/realtimeStationArrival/0/5/{station}";
		String json = template.getForObject(addr, String.class, "sample","강남");
		System.out.println("json > "+json);
		Map map = gson.fromJson(json, Map.class);
		for(Iterator<Entry> it= map.entrySet().iterator(); it.hasNext(); ) {
			Entry e= it.next(); 
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println();
		}
	}
	
	@Autowired
	RealTimeService realtimeservice;
	
	
	
	@RequestMapping("/63.do")
	public void study63Handle(@RequestParam Map p) {
		Map map=realtimeservice.getByStation(p);
		System.out.println("map > "+map);
		for (int i = 0; i < map.size(); i++) {
			
			
		}
		
	}
	
	@GetMapping("/api.do")
	public String APIgetHandle() {
		return "test";
	}
	
	@PostMapping("/api.do")
	public String APIpostHandle(@RequestParam Map station,ModelMap map) {
		System.out.println("역>" + station);
//		Map m = new HashMap<>();
//			m.put("station", station);
		
		List<Map> m = (List<Map>)realtimeservice.getByStation(station);
		
		System.out.println("map > "+m);
		
		//System.out.println("error > "+m.get("errorMessage"));
		//System.out.println("realtimeArrivalList > "+m.get("realtimeArrivalList"));
//		Map mm = new HashMap<>();
//			mm.put("realtimeArrivalList", m.get("realtimeArrivalList"));
//		
//		System.out.println("mm > "+mm);
		
		for (int i = 0; i < m.size(); i++) {
			System.out.println("map2 > "+m.get(i));
		}
			
		map.addAttribute("station",m);
		
		return "test";
	}
	
	
	
	
	
	
	
	
}
