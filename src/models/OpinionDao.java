package models;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class OpinionDao extends MybatisDao{

	public OpinionDao() throws IOException {
		super();
	}
	
	public int addOne(Map a) {
		SqlSession sql = factory.openSession();
		try {
			int i = sql.insert("opinion.addOne",a);
			if(i==1) {
				sql.commit();
			}
			return i;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			sql.close();
		}
	}
	
	// 해당 comment 불러오기
	public List<Map> getCommentByIno(int ino) {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list = sql.selectList("opinion.getCommentByIno",ino);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}//end getCommentByIno
	
	// 댓글 많은 issue, main에 표시
	public List<Map> getcountByIno() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list = sql.selectList("opinion.getcountByIno");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			sql.close();
		}
	}//end getcountByIno
	
	// detail에서 Yes or No 출력
		public List<Map> getYesOrNo(int ino){
			SqlSession sql=factory.openSession();
			try {
				List<Map> list=sql.selectList("opinion.getYesOrNo",ino);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				sql.close();
			}
		}//end getYesOrNo
	
	 
}
