package com.castlebell.lingvo.worker.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 로그인 및 회원 가입 관련 컨트롤러
 */
@Controller
@RequestMapping("auth")
public class AuthController {
       
    @RequestMapping(value = "/login", method=RequestMethod.GET)
	public String home() {
	    return "auth/login";
	}

}

