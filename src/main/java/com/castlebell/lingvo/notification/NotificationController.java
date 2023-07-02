package com.castlebell.lingvo.notification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 공지사항 관련 컨트롤러
 */
@Controller
@RequestMapping("notification")
public class NotificationController {
       
    @RequestMapping(value = "/notificationMain", method=RequestMethod.GET)
	public String notificationMain() {
	    return "notification/notificationMain";
	}

	    @RequestMapping(value = "/notificationDetail", method=RequestMethod.GET)
	public String notificationDetail() {
	    return "notification/notificationDetail";
	}

}