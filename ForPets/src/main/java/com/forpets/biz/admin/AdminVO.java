package com.forpets.biz.admin;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *  관리자모듈입니다.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AdminVO {
	private String adm_id; //관리자ID
	private String adm_pw; //관리자PW
	private String adm_name; //관리자이름
	private String adm_phone; //관리자 핸드폰번호
	private String adm_email; //관리자 이메일
	private int adm_no;	//관리자 번호
	private Date adm_date; //등록날짜
	
	private int earnings; //총수익
	private int user_count; // 유저수
	private String year_month; // 예약년-월
	private int montly_reserve; // 월별 예약수
	private int service_count; // 서비스별 예약현황
	private int s_num;
	
}
