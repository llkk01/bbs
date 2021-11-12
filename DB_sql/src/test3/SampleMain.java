package test3;

import java.util.ArrayList;

public class SampleMain {

	public static void main(String[] args) {

		// 데이터베이스 액세스
		SampleDAO dao = new SampleDAO();

		ArrayList<SampleDTO> books = dao.findAll();

		//
		// for문 출력

		for (SampleDTO s : books) {
			System.out.println("id : " + s.getId());
			System.out.println("name : " + s.getName());
			System.out.println("price : " + s.getPrice());
		}

	}
}
