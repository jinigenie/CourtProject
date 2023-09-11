package com.court.proj.aplcnReg;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("aplcnRegService")
public class AplcnRegServiceImpl implements AplcnRegService{

    @Autowired
    AplcnRegMapper aplcnRegMapper;

    @Override   // 기본정보 불러오기
    public UserVO getInfo(String userId) {
        return aplcnRegMapper.getInfo(userId);
    }

    @Override   // 법원 조회하기
    public ArrayList<CourtVO> getCourt() {
        return aplcnRegMapper.getCourt();
    }

    @Override   // 재판조력자 유형 조회하기
    public ArrayList<TrialVO> getTrial() {
        return aplcnRegMapper.getTrial();
    }

    @Override   // 모집중 공고 불러오기
    public ArrayList<AnnounceVO> getAnnounce(String date) {
        return aplcnRegMapper.getAnnounce(date);
    }

    @Override   // 선택된 재판조력자 데이터 불러오기
    public TrialVO getTrialVO(int trial_pn) {
        return aplcnRegMapper.getTrialVO(trial_pn);
    }

//    @Override
//    public void setCerti(CertiVO vo) {
//        aplcnRegMapper.setCerti(vo);
//    }
//    @Override
//    public ArrayList<CertiVO> getCerti(CertiVO vo) {
//        return aplcnRegMapper.getCerti(vo);
//    }
}
