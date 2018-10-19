package models;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class RealTimeService {
	@Autowired
	Gson gson;
	
	public Map getByStation(Map param) {
		System.out.println("param > "+param);
		
		RestTemplate template = new RestTemplate();
		String addr = "http://swopenapi.seoul.go.kr/api/subway/sample/json/realtimeStationArrival/0/5/{station}";
		String json = template.getForObject(addr, String.class, param);
		System.out.println("json > "+json);
		Map map = gson.fromJson(json, Map.class);
		return map;
	}
}
