package com.court.proj.aplcnReg;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface AplcnRegService {

    void setCerti(CertiVO vo);

    public ArrayList<CertiVO> getCerti(@Param("vo") CertiVO vo);


}
