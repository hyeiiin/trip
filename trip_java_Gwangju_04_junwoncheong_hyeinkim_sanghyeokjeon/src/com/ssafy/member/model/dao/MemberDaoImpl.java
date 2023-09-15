package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao = new MemberDaoImpl();

	private MemberDaoImpl() {
	}

	public static MemberDao getMemberDao() {
		return memberDao;
	}

	DBUtil dbutil = DBUtil.getInstance();

	@Override
	public void registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbutil.getConnection();
			StringBuilder sql = new StringBuilder("insert into member (userId, userName, userPass,joinDate) \n");
			sql.append("values (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
			pstmt.setString(4, formatter.format(date));

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbutil.close(pstmt, conn);
		}

	}

	@Override
	public MemberDto login(String userId, String userPass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();

			StringBuilder sql = new StringBuilder("select userId,userPass \n");
			sql.append("from member \n");
			sql.append("where userId = ? and userPass = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);

			rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				cnt++;
			}
			if (cnt == 0) {
				System.out.println("회원가입이 필요합니다.");
			} else {
				System.out.println("로그인 성공!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("update member \n");
			sql.append("set userId = ?, userName = ?, userPass = ?, joinDate = ?");
			sql.append("");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
			pstmt.setString(4, memberDto.getJoinDate());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}

	@Override
	public int deleteMember(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("delete from member \n");
			sql.append("where userId = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}

		return cnt;
	}

}
