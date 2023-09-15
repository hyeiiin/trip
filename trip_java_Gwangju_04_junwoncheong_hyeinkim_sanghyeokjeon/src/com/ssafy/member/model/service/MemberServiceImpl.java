package com.ssafy.member.model.service;

import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	// 싱글톤 패턴
	private static MemberService memberService = new MemberServiceImpl();

	private MemberServiceImpl() {
	}

	public static MemberService getmemberService() {
		return memberService;
	}
//	getMemberService
	
	@Override
	public void registerMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberDao().registerMember(memberDto);

	}

	@Override
	public MemberDto login(String userId, String userPass) {
		MemberDaoImpl.getMemberDao().login(userId, userPass);
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberDao().modifyMember(memberDto);

	}

	@Override
	public int deleteMember(String userId) {

		return MemberDaoImpl.getMemberDao().deleteMember(userId);

	}

}
