package com.court.proj.aplcnReg;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AplcnRegMapper {
    void setCerti(CertiVO vo);
}
