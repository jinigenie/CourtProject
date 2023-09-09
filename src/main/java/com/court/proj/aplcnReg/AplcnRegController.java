package com.court.proj.aplcnReg;

import com.court.proj.announce.AnnounceService;
import com.court.proj.announce.AnnounceVO;
import com.court.proj.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/app")
public class AplcnRegController {

    @Autowired
    @Qualifier("aplcnRegService")
    private AplcnRegService aplcnRegService;

    int trial_pn = 0;

    //신청안내페이지
    @GetMapping("/start")
    public String getRegStart(Model model) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        System.out.println(sdf.format(now.getTime()));
        ArrayList<AnnounceVO> alist = aplcnRegService.getAnnounce(sdf.format(now.getTime()));

        model.addAttribute("alist", alist);
        return "app/aplcnRegStart";
    }

    //결격사유 확인
    @GetMapping("/confirm")
    public String confirm(@RequestParam("trial_fcltt_proper_num") int tfpn) {
        trial_pn = tfpn;
        return "app/aplcnRegConfirm";
    }

    //기본정보 입력페이지
    @GetMapping("/info")
    public String getInfo(Model model) {

        String id = "genie85";

        UserVO vo = aplcnRegService.getInfo(id);
        model.addAttribute("vo", vo);

        TrialVO tvo = aplcnRegService.getTrialVO(trial_pn);
        model.addAttribute("trial", tvo);

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
