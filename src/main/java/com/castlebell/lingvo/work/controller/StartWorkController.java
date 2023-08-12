package com.castlebell.lingvo.work.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;
import com.castlebell.lingvo.work.service.WorkService;

/**
 * @since 2023. 8. 12.
 * @version 1.0
 * <pre>
 * 작업 시작 컨트롤러
 * </pre>
 */
@Controller
@RequestMapping("work/worker/start")
public class StartWorkController extends CommonController{
    
    private static final Logger logger = LoggerFactory.getLogger(StartWorkController.class);
	private final WorkService workService;

    @Autowired
    public StartWorkController(WorkService workService) {
        this.workService = workService;
    }

    /**
     * 작업 시작(QR코드 인증)
     * @return
     */
    @RequestMapping(value = "/workQRConfirm", method=RequestMethod.GET)
	public String workQRConfirm(HttpServletRequest request, Model model ,HttpSession session,RedirectAttributes redirectAttributes) {

		logger.debug("workQRConfirm 진입");
		if(!checkLogin(session, model)){ return "/mmb/login"; }

        //작업정보 조회
		WorkSafetyCheck result = workService.getSiteInfo(session, request);

		// 프로시저 호출 에러 시 메인으로 이동
		if(!"0".equals(result.getErrCode())){
			redirectAttributes.addAttribute("errMsg", result.getErrMsg());
			return "redirect:/work/worker/main";
		}

		model.addAttribute("siteAddress", result.getSiteAddress());	//위치
		model.addAttribute("siteName", result.getSiteName());			//현장	
		model.addAttribute("constName", result.getConstName());	 	//시공사
		model.addAttribute("companyName", result.getCompanyName());	//시공사
		model.addAttribute("workType", result.getWorkType());			//작업구분
		session.setAttribute("WorkSafetyCheck", result);						//작업정보 세션 저장

	    return "work/worker/start/workQRConfirm";
	}

    /**
	 * 시작할 작업 선택
	 * @return
	 */   
    @RequestMapping(value = "/workedList", method=RequestMethod.GET)
	public String workedList(HttpServletRequest request, Model model ,HttpSession session) {

        logger.debug("workedList 진입");
		if(!checkLogin(session, model)){ return "/mmb/login"; }

		Member member = (Member) session.getAttribute("member");
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");

		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장	
		model.addAttribute("constName", workSafetyCheck.getConstName());	 		//시공사
		model.addAttribute("companyName", workSafetyCheck.getCompanyName());		//시공사
		model.addAttribute("workType", workSafetyCheck.getWorkType());			//작업구분

	    return "work/worker/start/workedList";
	}

    /**
	 * 안전 점검 단계별 매뉴얼 노출
	 * @return
	 */   
    @RequestMapping(value = "/workCheckStep", method=RequestMethod.GET)
	public String workCheckStep(HttpServletRequest request, Model model ,HttpSession session) {

		logger.debug("workCheckStep 진입 ");

		if(!checkLogin(session, model)){ return "/mmb/login"; }

		WorkClassMsgListRequest workClassMsgListRequest = new WorkClassMsgListRequest();
		workClassMsgListRequest.setWorkGubun(request.getParameter("workGubun"));
		workClassMsgListRequest.setWorkType(request.getParameter("workType"));

        //작업 메세지 조회
		List<WorkClassMsgListResponse> workClassMsgList = workService.getWorkClassMsgList(workClassMsgListRequest);
		List<String> message = new ArrayList<>();

		for(int i = 0; i < workClassMsgList.size(); i++){
			message.add(workClassMsgList.get(i).getMessage());
		}

		model.addAttribute("message", message);			
	    return "work/worker/start/workCheckStep";
	}
    
    /**
	 * 안전점검 매뉴얼 완료/결과전송확인
	 * @return
	 */   
    @RequestMapping(value = "/workCheckStepConfirm", method=RequestMethod.GET)
	public String workCheckStepConfirm(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {

		logger.debug("workCheckStepConfirm 진입 ");

		if(!checkLogin(session, model)){ return "redirect:/mmb/login"; }

		String workGubun = StringUtil.objectToString(request.getParameter("workGubun"));
		// 안전점검 매뉴얼 완료/결과전송확인
		WorkSafetyCheck result = workService.checkSurvey(session, request,"SURVEY_END",workGubun);

		if(result.getErrCode() != null && !"0".equals(result.getErrCode())){
			redirectAttributes.addAttribute("errMsg", result.getErrMsg());
			return "redirect:/work/worker/main";
		}

	    return "work/worker/start/workCheckStepConfirm";
	}

    /**
	 * 작업시작 ARS 인증 요청
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
		
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }


}
