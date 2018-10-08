package models;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import org.apache.ibatis.session.SqlSession;



public class IssueDao extends MybatisDao {

	public IssueDao() throws IOException {
		super();
	}
	
	// issue �߰�
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
	
	// issue list ��ü �������
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
	
	// �ش� issue �������
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
	
	// ��� ���ο� �Ѹ���
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
	
	// ī�װ��� ����(����) �Ѹ���
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
	
	// ī�װ� detail ��� �Ѹ���
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
	
	// main���� 24�ð� �̳� ��ϵ� ��� ���
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
