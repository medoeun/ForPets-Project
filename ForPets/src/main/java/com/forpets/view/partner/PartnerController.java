package com.forpets.view.partner;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forpets.biz.partner.PartnerService;
import com.forpets.biz.partner.PartnerVO;
import com.forpets.biz.partner.impl.PartnerDAO;
import com.forpets.biz.reserve.ReServeVO;
import com.forpets.biz.reserve.ReserveService;
import com.forpets.biz.reserve.impl.ReserveDAO;
import com.forpets.biz.reserve.impl.ReserveServiceImpl;


@Controller
public class PartnerController {
	
	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping(value="/partner/partnerMain")
	public String partner(PartnerVO vo, PartnerDAO dao) {
		return "/partner/partnerMain";
	}
	
	@RequestMapping(value="getPartnerList")
	public String getPartnerList(PartnerVO partvo, PartnerDAO partnerDAO, Model model) {
		System.out.println("---> getPartnerList.do 실행");
		model.addAttribute("getPartnerList", partnerService.getPartnerList(partvo));	// Model 정보 저장
		System.out.println("---> getPartnerList.do 완료");
		return "./Service/getPartnerList";
	}
	
	@RequestMapping(value="getPartner")
	@ResponseBody
	public void getPartner(PartnerVO vo, PartnerDAO partnerDAO, HttpSession session, HttpServletRequest request) {
		System.out.println("---> getPartner 실행");
		session.setAttribute("part_info", partnerService.getPartner(vo, request.getParameter("part_id")));
		System.out.println("---> getPartner 완료");
	}
	
	@RequestMapping(value="/partner/partnerGet")
	public String partnerGet(PartnerVO vo, PartnerDAO dao, HttpSession session) throws IOException{
		PartnerVO sessionVO = (PartnerVO) session.getAttribute("partners");
		vo.setPart_id(sessionVO.getPart_id());
		session.setAttribute("partners",partnerService.partnerGet(vo));
		return "/partner/partnerGet";
		
	}
	
	@RequestMapping(value="/partner/modifyyy", method = RequestMethod.GET)
	public String modifyView() {
		return "/partner/modify";
	}
	
	@RequestMapping(value="/partner/modifyyy", method = RequestMethod.POST)
	@ResponseBody
	public void updatePartner(PartnerVO vo, PartnerDAO dao, HttpServletRequest request) throws IOException{
		
			vo.setPart_pw(request.getParameter("part_pw"));
			vo.setPart_nick(request.getParameter("part_nick"));
			vo.setPart_add(request.getParameter("part_add"));
			vo.setPart_phnumber(request.getParameter("part_phnumber"));
			vo.setSelf_infor(request.getParameter("self_infor"));
			partnerService.updatePartner(vo);
			
			HttpSession session = request.getSession(false);
			
			//1.session이 있고 + 2.session정보가 있으면 
			if(session != null && session.getAttribute("partners") != null) { 
			//updateform에있는 정보를 받아와 수정한다.
				partnerService.updatePartner(vo);
				session.setAttribute("partners", partnerService.partnerGet(vo));
			}

		}
	
	@RequestMapping(value="/partner/login",method = RequestMethod.GET)
	public String loginForm() {
		return "partner/login";
	}

	@RequestMapping(value="/partner/login", method = RequestMethod.POST)
	public String login(PartnerVO vo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		System.out.println("아이디 : " + vo.getPart_id());
		
		if(partnerService.partnerGet(vo) != null) {
			session.setAttribute("role","partners" );
			session.setAttribute("partners", partnerService.partnerGet(vo));
			System.out.println(session.getAttribute("partners").toString());
			return "forward://";
		}else {
			return "/";
		}
		
	}	
	
	
}
