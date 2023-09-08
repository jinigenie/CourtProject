package com.court.proj.aplcnReg;

import com.court.proj.user.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface AplcnRegService {

    public UserVO getInfo(String userId);
    public ArrayList<CourtVO> getCourt();
    public ArrayList<TrialVO> getTrial();


//    void setCerti(CertiVO vo);
//    public ArrayList<CertiVO> getCerti(@Param("vo") CertiVO vo);


}
