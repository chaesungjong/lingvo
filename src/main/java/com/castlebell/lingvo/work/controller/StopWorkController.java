package com.castlebell.lingvo.work.controller;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;
import com.castlebell.lingvo.work.service.WorkService;

/**
 * @since 2023. 8. 12.
 * @version 1.0
 * <pre>
 * 작업 중단 컨트롤러
 * </pre>
 */
@Controller
@RequestMapping("work/worker/stop")
public class StopWorkController extends CommonController{
    
    private static final Logger logger = LoggerFactory.getLogger(StopWorkController.class);
	private final WorkService workService;

    @Autowired
    public StopWorkController(WorkService workService) {
        this.workService = workService;
    }

    /**
	 * 작업 중지 요청 
	 * @return
	 */   
    @RequestMapping(value = "/requestStopWorkList", method=RequestMethod.GET)
	public String requestStopWorkList(HttpServletRequest request, Model model ,HttpSession session ,RedirectAttributes redirectAttributes) {
		logger.debug("requestStopWorkList 진입 ");

		if(!checkLogin(session, model)){ return "/mmb/login"; }

		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "현재 작업중이지 않습니다.");
			return "redirect:/work/worker/main";
		}

		
	    return "work/worker/stop/requestStopWorkList";
	}

    /**
	 * 작업 중지 요청 사유 입력
	 * @return
	 */   
    @RequestMapping(value = "/stopMessageList", method=RequestMethod.GET)
	public String stopMessageList(HttpServletRequest request, Model model ,HttpSession session,RedirectAttributes redirectAttributes) {
		
		logger.debug("stopMessageList 진입 ");

		if(!checkLogin(session, model)){ return "/mmb/login"; }

		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "현재 작업중이지 않습니다.");
			return "redirect:/work/worker/main";
		}


		String issueGubun  = StringUtil.objectToString(request.getParameter("issueGubun"));
		String etcParam1   = StringUtil.objectToString(request.getParameter("etcParam1"));

		HashMap<String, String> map = new HashMap<>();
		map.get(map.put("issueGubun", issueGubun));
		map.get(map.put("etcParam1", etcParam1));
		//작업중지 상황별 메시지 리스트
		List<workIssueMsgListResponse> result = workService.workIssueMsgList(map);
		if(result != null || !result.isEmpty()) model.addAttribute("result", result);			

	    return "work/worker/stop/stopMessageList";
	}

	/**
	 * 작업 중지 요청 사진 첨부 
	 * @return
	 */   
    @RequestMapping(value = "/requestPicturePlus", method=RequestMethod.GET)
	public String requestPicturePlus(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
	    return "work/worker/stop/requestPicturePlus";
	}

	

	/**
	 * 작업 중지 요청 사진 첨부 상세 내용
	 * @return
	 */   
    @RequestMapping(value = "/requestPicturePlusDitail", method=RequestMethod.GET)
	public String requestPicturePlusDitail(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {

		logger.debug("requestPicturePlusDitail 진입 ");
		Member member = (Member) session.getAttribute("member");
		if(!checkLogin(session, model)){ return "/mmb/login"; }
		
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "현재 작업중이지 않습니다.");
			return "redirect:/work/worker/main";
		}

		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장
		model.addAttribute("location", workSafetyCheck.getSiteAddress());			//위치
		
	    return "work/worker/stop/requestPicturePlusDitail";
	}

	/**
	 * 작업 중지 요청 완료
	 * @return
	 */   
    @RequestMapping(value = "/requestPictureComfirm", method=RequestMethod.POST)
	public String requestPictureComfirm(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		logger.debug("requestPictureComfirm 진입");

		//작업 중지 요청 데이터 전달 목록
		// 회원 정보 : member
		// 작업 정보 : WorkSafetyCheck
		// 작접 중지 요청 원인 : issue
		// 작업 중지 요청 사진 : imageList
		// 작업 중지 요청 사유 : issueList
		//프로시저 없음.
		Member member = (Member) session.getAttribute("member");
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		String issue = StringUtil.objectToString(request.getParameter("issue"));
		String imageList = StringUtil.objectToString(request.getParameter("imageList"));
		String issueList = StringUtil.objectToString(request.getParameter("issueList"));

	    return "work/worker/stop/requestPictureComfirm";
	}

}
