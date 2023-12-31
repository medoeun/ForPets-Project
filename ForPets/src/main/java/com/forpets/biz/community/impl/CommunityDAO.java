package com.forpets.biz.community.impl;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.forpets.biz.community.CommunityVO;

@Repository("communityDAO")
public class CommunityDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String COMMUNITY_LIST = "select * from community order by C_DATE DESC ";
	private final String INSERT_COMMUNITY = "INSERT INTO COMMUNITY (C_CODE, C_TITLE, C_CONTENT, USER_ID, C_DATE, C_PET) VALUES(?, ?, ?, ?, sysdate, ?)";
	private final String GET_COMMUNITY = "select * from community where C_CODE=?";
	private final String ALL_NUMBER = "select count(*) from community";
	private final String UPDATE_COMMUNITY = "update community set C_TITLE=?, C_CONTENT=?, C_PET=? where C_CODE=?";
	private final String DELETE_COMMUNITY = "delete from community where C_CODE=? ";
	private final String DELETE_SURVEY = "delete FROM SURVEY WHERE s_code = (select c_code from community where c_code=?)";
	
	private final String GET_MYCOMMULIST="select * from community where user_id=? order by C_DATE desc";
	private final String GET_COMMULIST_INMYANSWER = "select *\r\n" + 
			"from community\r\n" + 
			"where c_code in (select distinct c_code\r\n" + 
			"from community\r\n" + 
			"join survey on community.c_code = survey.s_code\r\n" + 
			"join survey_answer on survey.S_SVCODE = survey_answer.sa_svcode\r\n" + 
			"where survey_answer.user_id =?) order by C_DATE desc";
	
	
	private final RowMapper<CommunityVO> communityRowMapper = (resultSet, rowNum) -> {
		CommunityVO vo = new CommunityVO();
		vo.setC_code(resultSet.getString("C_CODE"));
		vo.setC_title(resultSet.getString("C_TITLE"));
		vo.setC_content(resultSet.getString("C_CONTENT"));
		vo.setUser_id(resultSet.getString("USER_ID"));
		vo.setC_date(resultSet.getDate("C_DATE"));
		vo.setC_pet(resultSet.getString("C_PET"));
		
		return vo;
	};
	
	public List<CommunityVO> getCommunityList() {
		// System.out.println("안녕!");
		
		return jdbcTemplate.query(COMMUNITY_LIST, communityRowMapper);
	}
	
	public void insertCommunity(CommunityVO vo) {
		// System.out.println("인서트 보드");
		jdbcTemplate.update(INSERT_COMMUNITY,vo.getC_code(), vo.getC_title(), vo.getC_content(), vo.getUser_id(), vo.getC_pet());
	}
	
	
	public CommunityVO getCommunityBoard(String c_code) {
//		System.out.println("DAO 연결");
		CommunityVO vo = jdbcTemplate.queryForObject(GET_COMMUNITY,
			(resultSet, rowNum) -> {
				CommunityVO newvo = new CommunityVO();
				newvo.setC_code(resultSet.getString("C_CODE"));
				newvo.setC_title(resultSet.getString("C_TITLE"));
				newvo.setC_content(resultSet.getString("C_CONTENT"));
				newvo.setUser_id(resultSet.getString("USER_ID"));
				newvo.setC_date(resultSet.getDate("C_DATE"));
				newvo.setC_pet(resultSet.getString("C_PET"));
				return newvo;
			}
			, c_code);
		return vo;
	} 
	

	// 소모임 번호
	public String getlistcount() {
		String count = jdbcTemplate.queryForObject(ALL_NUMBER, String.class);
		return count;
	}
		
	
	public void updateCommunity(CommunityVO vo) {
		jdbcTemplate.update(UPDATE_COMMUNITY, vo.getC_title(), vo.getC_content(), vo.getC_pet(), vo.getC_code());
	}

	public void deleteCommunity(String c_code) {
		jdbcTemplate.update(DELETE_SURVEY, c_code);
		jdbcTemplate.update(DELETE_COMMUNITY, c_code);	
//		jdbcTemplate.update(DELETE_COMMUNITY,DELETE_SURVEY, c_code);

	}
	
	public List<CommunityVO> getListMyPost(String user_id) {
		Object[] obj = {user_id};
		return jdbcTemplate.query(GET_MYCOMMULIST, obj,communityRowMapper);
	}
	
	public List<CommunityVO> getPostInMyAnswer(String user_id) {
		Object[] obj = {user_id};
		return jdbcTemplate.query(GET_COMMULIST_INMYANSWER, obj,communityRowMapper);
	}
	
}
	
	
	
	
