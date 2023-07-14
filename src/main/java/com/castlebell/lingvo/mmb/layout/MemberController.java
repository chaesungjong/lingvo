package com.castlebell.lingvo.mmb.layout;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.castlebell.lingvo.mmb.service.MemberService;
import com.castlebell.lingvo.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 로그인 및 회원 가입 관련 컨트롤러
 */
@Controller
@RequestMapping("mmb")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

	/**
	 * 로그인 화면
	 * @return
	 */
    @RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loginLayout() {
		logger.info("loginPage 진입");
	    return "mmb/login";
	}

	/*
	 * 로그인 처리
	 */
	@RequestMapping(value="/loginProcess.do", method = {RequestMethod.POST})
	public String loginProcess(HttpServletRequest request, Map<String, Object> model,HttpSession session) {

		String userid     = request.getParameter("userid");		//아이디
		String pwd        = request.getParameter("pwd");			//비밀번호
		String userIP 	  = request.getRemoteAddr();				    //접속 IP
		String clientType = request.getHeader("User-Agent");	    //접속 브라우저
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		if(StringUtil.isNull(pwd) || StringUtil.isNull(userid)) {
			model.put("msg", "아이디 또는 비밀번호를 입력해주세요.");
			return "mmb/login";
		}
		logger.info("사용자 로그인 처리 userid : " + userid + " pwd : " + pwd + " userIP : " + userIP + " clientType : " + clientType);

		resultMap = memberService.loginProcess(userid,pwd,userIP,clientType,session);

		String retVal = StringUtil.objectToString(resultMap.get("retVal"));

		//로그인 실패
		if(!"0".equals(retVal)){
			model.put("errMsg", StringUtil.objectToString(resultMap.get("errMsg")));
			return "mmb/login";
		}

	    return "redirect:/work/main";
		
	}

}

