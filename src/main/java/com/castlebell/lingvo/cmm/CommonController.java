package com.castlebell.lingvo.cmm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
       
    @RequestMapping(value = "/", method=RequestMethod.GET)
	public String main() {
	    return "mmb/login";
	}
}

