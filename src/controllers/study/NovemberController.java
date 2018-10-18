package controllers.study;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.HeroRepository;
import models.SpellRepository;

@Controller
@RequestMapping("/study")
public class NovemberController {
	@Autowired
	HeroRepository hero;
	
	@Autowired
	SpellRepository spell;
	
	@RequestMapping("/51.do")
	public void study51Handle(@RequestParam Map map) {
		boolean b = spell.insertSpellData(map);
		System.out.println("result >> "+ b);
	}//end 51.do
	
	@RequestMapping("/52.do")
	public void study52Handle() {
		List<Map> list = spell.getAllSpells();
		for (int i = 0; i < list.size(); i++) {			
			System.out.println("result >> "+ list.get(i));
			System.out.println("result_id >> "+ list.get(i).get("_id"));
		}
	}//end 52.do
	
	@RequestMapping("/53.do")
	public void study53Handle(@RequestParam String id) {
		System.out.println("param id > "+id);
		Map map = (Map) spell.getOneById(id);
		System.out.println("_id >> "+ map);

	}//end 53.do
	
	@RequestMapping("/54.do")
	public void study54Handle() {
		List<Map> list = hero.findHeros_1();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("hero"+list.get(i));
		}		
	}//end 54.do
	
	@RequestMapping("/55.do")
	public void study55Handle() {
		List<Map> list = hero.findHeros_2();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("hero"+list.get(i));
		}		
	}//end 55.do
	
	@RequestMapping("/56.do")
	public void study56Handle() {
		List<Map> list = hero.findHeros_3();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("hero"+list.get(i));
		}		
	}
	
	@RequestMapping("/57.do")
	public void study57Handle() {
		List<Map> list = hero.findHeros_4();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("hero>"+list.get(i));
		}		
	}
	
	@RequestMapping("/58.do")
	public void study58Handle() {
		hero.deleteOne();
	}
	
	@RequestMapping("/59.do")
	public void study59Handle() {
		hero.updateSome();
	}
	
}
