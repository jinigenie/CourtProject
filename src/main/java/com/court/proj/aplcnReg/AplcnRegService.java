package com.court.proj.aplcnReg;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.user.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface AplcnRegService {

    // 기본정보 불러오기
    public UserVO getInfo(String userId);
    // 법원 조회하기
    public ArrayList<CourtVO> getCourt();
    // 재판조력자 유형 조회하기
    public ArrayList<TrialVO> getTrial();
    // 모집중 공고 불러오기
    public ArrayList<AnnounceVO> getAnnounce(String date);
    // 선택된 재판조력자 데이터 불러오기
    public TrialVO getTrialVO(int trial_pn);


//    void setCerti(CertiVO vo);
//    public ArrayList<CertiVO> getCerti(@Param("vo") CertiVO vo);


}
