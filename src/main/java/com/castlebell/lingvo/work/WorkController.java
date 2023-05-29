package com.castlebell.lingvo.work;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("work")
public class WorkController {
       
    @RequestMapping(value = "/main", method=RequestMethod.GET)
	public String main() {
	    return "work/main";
	}

	@RequestMapping(value = "/*", method=RequestMethod.GET)
	public String design(HttpServletRequest httpRequest) {
		String url = httpRequest.getRequestURI().toString().replace("http://localhost:8080/","");
		url = url.replace("http://ngd2023.cafe24.com/","");
		url = url.replace("/work/", "");
		url = url.replace("/", "");
	    return "work/"+url;
	}

}

