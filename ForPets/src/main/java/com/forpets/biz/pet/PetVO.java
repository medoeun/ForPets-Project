package com.forpets.biz.pet;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *  펫모듈입니다.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PetVO {
	private int id; //펫아이디
	private String name; //펫이름
	private String type; //펫타입
	private MultipartFile img; //펫이미지
	private int age; //펫나이
	private String wark; //산책경로
	private char gender; //성별
	private String user_id; //유저아이디
}
