package models;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SpellRepository {

	@Autowired
	MongoTemplate template;
	
	public boolean insertSpellData(Map map) {
		try {
			return template.insert(map, "spell") != null;			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}//end insertSpellData
	
	public List<Map> getAllSpells(){
		//return template.findAll(Map.class,"spell");
		return template.find(new Query(), Map.class,"spell");
	}//end getAllSpells
	
	public Map getOneById(String id){
		Query query = new Query(Criteria.where("_id").is(id));
		return (Map) template.find(query,Map.class,"spell");
	}//end getOneById
	
}
