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

    @Override
    public UserVO getInfo(String userId) {
        return aplcnRegMapper.getInfo(userId);
    }

    @Override
    public ArrayList<CourtVO> getCourt() {
        return aplcnRegMapper.getCourt();
    }

    @Override
    public ArrayList<TrialVO> getTrial() {
        return aplcnRegMapper.getTrial();
    }

    @Override
    public ArrayList<AnnounceVO> getAnnounce(String date) {
        return aplcnRegMapper.getAnnounce(date);
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
