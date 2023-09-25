package com.court.proj.aplcnReg;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.user.CourtUserDetails;
import com.court.proj.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AplcnRegController {

    @Autowired
    @Qualifier("aplcnRegService")
    private AplcnRegService aplcnRegService;

    @Autowired
    private S3Service s3;

    int status = 0;
    int cnt = 0;
    String id = "";
    int trial_pn = 0;   //선택된 재판조력자 코드 넘기기위해
    int user_num = 0;   //현재 user_proper_num을 기억하기 위해
    int reg_num = 0; //aplcn_dtls_proper_num을 기억하기 위해
    ArrayList<Integer> careerPk = new ArrayList<Integer>(); //경력 PK 기억 : 업데이트용
    ArrayList<Integer> univPk = new ArrayList<Integer>();   //대학교 PK 기억 : 업데이트용
    ArrayList<Integer> certiPk = new ArrayList<Integer>();  //자격증 PK 기억 : 업데이트용

    //신청안내페이지
    @GetMapping("/start")
    public String getRegStart(@RequestParam("listNum") int listNum, Model model) {

        AnnounceVO anvo = aplcnRegService.getSelectedAnnounce(listNum);
        model.addAttribute("avo", anvo);
        trial_pn = anvo.getTrial_fcltt_proper_num();
        status = 1;

        // 모집중인 공고 불러오기
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar now = Calendar.getInstance();
//        System.out.println(sdf.format(now.getTime()));
//        ArrayList<AnnounceVO> alist = aplcnRegService.getAnnounce(sdf.format(now.getTime()));
//        model.addAttribute("alist", alist);

        return "app/aplcnRegStart";
    }

    //결격사유 확인 페이지
    @GetMapping("/confirm")
    public String confirm(RedirectAttributes ra, Authentication auth) {

        CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
        id = user.getUser_id();
        UserVO uvo = aplcnRegService.getInfo(id);
        user_num = uvo.getUser_proper_num();
        int cnt = aplcnRegService.getDetailInfo(user_num);

        if(status == 0) {
            ra.addFlashAttribute("msg", "공고 신청을 확인해 주세요");
            return "redirect:/announce/announceList";
        } else if(cnt == 1) {
            ra.addFlashAttribute("msg", "이전에 작성 중인 신청서로 넘어갑니다");
            return "redirect:/app/info";
        }

        return "app/aplcnRegConfirm";
    }

    //기본정보 입력페이지
    @GetMapping("/info")
    public String getInfo(Model model, RedirectAttributes ra, Authentication auth) {

        CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
        id = user.getUser_id();

        // 기본정보 불러와서 보내기
        UserVO uvo = aplcnRegService.getInfo(id);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        model.addAttribute("vo", uvo);
        user_num = uvo.getUser_proper_num();

        // 임시저장한것이 있으면 상세정보 불러와서 보내기
        cnt = aplcnRegService.getDetailInfo(user_num);
        if (cnt == 1) {
            InfoVO ivo = aplcnRegService.getAllDetailInfo(user_num);
            model.addAttribute("ivo", ivo);
            trial_pn = ivo.getTrial_fcltt_proper_num();
        } else if(status == 0 && cnt == 0) {
            ra.addFlashAttribute("msg", "공고 신청을 확인해 주세요");
            return "redirect:/announce/announceList";
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

        status = 2;

        return "app/aplcnRegInfo";
    }

    //경력사항 입력페이지
    @GetMapping("/career")
    public String getCareer(Model model,
                            RedirectAttributes ra) {

        if (status == 0 && cnt == 0) {
            ra.addFlashAttribute("msg", "저장된 신청 정보가 없습니다");
            return "redirect:/announce/announceList";
        } else if(status != 2) {
            ra.addFlashAttribute("msg", "기본 정보를 확인 후, 신청서를 저장하세요");
            return "redirect:/app/info";
        }

        reg_num = aplcnRegService.getRegnum(user_num);

        ArrayList<AddInfoVO> caList = aplcnRegService.getCareer(reg_num);
        AddInfoVO spvo = aplcnRegService.getSpecial(reg_num);

        careerPk.clear();
        model.addAttribute("caList", caList);
        for(AddInfoVO cvo : caList) {   //pk 따로 저장해두기
            careerPk.add(cvo.getAplcn_carer_proper_num());
        }

        if (spvo != null) { //특기사항 있으면 화면에 찍어주기
            model.addAttribute("spvo", spvo);
        }

        return "app/aplcnRegCareerAndCert";
    }

    //학력사항 입력페이지
    @GetMapping("/edu")
    public String getEdu(Model model,
                         RedirectAttributes ra) {

        UserVO uvo = aplcnRegService.getInfo(id);

        if (status == 0 && cnt == 0) {
            ra.addFlashAttribute("msg", "저장된 신청 정보가 없습니다");
            return "redirect:/announce/announceList";
        } else if(status != 2) {
            ra.addFlashAttribute("msg", "기본 정보를 확인 후, 신청서를 저장하세요");
            return "redirect:/app/info";
        }

        reg_num = aplcnRegService.getRegnum(user_num);
        model.addAttribute("vo", uvo);

        ArrayList<AddInfoVO> scList = aplcnRegService.getSchoolInfo(reg_num);
        AddInfoVO highInfo = null;
        ArrayList<AddInfoVO> univInfo = new ArrayList<>();
        if(scList.size() > 0){
            highInfo = scList.get(0);
            univInfo = new ArrayList<>();
            if(scList.size() > 1) {
                for(int i = 1; i < scList.size(); i++) {
                    univInfo.add(scList.get(i));
                }
            }
        }
        model.addAttribute("highInfo", highInfo);
        model.addAttribute("univInfo", univInfo);
        univPk.clear();
        for(AddInfoVO unvo : univInfo) {   //pk 따로 저장해두기
            univPk.add(unvo.getEdctn_dtls_proper_num());
        }

        certiPk.clear();
        ArrayList<AddInfoVO> ctList = aplcnRegService.getCertiInfo(reg_num);
        model.addAttribute("ctList", ctList);
        for(AddInfoVO ctvo : ctList) {
            certiPk.add(ctvo.getAplcn_crtfc_proper_num());
        }

        return "app/aplcnRegEducation";
    }

    //서류제출 페이지
    @GetMapping("/file")
    public String uploadFile(RedirectAttributes ra, Model model) {

        if (status == 0 && cnt == 0) {
            ra.addFlashAttribute("msg", "저장된 신청 정보가 없습니다");
            return "redirect:/announce/announceList";
        } else if(status != 2) {
            ra.addFlashAttribute("msg", "기본 정보를 확인 후, 신청서를 저장하세요");
            return "redirect:/app/info";
        }

        reg_num = aplcnRegService.getAdpnum(id);
        List<AddInfoVO> alist = aplcnRegService.getFileInfo(reg_num);
        List<String> caList = new ArrayList<>();
        List<String> eduList = new ArrayList<>();
        List<String> certiList = new ArrayList<>();
        String career = "";
        String edu = "";
        String certi = "";

        for (AddInfoVO aivo : alist){
            if(aivo.getFile_type().equals("BUSINESSLICENSE")){
                model.addAttribute("bizLi", aivo.getOriginal_file_name());
            } else if(aivo.getFile_type().equals("BUSINESSREPORT")) {
                model.addAttribute("bizRe", aivo.getOriginal_file_name());
            } else if(aivo.getFile_type().equals("TAXCONFIRM")) {
                model.addAttribute("tax", aivo.getOriginal_file_name());
            } else if(aivo.getFile_type().equals("RESUME")) {
                model.addAttribute("resume", aivo.getOriginal_file_name());
            } else if(aivo.getFile_type().equals("CARRER")) {
                caList.add(aivo.getOriginal_file_name());
            } else if(aivo.getFile_type().equals("EDUCATIONLEVEL")) {
                eduList.add(aivo.getOriginal_file_name());
            } else if(aivo.getFile_type().equals("CERTIFICATE")) {
                certiList.add(aivo.getOriginal_file_name());
            }
        }

        for(int i = 0; i < caList.size(); i++){
            if(i == caList.size() - 1) {
                career += caList.get(i);
            } else {
                career += caList.get(i) + ",";
            }
        }
        model.addAttribute("career", career);

        for(int i = 0; i < eduList.size(); i++){
            if(i == eduList.size() - 1) {
                edu += eduList.get(i);
            } else {
                edu += eduList.get(i) + ",";
            }
        }
        model.addAttribute("edu", edu);

        for(int i = 0; i < certiList.size(); i++){
            if(i == certiList.size() - 1) {
                certi += certiList.get(i);
            } else {
                certi += certiList.get(i) + ",";
            }
        }
        model.addAttribute("certi", certi);

        return "app/aplcnFileUpload";
    }

    //신청완료 페이지
    @GetMapping("/submit")
    public String submit() {
        aplcnRegService.updateSts(reg_num);
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
            aplcnRegService.setDetailInfo(ivo);
        } else {
            aplcnRegService.updateDetailInfo(ivo);

            ivo = aplcnRegService.getAllDetailInfo(user_num);
        }

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
    public String saveCareer(@RequestParam(value = "company_name[]", required = false) ArrayList<String> cn,
                             @RequestParam(value = "work_start_date[]", required = false) ArrayList<String> wsd,
                             @RequestParam(value = "work_end_date[]", required = false) ArrayList<String> wed,
                             @RequestParam(value = "work_description[]", required = false) ArrayList<String> wdc,
                             @RequestParam(value = "work_department[]", required = false) ArrayList<String> wdp,
                             @RequestParam(value = "work_position[]", required = false) ArrayList<String> wp,
                             @ModelAttribute AddInfoVO aivo,
                             @RequestParam("x") int x) {

        if(cn.size()>careerPk.size()){
            for(int i = careerPk.size(); i < cn.size(); i++) {
                careerPk.add(0);
            }
        }
        //경력테이블에 넣을 데이터 정리 : AddInfoVO 객체 리스트 생성
        List<AddInfoVO> aivoList = new ArrayList<>();
        for(int i = 0; i < cn.size(); i++) {
            AddInfoVO addInfoVO = new AddInfoVO();
            addInfoVO.setAplcn_carer_proper_num(careerPk.get(i));
            addInfoVO.setAplcn_dtls_proper_num(reg_num);
            addInfoVO.setCompany_name(cn.get(i));
            addInfoVO.setCarer_type(aivo.getCarer_typeList()[i]);
            addInfoVO.setWork_start_date(wsd.get(i));
            addInfoVO.setWork_end_date(wed.get(i));
            addInfoVO.setWork_description(wdc.get(i));
            addInfoVO.setWork_department(wdp.get(i));
            addInfoVO.setWork_position(wp.get(i));
            aivoList.add(addInfoVO);
        }

        int cntCareer = 0;

        // 경력 테이블에 있으면 업데이트, 없으면 insert
        for (AddInfoVO avo : aivoList) {
            cntCareer = aplcnRegService.getCareerInfo(avo.getAplcn_carer_proper_num());
            if(cntCareer == 1){
                aplcnRegService.updateCareer007(avo);
            }
            else {
                aplcnRegService.setCareer007(avo);
            }
        }

        aivo.setAplcn_dtls_proper_num(reg_num);
        // 특기사항 테이블에 임시저장한게 없으면 insert, 있으면 update
        int cntSpecial = aplcnRegService.getSpecialInfo(aivo.getAplcn_dtls_proper_num());
        if(cntSpecial == 0) {
            aplcnRegService.setCareer007_2(aivo);
        } else {
            aplcnRegService.updateCareer007_2(aivo);
        }

        if (x == 1) {
            return "redirect:/app/info";
        } else {
            return "redirect:/app/edu";
        }
    }

    //regEducation 정보 저장하기
    @PostMapping("/saveEduForm")
    public String saveEdu(@ModelAttribute AddInfoVO aivo,
                          @ModelAttribute UserVO uvo,
                          @RequestParam(value = "edctn_school_name[]", required = false) ArrayList<String> esn,
                          @RequestParam(value = "edctn_major[]", required = false) ArrayList<String> em,
                          @RequestParam(value = "edctn_degree[]", required = false) ArrayList<String> ed,
                          @RequestParam(value = "edctn_final[]", required = false) ArrayList<String> ef,
                          @RequestParam(value = "edctn_admsn_date[]", required = false) ArrayList<String> adate,
                          @RequestParam(value = "edctn_grdtn_date[]", required = false) ArrayList<String> gdate,
                          @RequestParam("x") int x) {

        uvo.setUser_proper_num(user_num);
        aplcnRegService.updateEdcFinal(uvo);

        aivo.setAplcn_dtls_proper_num(reg_num);
        //고등학교 정보 업뎃 or insert
        if(aplcnRegService.getHighCnt(reg_num) == 0) {
            aplcnRegService.setHighSchool(aivo);
        } else {
            aplcnRegService.updateHighSchool(aivo);
        }

        if(esn.size()>univPk.size()){       //새로 추가한 데이터는 대학pk 없어서 임의값 0으로 추가
            for(int i = univPk.size(); i < esn.size(); i++) {
                univPk.add(0);
            }
        }

        //학력테이블(대학만 포함)에 넣을 데이터 정리 : AddInfoVO 객체 리스트 생성
        List<AddInfoVO> aivoList = new ArrayList<>();
        for(int i = 0; i < esn.size(); i++) {
            AddInfoVO addInfoVO = new AddInfoVO();
            addInfoVO.setEdctn_dtls_proper_num(univPk.get(i));
            addInfoVO.setAplcn_dtls_proper_num(reg_num);
            addInfoVO.setEdctn_school_name(esn.get(i));
            addInfoVO.setEdctn_major(em.get(i));
            addInfoVO.setEdctn_degree(ed.get(i));
            addInfoVO.setEdctn_final(ef.get(i));
            addInfoVO.setEdctn_admsn_date(adate.get(i));
            addInfoVO.setEdctn_grdtn_date(gdate.get(i));
            aivoList.add(addInfoVO);
        }

        int cntUniv = 0;
        // 학력 테이블에 대학정보 있으면 업데이트, 없으면 insert
        for (AddInfoVO avo : aivoList) {
            cntUniv = aplcnRegService.getUnivInfo(avo.getEdctn_dtls_proper_num());
            if(cntUniv == 1){
                aplcnRegService.updateUniv(avo);
            }
            else {
                aplcnRegService.setUniv(avo);
            }
        }

        // form에서 넘어온 자격증 정보 각각 나누어 배열에 담기
        String[] cType = aivo.getCrtfc_type().split(",");
        String[] agency = aivo.getIssue_agency().split(",");
        String[] cNum = aivo.getCrtfc_number().split(",");
        String[] issue = aivo.getIssue_date().split(",");

        // 새로 추가한 자격증 정보에 임의 pk값 넣기
        if(cType.length > certiPk.size()){
            for(int i = certiPk.size(); i < cType.length; i++) {
                certiPk.add(0);
            }
        }

        //자격증테이블에 넣을 데이터 정리 : AddInfoVO 객체 리스트 생성
        List<AddInfoVO> certiList = new ArrayList<>();
        for(int i = 0; i < cType.length; i++) {
            AddInfoVO addInfoVO = new AddInfoVO();
            addInfoVO.setAplcn_crtfc_proper_num(certiPk.get(i));
            addInfoVO.setAplcn_dtls_proper_num(reg_num);
            addInfoVO.setCrtfc_type(cType[i]);
            addInfoVO.setIssue_agency(agency[i]);
            addInfoVO.setCrtfc_number(cNum[i]);
            addInfoVO.setIssue_date(issue[i]);
            certiList.add(addInfoVO);
        }

        int cntCerti = 0;
        // 자격증 테이블에 자격증정보 있으면 업데이트, 없으면 insert
        for (AddInfoVO avo : certiList) {
            cntCerti = aplcnRegService.getCerti(avo.getAplcn_crtfc_proper_num());
            if(cntCerti == 1){
                aplcnRegService.updateCerti(avo);
            }
            else {
                aplcnRegService.setCerti(avo);
            }
        }

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

    @GetMapping("/s3test")
    public String s3Test() {
        return "app/s3Test";
    }

    @GetMapping("S3Request")
    public String S3Request(){
        s3.getBucketList();
        return "redirect:/app/s3test";
    }

}
