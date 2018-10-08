package models;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * 	BD 억세스해서 데이터 연동작업하는 객체를
 *  DAO 라고도 부르고 , Repository 라고 부른다.
 */

@Repository
public class IssueRepository {
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> getlistissue(){
		SqlSession session = factory.openSession();
		try {
			return session.selectList("issue.getlistissue");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}//end getlistissue
	
	public List<Map> getkate(){
		return template.selectList("issue.getkate");
	}//end getkate
	
	
}
