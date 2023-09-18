package com.court.proj.fcltt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FclttRestController {

    @Autowired
    private FclttService fclttService;

    // 등재명단 ajax 목록
    @GetMapping("/fclttListAjax")
    public ResponseEntity<ArrayList<FclttVO>> fclttListAjax(FclttCriteria cri) {
        ArrayList<FclttVO> list = fclttService.getList(cri);
        int total = fclttService.getTotal(cri);
        FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
        for (FclttVO fclttVO : list) {
            fclttVO.setFclttPageVO(FclttPageVO);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 등재명단 상세보기 ajax
    @PostMapping("/getfclttModal")
    public ResponseEntity<Map<String, Object>> getfclttModal(
            @RequestParam("accept_proper_num") String accept_proper_num,
            @RequestParam("user_proper_num") String user_proper_num) {
        Map<String, Object> map = new HashMap<>();
        map.put("content1", fclttService.getFclttContent1(accept_proper_num));
        map.put("content2", fclttService.getFclttContent2(user_proper_num));
        map.put("content3", fclttService.getFclttContent3(user_proper_num));
        map.put("content4", fclttService.getFclttContent4(user_proper_num));
        map.put("content5", fclttService.getFclttContent5(user_proper_num));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    // Pause
    // -------------------------------------------------------------------------------------------
    // 중지, 활동신청 목록 불러오기 ajax
    @GetMapping("/pauseAjax")
    public ResponseEntity<ArrayList<PauseVO>> pauseList(FclttCriteria cri) {
        ArrayList<PauseVO> list = fclttService.getPauseList(cri);
        int total = fclttService.getPauseTotal(cri);
        FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
        for (PauseVO PauseVO : list) {
            PauseVO.setFclttPageVO(FclttPageVO);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 승인처리 ajax 컨트롤러
    @PostMapping("/pauseResultSubmit")
    public ResponseEntity<Integer> pauseResultSubmit(@RequestParam("accept_proper_num") String accept_proper_num,
    											 	 @RequestParam("accept_act_yn") String accept_act_yn) {
        FclttVO vo = new FclttVO();
        vo.setAccept_proper_num(accept_proper_num);
        vo.setAccept_act_yn(accept_act_yn);
        int result = accept_act_yn.equals("Y") ? fclttService.setPauseY(vo) : fclttService.setPauseN(vo);
        System.out.println("결과: " + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}