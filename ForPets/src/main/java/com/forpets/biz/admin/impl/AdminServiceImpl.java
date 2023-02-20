package com.forpets.biz.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forpets.biz.admin.AdminService;
import com.forpets.biz.admin.AdminVO;
import com.forpets.biz.partner.PartnerVO;
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
}
