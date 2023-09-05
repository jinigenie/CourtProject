package com.court.proj.aplcnReg;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface AplcnRegMapper {
    void setCerti(CertiVO vo);

    public ArrayList<CertiVO> getCerti(@Param("vo") CertiVO vo);

}
