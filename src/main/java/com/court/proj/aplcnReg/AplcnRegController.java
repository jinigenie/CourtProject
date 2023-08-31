package com.court.proj.aplcnReg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AplcnRegController {

    //신청안내페이지
    @GetMapping("/start")
    public String getRegStart() {
        return "app/aplcnRegStart";
    }

    //기본정보 입력페이지
    @GetMapping("/info")
    public String getInfo() {
        return "app/aplcnRegInfo";
    }

    //경력사항 입력페이지
    @GetMapping("/career")
    public String getCareer() {
        return "app/aplcnRegCareerAndCert";
    }

    //학력사항 입력페이지
    @GetMapping("/edu")
    public String teste() {
        return "app/aplcnRegEducation";
    }


}
