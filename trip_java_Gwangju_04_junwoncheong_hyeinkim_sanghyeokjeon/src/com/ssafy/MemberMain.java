package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDaoImpl;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

public class MemberMain {

	private BufferedReader in;

	public MemberMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 회원 메뉴 ----------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerMember();
					break;
				case 2:
					login();
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					deleteMember();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	MemberService memberService = MemberServiceImpl.getmemberService();

	private void registerMember() throws IOException {

		// 아이디 비밀번호 이름 가입일
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("아이디를 입력하세요");
		String userid = br.readLine();
		System.out.println("비밀번호를 입력하세요");
		String userpass = br.readLine();
		System.out.println("이름을 입력하세요");
		String username = br.readLine();

		MemberDto memeberDto = new MemberDto(userid, username, userpass);
		memberService.registerMember(memeberDto);
	}

	private void login() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("아이디를 입력하세요");
		String userid = br.readLine();
		System.out.println("비밀번호를 입력하세요");
		String userpass = br.readLine();

		memberService.login(userid, userpass);

	}

	private void modifyMember() throws IOException {
		MemberDto memberDto = new MemberDto();
		System.out.print("수정할  아이디: ");
		memberDto.setUserId(in.readLine());
		System.out.print("수정할 이름: ");
		memberDto.setUserName(in.readLine());
		System.out.print("수정할 비밀번호: ");
		memberDto.setUserPass(in.readLine());
		MemberServiceImpl.getmemberService().modifyMember(memberDto);
	}

	private void deleteMember() throws IOException {
		System.out.print("삭제할 아이디: ");
		String userid = in.readLine();

		int cnt = MemberServiceImpl.getmemberService().deleteMember(userid);
		if (cnt > 0)
			System.out.println("삭제되었습니다.");
		else
			System.out.println("맞는 아이디가 없습니다.");

	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
