package mms.memver.db;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {
	
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드

	}
	
	//public static Connection getConnection(){
		//디비 작업에 필요한 Connection 객체를 생성해 주는 메소드
	//}
	
	public static void close(Connection con){
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}


	//transaction 처리 메소드
	public static void commit(Connection con) {
		try {
			con.commit();	// insert, update, delete
		} catch (SQLException e) {
			
		}
	}
	

	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			
		}
	}
	
}
