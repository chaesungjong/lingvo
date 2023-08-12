package com.castlebell.lingvo.work.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * 작업 종료 컨트롤러
 * </pre>
 */
@Controller
@RequestMapping("work/worker/end")
public class EndWorkController extends CommonController{
    
    private static final Logger logger = LoggerFactory.getLogger(EndWorkController.class);
	private final WorkService workService;

    @Autowired
    public EndWorkController(WorkService workService) {
        this.workService = workService;
    }

    /**
	 * 작업 후기
	 * @return
	 */   
    @RequestMapping(value = "/workReview", method=RequestMethod.GET)
	public String workReview(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
			return "redirect:/work/worker/main";
		}

	    return "work/worker/end/workReview";
	}

    /**
	 * 작업 완료
	 * @return
	 */   
    @RequestMapping(value = "/workReviewEnd", method=RequestMethod.GET)
	public String workReviewEnd(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {

		if(!checkLogin(session, model)){ 
			return "/mmb/login"; 
		}

		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
			return "redirect:/work/worker/main";
		}

		session.setAttribute("WorkSafetyCheck", null);
	    return "work/worker/end/workReviewEnd";
	}

	/**
	 * 작업 후기 개선 사항 요청 
	 * @return
	 */   
    @RequestMapping(value = "/workImprovementReview", method=RequestMethod.GET)
	public String workImprovementReview(HttpServletRequest request, Model model ,HttpSession session , RedirectAttributes redirectAttributes) {

		logger.debug("workImprovementReview 진입 ");

		if(!checkLogin(session, model)){ return "/mmb/login"; }

		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
			return "redirect:/work/worker/main";
		}

	    return "work/worker/end/workImprovementReview";
	}

    /**
	 * 작업 후기 개선 사항 요청 
	 * @return
	 */   
    @RequestMapping(value = "/workReviewissues", method=RequestMethod.GET)
	public String workReviewissues(HttpServletRequest request, Model model ,HttpSession session) {

		logger.debug("workReviewissues 진입 ");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		String issueGubun  = StringUtil.objectToString(request.getParameter("issueGubun"));
		String etcParam1   = StringUtil.objectToString(request.getParameter("etcParam1"));

		HashMap<String, String> map = new HashMap<>();
		map.get(map.put("issueGubun", issueGubun));
		map.get(map.put("etcParam1", etcParam1));

		List<workIssueMsgListResponse> result = workService.workIssueMsgList(map);

		if(result != null || !result.isEmpty()) model.addAttribute("result", result);			//작업중지 상황별 메시지 리스트

	    return "work/worker/end/workReviewissues";
	}

	/**
	 * 작업 후기 개선 사항 요청 사진 첨부 
	 * @return
	 */   
    @RequestMapping(value = "/workReviewEndPicturePlus", method=RequestMethod.GET)
	public String workReviewEndPicturePlus(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
	    return "work/worker/end/workReviewEndPicturePlus";
	}

	/**
	 * 작업 후기 개선 사항 요청  사진 첨부 상세 내용
	 * @return
	 */   
    @RequestMapping(value = "/workReviewEndPlusDitail", method=RequestMethod.GET)
	public String workReviewEndPlusDitail(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {

		logger.debug("workReviewEndPlusDitail 진입 ");
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		Member member = (Member) session.getAttribute("member");
		if(!checkLogin(session, model)){ return "/mmb/login"; }

		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "잘못 된 접근 입니다.");
			return "redirect:/work/worker/main";
		}

		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장
		model.addAttribute("location", workSafetyCheck.getSiteAddress());			//위치
		
	    return "work/worker/end/workReviewEndPlusDitail";
	}

	/**
	 * 작업 후기 개선 사항 요청  사진 첨부 상세 내용
	 * @return
	 */   
    @RequestMapping(value = "/workReviewEndPicturePlusDitail", method=RequestMethod.GET)
	public String workReviewEndPicturePlusDitail(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {

		logger.debug("workReviewEndPicturePlusDitail 진입 ");
		if(!checkLogin(session, model)){ return "/mmb/login"; }
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		if(workSafetyCheck == null){
			redirectAttributes.addAttribute("errMsg", "잘못 된 접근 입니다.");
			return "redirect:/work/worker/main";
		}

		Member member = (Member) session.getAttribute("member");
		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장
		model.addAttribute("location", workSafetyCheck.getSiteAddress());			//위치
		
	    return "work/worker/end/workReviewEndPicturePlusDitail";
	}

	/**
	 * 작업 중지 요청 완료
	 * @return
	 */   
    @RequestMapping(value = "/sendWorkReview", method=RequestMethod.POST)
	public String sendWorkReview(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(!checkLogin(session, model)){ return "/mmb/login"; }

		logger.debug("sendworkReview 진입");

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
		
		model.addAttribute("endMessage", "감사합니다.<br> 개선 요청 사항이 등록되었습니다. <br>관리자께서 확인 후 <br>즉시 조치하도록 하겠습니다.");			

	    return "work/worker/end/sendWorkReview";
	}
}
