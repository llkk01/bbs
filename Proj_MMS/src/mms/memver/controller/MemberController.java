package mms.memver.controller;

import java.util.Scanner;
import mms.memver.action.Action;

//6. 사용자의 전체 요청을 제어하는 클래스 구현
public class MemberController {
	
	public void processRequest(Action action,Scanner sc){

		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}