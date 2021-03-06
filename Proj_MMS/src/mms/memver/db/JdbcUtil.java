package mms.memver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtil {
	
	// 메모리에 실행된 상태로 존재
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음: 해당 클래스를 찾을 수 없습니다.");
		}
	}
	
	// 메모리에 있는 메소드 호출이 일어나야 실행
	public static Connection getConnection(){
		//디비 작업에 필요한 Connection 객체를 생성해 주는 메소드
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
//			con.setAutoCommit(true);  //true - commit 실행
			con.setAutoCommit(false); //false = commit 할 수 있는 시작점(Transaction)
		} catch (SQLException e) {
			System.out.println("주소,ID,PW가 다릅니다.");
		}
		return con;
	}
	 
	
	public static void close(Connection con){
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try{
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt){
		try{
			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try{
			rs.close();
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
			con.rollback();	// insert, update, delete
		} catch (SQLException e) {
			
		}
	}
	
}
