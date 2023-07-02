package com.castlebell.lingvo.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
 * 고객센터
 */
@Controller
@RequestMapping("cs")
public class CustomerServiceCenterController {

    /**
     * 공지사항
     * @return
     */
    @RequestMapping(value = "/noticeBoard", method=RequestMethod.GET)
	public String noticeBoard() {
	    return "cs/noticeBoard";
	}

    /**
     * 공지사항 상세 내용
     * @return
     */
    @RequestMapping(value = "/noticeBoardDitail", method=RequestMethod.GET)
	public String noticeBoardDitail() {
	    return "cs/noticeBoardDitail";
	}

    /**
     * 비상연락망
     * @return
     */
    @RequestMapping(value = "/emrContact", method=RequestMethod.GET)
	public String emrContact() {
	    return "cs/emrContact";
	}
    
}
