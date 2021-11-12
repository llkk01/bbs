package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// SCOTT DB에 있는 EMP테이블 데이터를 자바에서 출력하기
// 조건 - 스캐너 입력을 받아서 empno가 7902에 해당하는 레코드 출력하기
public class EmpEx2 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.Driver 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 2.계정연결
			conn = DriverManager.getConnection(url, "scott", "scott");
			stmt = conn.createStatement();
			// 3.Query / 스캐너
			Scanner sc = new Scanner(System.in);
			System.out.println("[EMPNO 입력: ]");
			int no = sc.nextInt(); // 7902

			String query = "select * from emp where empno=" + no;
			// 4.실행과 리턴
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				System.out.println(empno + " : " + ename + " : " + job + " : " + hiredate + " : " + sal + " : " + comm
						+ " : " + deptno + " : ");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상종료");

		// 5. DB종료
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {

		}

	}

}
