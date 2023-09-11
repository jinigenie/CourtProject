package com.court.proj.aplcnReg;

import com.court.proj.announce.AnnounceService;
import com.court.proj.announce.AnnounceVO;
import com.court.proj.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
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

    int trial_pn = 0;   //선택된 재판조력자 코드 넘기기위해
    int user_num = 0;   //현재 user_proper_num을 기억하기 위해
    int reg_num = 0; //aplcn_dtls_proper_num을 기억하기 위해

    //신청안내페이지
    @GetMapping("/start")
    public String getRegStart(Model model) {

        // 모집중인 공고 불러오기
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        System.out.println(sdf.format(now.getTime()));
        ArrayList<AnnounceVO> alist = aplcnRegService.getAnnounce(sdf.format(now.getTime()));

        model.addAttribute("alist", alist);
        return "app/aplcnRegStart";
    }

    //결격사유 확인 페이지
    @GetMapping("/confirm")
    public String confirm(@RequestParam("tfpn") int tfpn) {
        trial_pn = tfpn;
        return "app/aplcnRegConfirm";
    }

    //기본정보 입력페이지
    @GetMapping("/info")
    public String getInfo(Model model) {

        String id = "genie91";

        // 기본정보 불러와서 보내기
        UserVO uvo = aplcnRegService.getInfo(id);
        model.addAttribute("vo", uvo);
        user_num = uvo.getUser_proper_num();

        // 임시저장한것이 있으면 상세정보 불러와서 보내기
        int cnt = aplcnRegService.getDetailInfo(user_num);
        if (cnt == 1) {
            InfoVO ivo = aplcnRegService.getAllDetailInfo(user_num);
            model.addAttribute("ivo", ivo);
            trial_pn = ivo.getTrial_fcltt_proper_num();
        }

        // 공고에서 선택한 조력자 불러와서 보내기
        TrialVO tvo = aplcnRegService.getTrialVO(trial_pn);
        model.addAttribute("trial", tvo);

        // 법원목록 전체 보내기
        ArrayList<CourtVO> clist = aplcnRegService.getCourt();
        model.addAttribute("clist", clist);

        // 재판조력자 유형 전체 보내기
        ArrayList<TrialVO> tlist = aplcnRegService.getTrial();
        model.addAttribute("tlist", tlist);


        return "app/aplcnRegInfo";
    }

    //경력사항 입력페이지
    @GetMapping("/career")
    public String getCareer(Model model) {

        reg_num = 1;

        ArrayList<AddInfoVO> caList = aplcnRegService.getCareer(reg_num);
        AddInfoVO spvo = aplcnRegService.getSpecial(reg_num);

        if (caList.size() != 0) { // 경력내용 있으면 화면에 찍어주기
            for (AddInfoVO cavo : caList) {
                System.out.println(cavo.toString());
            }
            model.addAttribute("caList", caList);
        }

        if (spvo != null) {
            model.addAttribute("spvo", spvo);
            System.out.println(spvo.toString());
        }

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

    //regInfo 정보 저장하기
    @PostMapping("/saveInfoForm")
    public String saveInfo(@ModelAttribute UserVO uvo,
                           @ModelAttribute InfoVO ivo,
                           @RequestParam("x") int x) {

        ivo.setUser_proper_num(user_num);           // InfoVO에 현재 user 정보넣기
        // 선택한 재판조력자 pk 불러오기
        if (ivo.getSelectType3() == "") {
            ivo.setTrial_fcltt_proper_num(aplcnRegService.getTrialNum1(ivo.getSelectType1(), ivo.getSelectType2()));    // 선택 바꾸면 update 해줘야함
        } else {
            ivo.setTrial_fcltt_proper_num(aplcnRegService.getTrialNum2(ivo.getSelectType1(), ivo.getSelectType2(), ivo.getSelectType3()));    // 선택 바꾸면 update 해줘야함
        }

        System.out.println(ivo.toString());

        if (ivo.getSelectCourts().length > 1) {       // 선택한 법원 1, 2지망에 맞춰 저장
            ivo.setCourt_proper1(ivo.getSelectCourts()[0]);
            ivo.setCourt_proper2(ivo.getSelectCourts()[1]);
        } else {
            ivo.setCourt_proper1(ivo.getSelectCourts()[0]);
        }

        // 상세정보테이블에 해당 유저 정보가 있으면, 업데이트를 해야하고 아니면 insert
        // user 기본정보는 무조건 update
        int cnt = aplcnRegService.getDetailInfo(user_num);
        if (cnt == 0) {
            System.out.println("새로운 정보");
            System.out.println(ivo.toString());
            aplcnRegService.setDetailInfo(ivo);
        } else {
            System.out.println("이미 있는 정보 업뎃");
            System.out.println(ivo.toString());
            aplcnRegService.updateDetailInfo(ivo);

            ivo = aplcnRegService.getAllDetailInfo(user_num);
        }

        System.out.println(uvo.toString());
        System.out.println(ivo.toString());
        reg_num = ivo.getAplcn_dtls_proper_num();
        aplcnRegService.updateInfo(uvo);

        if (x == 1) {
            return "redirect:/app/confirm";  //requestParam 때문에 error
        } else {
            return "redirect:/app/career";
        }
    }


    //regCareer 정보 저장하기
    @PostMapping("/saveCareerForm")
    public String saveCareer(@ModelAttribute InfoVO ivo,
                             @RequestParam("x") int x) {

        int cnt = aplcnRegService.getCareerInfo(reg_num);
        // 경력 테이블에 임시저장한게 없으면 insert, 있으면 update
        if(cnt == 0) {

        } else {

        }

        if (x == 1) {
            return "redirect:/app/info";  //requestParam 때문에 error
        } else {
            return "redirect:/app/edu";
        }
    }

    //regEducation 정보 저장하기
    @PostMapping("/saveEduForm")
    public String saveEdu(@ModelAttribute InfoVO ivo,
                          @ModelAttribute UserVO uvo,
                          @RequestParam("x") int x) {

        if(x == 1) {
            return "redirect:/app/career";
        } else {
            return "redirect:/app/file";
        }
    }


    //////////////////////////////////////////////////////////////////////

    @GetMapping("/api")
    public String apiTest() {
        return "app/certi_api";
    }

}
