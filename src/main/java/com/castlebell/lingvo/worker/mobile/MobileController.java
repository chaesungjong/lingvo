package com.castlebell.lingvo.worker.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mobile")
public class MobileController {
       
    @RequestMapping(value = "/main", method=RequestMethod.GET)
	public String home() {
	    return "mobile/main";
	}

}

