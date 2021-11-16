package mms.memver.ui;

import java.util.Scanner;

import mms.memver.action.Action;
import mms.memver.action.MemberAddAction;
import mms.memver.controller.MemberController;

public class MemberUI {

	public static void main(String[] args) {

		boolean isStop = false;

		MemberController memberController = new MemberController();

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("==== 회원관리 프로그램 ====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램종료");
			System.out.println("메뉴번호 : ");
			int menu = sc.nextInt();
			Action action = null;
			
			switch(menu) {
			case 1:
				action = new MemberAddAction();
				break;
				
				
				
			default : 
				break;
			}
			if(action != null) {
				memberController.processRequest(action, sc);
				
			}


		} while (!isStop);

	}
}