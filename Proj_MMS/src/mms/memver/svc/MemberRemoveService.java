package mms.memver.svc;

import java.sql.Connection;
import mms.memver.dao.MemberDAO;
import mms.memver.db.JdbcUtil;

// 8-4. 회원정보 삭제 요청을 처리하는 Business Logic이 구현되는 Service 클래스 구현
public class MemberRemoveService {

	public boolean removeMember(String name) {

		boolean isRemoveSuccess = false;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);

		int deleteCount = memberDAO.deleteMember(name);
		if (deleteCount > 0) {
			isRemoveSuccess = true;
			JdbcUtil.commit(con);
		} else {
			JdbcUtil.rollback(con);
		}
		JdbcUtil.close(con);
		return isRemoveSuccess;
	}
}