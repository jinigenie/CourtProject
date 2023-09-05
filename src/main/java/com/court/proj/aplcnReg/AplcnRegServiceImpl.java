package com.court.proj.aplcnReg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("AplcnRegService")
public class AplcnRegServiceImpl implements AplcnRegService{

    @Autowired
    AplcnRegMapper aplcnRegMapper;

    @Override
    public void setCerti(CertiVO vo) {
        aplcnRegMapper.setCerti(vo);
    }

    @Override
    public ArrayList<CertiVO> getCerti(CertiVO vo) {
        return aplcnRegMapper.getCerti(vo);
    }
}
