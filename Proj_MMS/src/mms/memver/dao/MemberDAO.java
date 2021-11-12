package mms.memver.dao;

import java.sql.Connection;
import java.util.ArrayList;

import mms.memver.vo.Member;

// 9. Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
public class MemberDAO {
	
	Connection con;
	public MemberDAO(Connection con) {
	this.con = con;
	}
	
	//public int insertNewMember(Member newMember) {
		// String sql = "insert부분 작성"
	//}
	
	

}
