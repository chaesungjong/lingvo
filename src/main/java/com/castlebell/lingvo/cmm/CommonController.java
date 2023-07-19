package com.castlebell.lingvo.cmm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.castlebell.lingvo.domain.dao.mmb.Member;

@Controller
public class CommonController {
    

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String main() {
	    return "mmb/login";
	}
	/**
	 * 로그인 상태 체크
	 */   
	protected boolean checkLogin( HttpSession session , Model model ) {
		
		Member member = (Member) session.getAttribute("member");

		if(member == null){
			model.addAttribute("errMsg", "잘못 된 접근 입니다.");
			return false;
		}
		
	    return true;
	}
}

