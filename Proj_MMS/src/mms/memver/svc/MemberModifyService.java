package mms.memver.svc;

import java.sql.Connection;

import mms.memver.dao.MemberDAO;
import mms.memver.db.JdbcUtil;
import mms.memver.vo.Member;

public class MemberModifyService {
	
	public boolean modifyMember(Member updatemember) {
		boolean isModifySuccess = false;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		int updateCount =memberDAO.updateMember(updatemember);
		if(updateCount > 0) {
			isModifySuccess = true;
			JdbcUtil.commit(con);
		} else {
			JdbcUtil.rollback(con);
		}
		JdbcUtil.close(con);
		return isModifySuccess;
	}

}
