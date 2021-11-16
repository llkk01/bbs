package mms.memver.svc;

import java.sql.Connection;

import mms.memver.dao.MemberDAO;
import mms.memver.db.JdbcUtil;
import mms.memver.vo.Member;

// 8-1. 회원등록 Business Logic이 구현되는 Service 클래스 구현
public class MemberAddService {
	
	public boolean addMember(Member newMember) throws Exception{
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		boolean isInsertSucces = false;
		
		int insertCount = memberDAO.insertNewMember(newMember);
		if(insertCount > 0) {
			JdbcUtil.commit(con);
			isInsertSucces = true;
		} else {
			JdbcUtil.rollback(con);
		}
		return isInsertSucces;
	}

}
