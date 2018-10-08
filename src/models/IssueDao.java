package models;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import org.apache.ibatis.session.SqlSession;



public class IssueDao extends MybatisDao {

	public IssueDao() throws IOException {
		super();
	}
	
	// issue 추가
	public int addissue(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("issue.addissue",map);
			if(r==1) {
				sql.commit();
			}
			return r;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			sql.close();
		}
	}//end addissue
	
	// issue list 전체 갖고오기
	public List<Map> getlistissue(){
		SqlSession sql = factory.openSession();
		try {
			List<Map> m = sql.selectList("issue.getlistissue");
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			return null;			
		}finally {
			sql.close();
		}
	}//end getlistissue
	
	// 해당 issue 갖고오기
	public Map getoneissue(int param) {
		SqlSession sql = factory.openSession();
		try {
			Map m = sql.selectOne("issue.getoneissue",param);
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sql.close();
		}
	}//end getoneissue
	
	// 댓글 메인에 뿌리기
	public List<Map> getcommentByid(String id) {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list=sql.selectList("issue.getcommentByid",id);
			return list;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sql.close();
		}
	}//end getwritingByid
	
	// 카테고리별 제목(갯수) 뿌리기
	public List<Map> getkate() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list = sql.selectList("issue.getkate");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}// end getkate
	
	// 카테고리 detail 목록 뿌리기
	public List<Map> getkateBycate(String cate){
		SqlSession sql=factory.openSession();
		try {
			List<Map> list=sql.selectList("issue.getkateBycate",cate);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sql.close();
		}
	}//end getkateBycate
	
	// main에서 24시간 이내 등록된 토론 출력
		public List<Map> getSomeRecent(){
			SqlSession sql=factory.openSession();
			try {
				List<Map> list=sql.selectList("issue.getSomeRecent");
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				sql.close();
			}
		}//end getkateBycate
	
	
	
	
}
