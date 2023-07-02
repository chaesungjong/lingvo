package com.castlebell.lingvo.risk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 비상연락망 컨트롤러
 */
@Controller
@RequestMapping("riskcontent")
public class RiskContentController {

    @RequestMapping(value = "/riskcontentMain", method=RequestMethod.GET)
	public String riskContentMain() {
	    return "riskcontent/riskcontentMain";
	}
    
}
