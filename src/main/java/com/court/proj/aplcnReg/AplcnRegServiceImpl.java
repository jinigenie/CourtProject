package com.court.proj.aplcnReg;

import com.court.proj.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("AplcnRegService")
public class AplcnRegServiceImpl implements AplcnRegService{

    @Autowired
    AplcnRegMapper aplcnRegMapper;

    @Override
    public UserVO getInfo(String userId) {
        return aplcnRegMapper.getInfo(userId);
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
