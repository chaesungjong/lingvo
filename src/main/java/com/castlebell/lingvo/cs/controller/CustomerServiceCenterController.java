package com.castlebell.lingvo.cs.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.castlebell.lingvo.cs.dao.domain.responese.EmergencyInfo;
import com.castlebell.lingvo.cs.service.CustomerServiceCenterService;
import com.castlebell.lingvo.domain.dao.work.WorkSafetyCheck;

/*
 * 고객센터
 */
@Controller
@RequestMapping("cs")
public class CustomerServiceCenterController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceCenterController.class);
    private final CustomerServiceCenterService customerServiceCenterService;

    
	@Autowired
    public CustomerServiceCenterController(CustomerServiceCenterService customerServiceCenterService) {
        this.customerServiceCenterService = customerServiceCenterService;
    }

    /**
     * 비상연락망
     * @return
     */
    @RequestMapping(value = "/emrContact", method=RequestMethod.GET)
	public String emrContact(HttpServletRequest request, 	Model model ,HttpSession session) {
        
        logger.debug("emrContact 진입");

        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");

        if(workSafetyCheck == null){
            return "redirect:/work/main";
        }

		List<EmergencyInfo> list = customerServiceCenterService.getEmergencyContactList(session,workSafetyCheck.getQrCode());
		model.addAttribute("list", list);
	    return "cs/emrContact";
	}
    
}
