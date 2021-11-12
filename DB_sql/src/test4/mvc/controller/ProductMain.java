package test4.mvc.controller;

import java.util.Scanner;
import java.util.Vector;

import test4.mvc.dto.Product;
import test4.mvc.service.Service;
import test4.mvc.service.ServiceImpl;

// 결과
public class ProductMain {

	public static void main(String[] args) {

		Service service = new ServiceImpl();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int menu;
		Product p = null;
		Vector<Product> v = null;
		
		while (flag) {
			System.out.println("1.제품등록 2.제품검색 3.전체검색 4.수정 5.삭제 6.종료");

			menu = sc.nextInt();
			switch (menu) {
			case 1:
				// 1.insert
				service.addProduct();
				break;

			case 2:
				// 2. select one
				p = service.getProduct();
				System.out.println(p);
				break;

			case 3:
				// 3. select all
				service.getProducts();
				v = service.getProducts();
				for (int i = 0; i < v.size(); i++) {
					System.out.println(v.get(i));
				}
				break;

			case 4:
				// 4. update
				service.editProduct();
				break;

			case 5:
				// 5. delete
				service.delProduct();
				break;
			case 6:
				flag = false;
				System.out.println("종료.");
				break;
			default:
				System.out.println("다시 입력하세요.");
			}

		}
		sc.close();
	}

}
