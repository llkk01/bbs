package mms.memver.util;

// 사용자 입력, 출력
import java.util.ArrayList;
import java.util.Scanner;

import mms.memver.vo.Member;

// 키보드 입력
public class ConsoleUtil {
	
	
	public Member getMember(Scanner sc) {
		System.out.println("등록할 회원정보를 입력하세요 : ");
		
		System.out.println("이름 :");
		String name = sc.next();
		
		System.out.println("주소 :");
		String addr = sc.next();
		
		System.out.println("이메일 :");
		String email = sc.next();
		
		System.out.println("국가 : ");
		String nation = sc.next();
		
		System.out.println("나이 :");
		int age = sc.nextInt();
		
		return new Member(name,addr,email,nation,age);
	}

	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 성공");
	}
	
	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 실패");
	}

	public void printMemberList(ArrayList<Member> memberList) {
		//size() : 컬렉션에 저장되어 있는 요소의 개수를 리턴하는 메소드

	}

	public String getName(String msgKind, Scanner sc) {
	}

	public Member getUpdateMember(Scanner sc, Member oldMember) {		
	}

	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 성공.");	
	}
	
	public void printModifyFailMessage(Member updateMember) {	
		System.out.println(updateMember.getName() + " 회원 정보 수정 실패.");	
	}

	public void printRemoveSuccessMessage(String name) {	
		System.out.println(name + " 회원의 정보 삭제 성공.");
	}

	public void printRemoveFailMessage(String name) {	
		System.out.println(name + " 회원의 정보 삭제 실패.");
	}	

}
