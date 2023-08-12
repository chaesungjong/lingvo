package com.castlebell.lingvo.work.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @RequestMapping(value = "/worker/main", method=RequestMethod.GET)
	public String main(@ModelAttribute("errMsg") String errMsg, HttpServletRequest request, Model model ,HttpSession session) {

		//로그인 체크
		if(!checkLogin(session, model)){ return "/mmb/login"; }

		Member member = (Member) session.getAttribute("member");
		logger.debug("main 진입 : " + member.toString());

		model.addAttribute("name", member.getName() + " 님 환영합니다.");

		if(errMsg != null){
			model.addAttribute("errMsg", errMsg);
		}

	    return "work/worker/main";
	}

}

