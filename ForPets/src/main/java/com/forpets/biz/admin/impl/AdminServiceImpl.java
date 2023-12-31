package com.forpets.biz.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forpets.biz.admin.AdminService;
import com.forpets.biz.admin.AdminVO;
import com.forpets.biz.admin.SearchCriteria_user;
import com.forpets.biz.community.CommunityVO;
import com.forpets.biz.partner.PartnerVO;
import com.forpets.biz.reserve.ReServeVO;
import com.forpets.biz.tip.SearchCriteria;
import com.forpets.biz.tip.TipVO;
import com.forpets.biz.user.UserVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	
	@Override
	public AdminVO getAdmin(AdminVO vo) throws Exception {
		return adminDAO.getAdmin(vo);
	}

	@Override
	public void updateAdmin(AdminVO vo) {
		adminDAO.updateAdmin(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO uvo) {
		return adminDAO.getUserList(uvo);
	}

	@Override
	public List<PartnerVO> getPartList(PartnerVO pvo) {
		return adminDAO.getPartList(pvo);
	}

	@Override
	public List<TipVO> getTipPrev(TipVO tvo) {
		return adminDAO.getTipPrev(tvo);
	}

	@Override
	public void deleteUser(String user_id) {
		adminDAO.deleteUser(user_id);
	}

	@Override
	public Integer getEarnings() {
		return adminDAO.getEarnings();
	}

	@Override
	public List<AdminVO> getMontlyReserve(AdminVO avo) {
		return adminDAO.getMontlyReserve(avo);
	}

	@Override
	public Integer getUserCount() {
		return adminDAO.getUserCount();
	}

	@Override
	public Double getReviewAvg() {
		return adminDAO.getReviewAvg();
	}

	@Override
	public Integer getReserveCount() {
		return adminDAO.getReserveCount();
	}

	@Override
	public List<AdminVO> getServiceCount(AdminVO avo) {
		return adminDAO.getServiceCount(avo);
	}

	@Override
	public List<PartnerVO> getPartRank(PartnerVO pvo) {
		return adminDAO.getPartRank(pvo);
	}

	@Override
	public List<CommunityVO> getComPrev(CommunityVO cvo) {
		return adminDAO.getComPrev(cvo);
	}

	@Override
	public PartnerVO getPartInfo(PartnerVO pvo, String part_id) {
		return adminDAO.getPartInfo(pvo, part_id);
	}
	
	
	@Override
	public int getTotalPages(SearchCriteria_user cri) {
		return adminDAO.getTotalPages(cri);
	}
	
	@Override
	public List<UserVO> getListWithDynamicPaging(SearchCriteria_user cri) {
		return adminDAO.getListWithDynamicPaging(cri);
	}
	
	@Override
	public List<UserVO> getListWithPaging(SearchCriteria_user cri) {
		return adminDAO.getListWithDynamicPaging(cri);
	}

	@Override
	public UserVO getUserInfo(UserVO uvo, String user_id) {
		return adminDAO.getUserInfo(uvo, user_id);
	}
	
	
	
}
