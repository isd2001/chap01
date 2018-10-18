package models;

import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.bulk.DeleteRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class HeroRepository {

	@Autowired
	MongoTemplate template;


	public Map insertOne(Map map) {
		return template.insert(map, "hero");	
	}//end insertOne

	public List<Map> findHeros_1(){
		Criteria c=Criteria.where("price.rp").gte(300).and("price.ip").gte(600);
		return template.find(new Query(c),Map.class,"hero");
	}//end findHeros_1

	public List<Map> findHeros_2(){
		Criteria c=Criteria.where("speciality").in("마법사");
		return template.find(new Query(c),Map.class,"hero");
	}//end findHeros_2

	public List<Map> findHeros_3(){
		Document doc = new Document("speciality",new Document("$size",4));
		Query query = new BasicQuery(doc);
		//=============================================
		Query query2 = new Query(Criteria.where("speciality").size(4));
		return template.find(query,Map.class,"hero");
	}//end findHeros_3

	public List<Map> findHeros_4(){
		// and,or 로 연결시키는건 새로운 필드에 조건을 설정하겠다는거고
		// 같은 필드가 또 나오면 문제가 발생.
		// 같은 필드에 조건을 여러개 설정하고싶다면
		// 특정키에 조건 여러개 설정해야된다면 andOperator() 해두고 안에다가 다 묶어두면 됨.
		Criteria p1 = Criteria.where("speciality").size(6);
		Criteria p2 = Criteria.where("speciality").in("전사");
		
		Criteria c =new Criteria().andOperator(p1,p2);
		System.out.println("c >>"+c);
		System.out.println("result >>"+c.getCriteriaObject().toJson());
		return template.find(new Query(c),Map.class,"hero");		
	}
	
	public void deleteOne() {
		Query q = new Query(Criteria.where("name").is("말자하"));
		DeleteResult dr= template.remove(q,"hero");
		long l = dr.getDeletedCount();
		System.out.println("result >>"+ l);
	}//end deleteOne
	
	public void updateSome() {
		Update update= new Update().set("avg", 10.0);
		UpdateResult ur=template.updateMulti(new Query(), update, "hero");
		// updateFirst 혹은 updateMulti
		System.out.println("result>>"+ur.getMatchedCount());
		
		Update u1 = new Update().inc("avg", 4);
		Update u2 = new Update().push("speciality","공포");
		Update u3 = new Update().pull("speciality","기절");
		
		//template.updateFirst(new Query(), u1, "hero");
	}//end updateSome
	
}
