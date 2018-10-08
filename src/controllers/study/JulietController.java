package controllers.study;

import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import controllers.IssueController;
import models.IssueRepository;

@Controller
@RequestMapping("/study")
public class JulietController {	
	@Autowired
	IssueRepository ir;
	
	@RequestMapping("/22.do")
	public void study22Handle() {
	List<Map> list= ir.getkate();
	System.out.println(list);
	}
	
	
	
}
