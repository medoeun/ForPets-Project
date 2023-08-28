package com.forpets.biz.notice;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/*
 *  공지사항게시판모듈입니다.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class NoticeVO {
	private int ntc_seq; //번호
	private String ntc_title; //제목
	private String ntc_ctnt; //내용
	private String ntc_imgurl;	//img
	private Date ntc_cdate; //발행일
	private int ntc_hit; //조회수
	private Date ntc_udate; //수정일
	
	private String searchCondition;
	private String searchKeyword;
	
	private int nc_seq;
	private String nc_ctnt;
	private Integer nc_parent;  // nullable이므로 int 아닌 Integer 사용
	private String user_id;
	private Timestamp nc_cdate;
	
}
