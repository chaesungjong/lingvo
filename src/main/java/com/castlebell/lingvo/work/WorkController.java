package com.castlebell.lingvo.work;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("work")
public class WorkController {

    /**
	 * 작업자 메인
	 * @return
	 */   
    @RequestMapping(value = "/main", method=RequestMethod.GET)
	public String main() {
	    return "work/main";
	}

	/**
	 * QR인식완료
	 * @return
	 */   
    @RequestMapping(value = "/workQRConfirm", method=RequestMethod.GET)
	public String workQRConfirm() {
	    return "work/workQRConfirm";
	}

	/**
	 * 안전점검 단계별 매뉴얼노출
	 * @return
	 */   
    @RequestMapping(value = "/workCheckStep", method=RequestMethod.GET)
	public String workCheckStep() {
	    return "work/workCheckStep";
	}

	/**
	 * 안전점검 매뉴얼 완료/결과전송확인
	 * @return
	 */   
    @RequestMapping(value = "/workCheckStepConfirm", method=RequestMethod.GET)
	public String workCheckStepConfirm() {
	    return "work/workCheckStepConfirm";
	}


	/**
	 * 작업선택
	 * @return
	 */   
    @RequestMapping(value = "/workChoice", method=RequestMethod.GET)
	public String workChoice() {
	    return "work/workChoice";
	}


	/**
	 * 나의 지난작업
	 * @return
	 */   
    @RequestMapping(value = "/workedList", method=RequestMethod.GET)
	public String workedList() {
	    return "work/workedList";
	}

	/**
	 * 위험신고리스트
	 * @return
	 */   
    @RequestMapping(value = "/requestStopWorkList", method=RequestMethod.GET)
	public String requestStopWorkList() {
	    return "work/requestStopWorkList";
	}

	/**
	 * 작업장 시설물 및 환경적 문제
	 * @return
	 */   
    @RequestMapping(value = "/environmentalissues", method=RequestMethod.GET)
	public String environmentalissues() {
	    return "work/environmentalissues";
	}

	/**
	 * 작업 중지 요청 사진 올리기 화면 
	 * @return
	 */   
    @RequestMapping(value = "/requestPicture", method=RequestMethod.GET)
	public String requestPicture() {
	    return "work/requestPicture";
	}

	
	/**
	 * 작업 중지 요청 사진 첨부 
	 * @return
	 */   
    @RequestMapping(value = "/requestPicturePlus", method=RequestMethod.GET)
	public String requestPicturePlus() {
	    return "work/requestPicturePlus";
	}

	/**
	 * 작업 중지 요청 사진 첨부 상세 내용
	 * @return
	 */   
    @RequestMapping(value = "/requestPicturePlusDitail", method=RequestMethod.GET)
	public String requestPicturePlusDitail() {
	    return "work/requestPicturePlusDitail";
	}

	/**
	 * 작업 중지 요청 완료
	 * @return
	 */   
    @RequestMapping(value = "/requestPictureComfirm", method=RequestMethod.GET)
	public String requestPictureComfirm() {
	    return "work/requestPictureComfirm";
	}

	/**
	 * 작업 후기
	 * @return
	 */   
    @RequestMapping(value = "/workReview", method=RequestMethod.GET)
	public String workReview() {
	    return "work/workReview";
	}

	/**
	 * 작업 후기 체크
	 * @return
	 */   
    @RequestMapping(value = "/checkWorkReview", method=RequestMethod.GET)
	public String checkWorkReview() {
	    return "work/checkWorkReview";
	}



	/**
	 * 작업 후기 완료
	 * @return
	 */   
    @RequestMapping(value = "/workReViewPictureComfirm", method=RequestMethod.GET)
	public String workReViewPictureComfirm() {
	    return "work/workReViewPictureComfirm";
	}

	/**
	 * 작업 완료
	 * @return
	 */   
    @RequestMapping(value = "/workReviewEnd", method=RequestMethod.GET)
	public String workReviewEnd() {
	    return "work/workReviewEnd";
	}

		/**
	 * 작업 후기 개선 사항 요청 
	 * @return
	 */   
    @RequestMapping(value = "/workReviewissues", method=RequestMethod.GET)
	public String workReviewissues() {
	    return "work/workReviewissues";
	}


	/**
	 * 작업 후기 개선 사항 요청 
	 * @return
	 */   
    @RequestMapping(value = "/workImprovementReview", method=RequestMethod.GET)
	public String workImprovementReview() {
	    return "work/workImprovementReview";
	}

	

}

