package com.court.proj.aplcnReg;

import com.court.proj.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //결격사유 확인
    @GetMapping("/confirm")
    public String confirm() {
        return "app/aplcnRegConfirm";
    }

    //기본정보 입력페이지
    @GetMapping("/info")
    public String getInfo(Model model) {

        String id = "genie85";

        UserVO vo = aplcnRegService.getInfo(id);
        model.addAttribute("vo", vo);

        ArrayList<CourtVO> clist = aplcnRegService.getCourt();
        model.addAttribute("clist", clist);

        ArrayList<TrialVO> tlist = aplcnRegService.getTrial();
        model.addAttribute("tlist", tlist);

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

    //////////////////////////////////////////////////////////////////////

    @GetMapping("/api")
    public String apiTest() {
        return "app/certi_api";
    }

}
