package com.castlebell.lingvo.mmb;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 로그인 및 회원 가입 관련 컨트롤러
 */
@Controller
@RequestMapping("mmb")
public class MemberController {



	/**
	 * 로그인 화면
	 * @return
	 */
    @RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
	    return "mmb/login";
	}

	/*
	 * 로그인 처리
	 */
	@RequestMapping(value="/loginProcess.do", method = {RequestMethod.POST})
	public String loginProcess(Map<String, Object> requestData) {

	    return "redirect:/work/main";
	}

}

