package models;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class AccountDao extends MybatisDao {

	public AccountDao() throws IOException {
		super();
	}
	
	//ȸ�������� ��, �ߺ�ó����
	public Map getById(String id){
		SqlSession sql = factory.openSession();
		try {
			Map p = sql.selectOne("account.getById",id);
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sql.close();
		}
	}
	
	public int add(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("account.add",map);
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
	}
	
	//�α��ο�
	public Map getByIdAndPass(Map map){
		SqlSession sql = factory.openSession();
		try {
			Map p = sql.selectOne("account.getByIdAndPass",map);
			return p;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sql.close();
		}
	}
}
