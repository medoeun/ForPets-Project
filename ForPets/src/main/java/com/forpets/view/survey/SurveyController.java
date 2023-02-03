package com.forpets.view.survey;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.forpets.biz.survey.SurveyChoiceVO;
import com.forpets.biz.survey.SurveyDetailService;
import com.forpets.biz.survey.SurveyDetailVO;

@Controller
@RequestMapping("/")
public class SurveyController {
	
	@Autowired
	SurveyDetailService surdservice;
	

	// 설문지 열기
	@RequestMapping("/survey.do")
	public ModelAndView Survey() throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Survey");
		
		return mav;
	}

	// 설문지 등록
	@RequestMapping(value="/insertsurvey.do", method = RequestMethod.POST)
	public ModelAndView insertSurvey(@RequestParam String c_code, HttpServletRequest req) throws Exception {
		System.out.println("========= insertSurvey Controller Start ========= ");
		ModelAndView mav = new ModelAndView();
		
		String[] sd_title = req.getParameterValues("sd_title");
		String[] sd_type = req.getParameterValues("sd_type");
		
		String[] sc_answer = req.getParameterValues("sc_answer");
		String[] sc_ascode = req.getParameterValues("sc_ascode");
		
		
		
		System.out.println(c_code);
		SurveyDetailVO vo = new SurveyDetailVO();
		SurveyChoiceVO cvo = new SurveyChoiceVO();
		
		for(int i=0; i<sd_title.length; i++) {
			vo.setC_code(c_code);
			vo.setSd_title(sd_title[i]);
			vo.setSd_type(sd_type[i]);
			String od = "order"+(i+1);
			vo.setSd_order(od);
			System.out.println(vo);
			surdservice.insertSurvey(vo);
			
//			 for(int j=0; j<sc_answer.length; j++) {
//					cvo.setC_code(c_code);
//					cvo.setSc_order("od");
//					 String asc = sd_type[i].substring(0,1)+(j+1);
//					cvo.setSc_ascode("asc");
//					cvo.setSc_answer(sc_answer[j]);
//					surdservice.insertServey2(cvo);
//				}	// for end
				
		} // for end
		mav.setViewName("getSurvey");
		return mav;
	} // 설문지 등록 end
	
	
	// 설문지 리스트
	@RequestMapping("/surveylist.do")
	public ModelAndView SurveyList() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/SurveyList");
		mav.addObject("surveyList", surdservice.getSurveyList());
		return mav;
	} // 설문지 리스트 END
	

	// 설문지 불러오기
	@RequestMapping(value="/surveyboard.do/{c_code}", method=RequestMethod.GET)
	public ModelAndView getSurveyboard(@PathVariable String c_code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ViewSurvey");
		mav.addObject("surveyboard", surdservice.getSurveyBoard(c_code));
		return mav;
	}
	
		
		
		
	}
	
	

	

