package com.castlebell.lingvo.work.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.domain.Member;
import com.castlebell.lingvo.domain.dao.work.WorkSafetyCheck;
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;
import com.castlebell.lingvo.work.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("work")
public class WorkController extends CommonController{
	
	private static final Logger logger = LoggerFactory.getLogger(WorkController.class);
	private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    /**
	 * 작업자 메인
	 * @return
	 */   
    @RequestMapping(value = "/main", method=RequestMethod.GET)
	public String main(HttpServletRequest request, Model model ,HttpSession session) {

		Member member = (Member) session.getAttribute("member");

		if(member == null){
			model.addAttribute("errMsg", "잘못 된 접근 입니다.");
			return "mmb/login";
		}

		logger.debug("main 진입 : " + member.toString());
		model.addAttribute("name", member.getName() + " 님 환영합니다.");

	    return "work/main";
	}

	/**
	 * QRCode 인식 하여 현장 정보 가져오기 
	 * @return
	 */   
    @RequestMapping(value = "/workQRConfirm", method=RequestMethod.GET)
	public String workQRConfirm(HttpServletRequest request, Model model ,HttpSession session) {

		logger.debug("workQRConfirm 진입");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		WorkSafetyCheck result = workService.getSiteInfo(session, request);

		// 프로시저 호출 에러 시 메인으로 이동
		if(!"0".equals(result.getErrCode())){
			model.addAttribute("errMsg", result.getErrMsg());
			return "redirect:/work/main";
		}

		model.addAttribute("siteAddress", result.getSiteAddress());	//위치
		model.addAttribute("siteName", result.getSiteName());			//현장	
		model.addAttribute("constName", result.getConstName());	 	//시공사
		model.addAttribute("companyName", result.getCompanyName());	//시공사
		model.addAttribute("workType", result.getWorkType());			//작업구분
		session.setAttribute("WorkSafetyCheck", result);						//작업정보 세션 저장

	    return "work/workQRConfirm";
	}


	/**
	 * 안전점검 단계별 매뉴얼노출
	 * @return
	 */   
    @RequestMapping(value = "/workCheckStep", method=RequestMethod.GET)
	public String workCheckStep(HttpServletRequest request, Model model ,HttpSession session) {

		logger.debug("workCheckStep 진입 ");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		WorkClassMsgListRequest workClassMsgListRequest = new WorkClassMsgListRequest();
		workClassMsgListRequest.setWorkGubun(request.getParameter("workGubun"));
		workClassMsgListRequest.setWorkType(request.getParameter("workType"));

		List<WorkClassMsgListResponse> workClassMsgList = workService.getWorkClassMsgList(workClassMsgListRequest);
		List<String> message = new ArrayList<>();

		for(int i = 0; i < workClassMsgList.size(); i++){
			message.add(workClassMsgList.get(i).getMessage());
		}

		model.addAttribute("message", message);			//작업 메세지
	    return "work/workCheckStep";
	}

	/**
	 * 안전점검 매뉴얼 완료/결과전송확인
	 * @return
	 */   
    @RequestMapping(value = "/workCheckStepConfirm", method=RequestMethod.GET)
	public String workCheckStepConfirm(HttpServletRequest request, Model model ,HttpSession session) {

		logger.debug("workCheckStepConfirm 진입 ");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		String workGubun = StringUtil.objectToString(request.getParameter("workGubun"));
		// 안전점검 매뉴얼 완료/결과전송확인
		WorkSafetyCheck result = workService.checkSurvey(session, request,"SURVEY_END",workGubun);

		if(result.getErrCode() != null && !"0".equals(result.getErrCode())){
			model.addAttribute("errMsg", result.getErrMsg());
			return "redirect:/work/main";
		}

	    return "work/workCheckStepConfirm";
	}

	/**
	 * 작업시작 ARS 인증 요청
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "workStartARSCall", method=RequestMethod.GET)
    public ResponseEntity<Object> workStartARSCall(HttpServletRequest request, HttpSession session) {

		logger.debug("workStartARSCall 진입 ");
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("errMsg", "ARS 인증 요청을 실패 하였습니다.");

		if(!checkLogin(session)){ return new ResponseEntity<>(responseMap, HttpStatus.OK); }

		WorkSafetyCheck result = workService.checkSurvey(session, request,"AICALL_START","N");

		if(result.getErrCode() != null && !"0".equals(result.getErrCode())){
			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		}
		
		responseMap.put("errCode", result.getErrCode());
		responseMap.put("errMsg", result.getErrMsg());

        // ResponseEntity를 사용하여 JSON 응답을 반환합니다.
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

	/**
	 * ARS 인증 결과 
	 * @return
	 */   
    @RequestMapping(value = "/resultWorkARSCall", method=RequestMethod.GET)
	public String resultWorkARSCall(HttpServletRequest request, HttpSession session, Model model) {

		logger.debug("resultWorkARSCall 진입 ");
		String returnURL =  "redirect:/work/main";
		if(!checkLogin(session, model)){
			return returnURL;
		}

		String gubun = request.getParameter("gubun");
		String workGubun = request.getParameter("workGubun");
		
		WorkSafetyCheck result = workService.checkSurvey(session, request,gubun,workGubun);

		if(result.getErrCode() != null && !"0".equals(result.getErrCode())){
			return returnURL;
		}
		
		model.addAttribute("errCode", result.getErrCode());
		model.addAttribute("errMsg", result.getErrMsg());

	    return returnURL;
	}



	/**
	 * 작업선택
	 * @return
	 */   
    @RequestMapping(value = "/workChoice", method=RequestMethod.GET)
	public String workChoice() {
	    return "work/workChoice";
	}


	/**
	 * 나의 지난작업
	 * @return
	 */   
    @RequestMapping(value = "/workedList", method=RequestMethod.GET)
	public String workedList(HttpServletRequest request, Model model ,HttpSession session) {

		if(!checkLogin(session, model)){
			return "redirect:/mmb/login";
		}

		Member member = (Member) session.getAttribute("member");
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");

		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장	
		model.addAttribute("constName", workSafetyCheck.getConstName());	 		//시공사
		model.addAttribute("companyName", workSafetyCheck.getCompanyName());		//시공사
		model.addAttribute("workType", workSafetyCheck.getWorkType());			//작업구분

	    return "work/workedList";
	}

	/**
	 * 위험신고리스트
	 * @return
	 */   
    @RequestMapping(value = "/requestStopWorkList", method=RequestMethod.GET)
	public String requestStopWorkList(HttpServletRequest request, Model model ,HttpSession session) {
		logger.debug("requestStopWorkList 진입 ");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }
		
	    return "work/requestStopWorkList";
	}

	/**
	 * 작업장 시설물 및 환경적 문제
	 * @return
	 */   
    @RequestMapping(value = "/environmentalissues", method=RequestMethod.GET)
	public String environmentalissues(HttpServletRequest request, Model model ,HttpSession session) {

		
		logger.debug("environmentalissues 진입 ");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		String issueGubun  = StringUtil.objectToString(request.getParameter("issueGubun"));
		String etcParam1   = StringUtil.objectToString(request.getParameter("etcParam1"));

		HashMap<String, String> map = new HashMap<>();
		map.get(map.put("issueGubun", issueGubun));
		map.get(map.put("etcParam1", etcParam1));

		List<workIssueMsgListResponse> result = workService.workIssueMsgList(map);

		if(result != null || !result.isEmpty()) model.addAttribute("result", result);			//작업중지 상황별 메시지 리스트

	    return "work/environmentalissues";
	}

	/**
	 * 작업 중지 요청 사진 첨부 상세 내용
	 * @return
	 */   
    @RequestMapping(value = "/requestPicturePlusDitail", method=RequestMethod.GET)
	public String requestPicturePlusDitail(HttpServletRequest request, Model model ,HttpSession session) {

		logger.debug("requestPicturePlusDitail 진입 ");
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		Member member = (Member) session.getAttribute("member");
		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		if(workSafetyCheck == null){
			model.addAttribute("errMsg", "잘못 된 접근 입니다.");
			return "redirect:/work/main";
		}

		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장
		model.addAttribute("location", workSafetyCheck.getSiteAddress());			//위치
		
	    return "work/requestPicturePlusDitail";
	}


	/**
	 * 작업 중지 요청 사진 올리기 화면 
	 * @return
	 */   
    @RequestMapping(value = "/requestPicture", method=RequestMethod.GET)
	public String requestPicture() {
	    return "work/requestPicture";
	}

	
	/**
	 * 작업 중지 요청 사진 첨부 
	 * @return
	 */   
    @RequestMapping(value = "/requestPicturePlus", method=RequestMethod.GET)
	public String requestPicturePlus() {
	    return "work/requestPicturePlus";
	}
	/**
	 * 작업 중지 요청 완료
	 * @return
	 */   
    @RequestMapping(value = "/requestPictureComfirm", method=RequestMethod.GET)
	public String requestPictureComfirm() {
	    return "work/requestPictureComfirm";
	}

	/**
	 * 작업 후기
	 * @return
	 */   
    @RequestMapping(value = "/workReview", method=RequestMethod.GET)
	public String workReview(HttpServletRequest request, Model model ,HttpSession session) {

		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		Member member = (Member) session.getAttribute("member");
		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		if(workSafetyCheck == null){
			model.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
			return "redirect:/work/main";
		}

	    return "work/workReview";
	}

	/**
	 * 작업 후기 체크
	 * @return
	 */   
    @RequestMapping(value = "/checkWorkReview", method=RequestMethod.GET)
	public String checkWorkReview(HttpServletRequest request, Model model ,HttpSession session) {

		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		Member member = (Member) session.getAttribute("member");
		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		if(workSafetyCheck == null){
			model.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
			return "redirect:/work/main";
		}
	    return "work/checkWorkReview";
	}



	/**
	 * 작업 후기 완료
	 * @return
	 */   
    @RequestMapping(value = "/workReViewPictureComfirm", method=RequestMethod.GET)
	public String workReViewPictureComfirm() {
	    return "work/workReViewPictureComfirm";
	}

	/**
	 * 작업 완료
	 * @return
	 */   
    @RequestMapping(value = "/workReviewEnd", method=RequestMethod.GET)
	public String workReviewEnd() {
	    return "work/workReviewEnd";
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


	    return "work/workReviewissues";
	}


	/**
	 * 작업 후기 개선 사항 요청 
	 * @return
	 */   
    @RequestMapping(value = "/workImprovementReview", method=RequestMethod.GET)
	public String workImprovementReview(HttpServletRequest request, Model model ,HttpSession session) {

		logger.debug("workImprovementReview 진입 ");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		String issueGubun  = StringUtil.objectToString(request.getParameter("issueGubun"));
		String etcParam1   = StringUtil.objectToString(request.getParameter("etcParam1"));

		HashMap<String, String> map = new HashMap<>();
		map.get(map.put("issueGubun", issueGubun));
		map.get(map.put("etcParam1", etcParam1));

		List<workIssueMsgListResponse> result = workService.workIssueMsgList(map);

		if(result != null || !result.isEmpty()) model.addAttribute("result", result);			//작업중지 상황별 메시지 리스트
	    return "work/workImprovementReview";
	}
}

