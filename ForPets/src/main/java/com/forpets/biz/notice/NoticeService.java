package com.forpets.biz.notice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forpets.biz.community.CommunityVO;

/*
 *  공지사항관련 서비스는 여기서 추상메서드를 추가하세요.
 */
@Service
public interface NoticeService {

	//글 작성
	public void insertNotice(NoticeVO vo) throws Exception;
	
	//게시판 목록 보기
	public List<NoticeVO> getNoticeList(NoticeVO vo) throws Exception;

	//게시판 보기
	NoticeVO getNoticeBoard(NoticeVO vo, int ntc_seq) throws Exception;
	
}
