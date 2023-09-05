package com.court.proj.aplcnReg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/app")
public class AplcnRegController {

    @Autowired
    private AplcnRegService aplcnRegService;

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
    public String getEdu() {
        return "app/aplcnRegEducation";
    }

    //서류제출 페이지
    @GetMapping("/file")
    public String uploadFile() {
        return "app/aplcnFileUpload";
    }

    //신청완료 페이지
    @GetMapping("/submit")
    public String submit() {
        return "app/aplcnSubmission";
    }

    //자격증 데이터 내려받기
    @GetMapping("/api")
    public String test() {

        return "app/certi_api";
    }

    //자격증 조회
//    @GetMapping("/searchCer")
//    public String searchCer(CertiVO vo) {
//
//        ArrayList<CertiVO> list = aplcnRegService.getCerti(vo);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        return "/app/edu";
//
//    }

}
