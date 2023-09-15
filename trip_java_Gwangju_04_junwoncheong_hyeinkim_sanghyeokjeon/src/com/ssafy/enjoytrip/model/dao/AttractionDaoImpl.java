package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {

	private static AttractionDao attractionDao = new AttractionDaoImpl();
	
	private AttractionDaoImpl() {}
	
	public static AttractionDao getAttractionDao() {
		return attractionDao;
	}

	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		// TODO Auto-generated method stub
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();

			StringBuilder sql = new StringBuilder(
					"SELECT content_id, content_type_id, title, addr1, addr2, zipcode, tel, first_image, first_image2, readcount, sido_code, gugun_code, latitude, longitude, mlevel\n"
							+ "FROM  attraction_info \n");

			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AttractionInfoDto attractioninfodto = new AttractionInfoDto();
				attractioninfodto.setContentId(rs.getInt("content_id"));
				attractioninfodto.setContentId(rs.getInt("content_type_id"));
				attractioninfodto.setTitle(rs.getString("title"));
				attractioninfodto.setAddr1(rs.getString("addr1"));
				attractioninfodto.setAddr2(rs.getString("addr2"));
				attractioninfodto.setZipcode(rs.getString("zipcode"));
				attractioninfodto.setTel(rs.getString("tel"));
				attractioninfodto.setFirstImage(rs.getString("first_image"));
				attractioninfodto.setFirstImage2(rs.getString("first_image2"));
				attractioninfodto.setReadcount(rs.getInt("readcount"));
				attractioninfodto.setSidoCode(rs.getInt("sido_code"));
				attractioninfodto.setGugunCode(rs.getInt("gugun_code"));
				attractioninfodto.setLatitude(rs.getDouble("latitude"));
				attractioninfodto.setLongitude(rs.getDouble("longitude"));
				attractioninfodto.setMlevel(rs.getString("mlevel"));

				list.add(attractioninfodto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}

		return list;

	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {

		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select content_id, content_type_id, title, addr1, addr2, zipcode, tel, first_image, first_image2, readcount, sido_code, gugun_code, latitude, longitude, mlevel \n");
			sql.append("from attraction_info \n");
			sql.append("where title like ? \n");
			sql.append("and sido_code like ? \n");
//					"SELECT content_id, content_type_id, title, addr1, addr2, zipcode, tel, first_image, first_image2, readcount, sido_code, gugun_code, latitude, longitude, mlevel\n"
//							+ "FROM  attraction_info where title=? sido_code=?and \n");
//					sql.append("from board \n");
//					sql.append("order by ");
			//sql.append("from board \n");
//							sql.append("where subject like ? \n");
//							sql.append("order by article_no desc");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+title+"%");
			pstmt.setInt(2, sidoCode);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				AttractionInfoDto attractioninfodto = new AttractionInfoDto();
				attractioninfodto.setContentId(rs.getInt("content_id"));
				attractioninfodto.setContentId(rs.getInt("content_type_id"));
				attractioninfodto.setTitle(rs.getString("title"));
				attractioninfodto.setAddr1(rs.getString("addr1"));
				attractioninfodto.setAddr2(rs.getString("addr2"));
				attractioninfodto.setZipcode(rs.getString("zipcode"));
				attractioninfodto.setTel(rs.getString("tel"));
				attractioninfodto.setFirstImage(rs.getString("first_image"));
				attractioninfodto.setFirstImage2(rs.getString("first_image2"));
				attractioninfodto.setReadcount(rs.getInt("readcount"));
				attractioninfodto.setSidoCode(rs.getInt("sido_code"));
				attractioninfodto.setGugunCode(rs.getInt("gugun_code"));
				attractioninfodto.setLatitude(rs.getDouble("latitude"));
				attractioninfodto.setLongitude(rs.getDouble("longitude"));
				attractioninfodto.setMlevel(rs.getString("mlevel"));
				list.add(attractioninfodto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}

		return list;
	}

}
