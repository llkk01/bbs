package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDAO {
	
	//DB내용을 찾아서 SampleDTO에 넣은 후 ArrayList
	public ArrayList<SampleDTO> findAll() {
		// DTO를 저장하는 리스트
	ArrayList<SampleDTO> sampleDTOs = new ArrayList<SampleDTO>();
		
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.Driver 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 2.계정연결
			conn = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = conn.createStatement();
			// 3.Query
			String query = "select * from book";
			// 4.실행과 리턴
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				SampleDTO dto = new SampleDTO();
				dto.setId( rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt("price"));
				
				sampleDTOs.add(dto);
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
		return sampleDTOs;
	}
}