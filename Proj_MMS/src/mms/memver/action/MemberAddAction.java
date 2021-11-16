package mms.memver.action;
 //7-1 회원등록 요청 처리하는 Action 클래스 구현 (강제와 일반성 유지)
import java.util.Scanner;

import mms.memver.svc.MemberAddService;
import mms.memver.util.ConsoleUtil;
import mms.memver.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil cu = new ConsoleUtil();
		Member newMever = cu.getMember(sc); //회원등록 입력 완성 내용
		
		MemberAddService memberAddService  = new MemberAddService();
		boolean isAddSuccess = memberAddService.addMember(newMever);
		if(isAddSuccess) {
			cu.printAddSuccessMessage(newMever);
		} else {
			cu.printAddFailMessage(newMever);
		}
		
	}	

}
