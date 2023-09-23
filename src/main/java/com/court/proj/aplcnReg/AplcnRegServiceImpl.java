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

    @Override   // 선택된 공고 불러오기
    public AnnounceVO getSelectedAnnounce(int listNum) {
        return aplcnRegMapper.getSelectedAnnounce(listNum);
    }

    @Override   // 선택된 재판조력자 데이터 불러오기
    public TrialVO getTrialVO(int trial_pn) {
        return aplcnRegMapper.getTrialVO(trial_pn);
    }

    @Override   // 선택한 재판조력자 pk 불러오기
    public int getTrialNum1(String st1, String st2) {
        return aplcnRegMapper.getTrialNum1(st1, st2);
    };

    @Override   // 선택한 재판조력자 pk 불러오기
    public int getTrialNum2(String st1, String st2, String st3) {
        return aplcnRegMapper.getTrialNum2(st1, st2, st3);
    };

    @Override   // 상세정보 테이블에 유저 정보가 있는지 확인하기
    public int getDetailInfo(int user_num) {
        return aplcnRegMapper.getDetailInfo(user_num);
    }

    @Override
    public void setDetailInfo(InfoVO ivo) {
        aplcnRegMapper.setDetailInfo(ivo);
    }

    @Override
    public void updateDetailInfo(InfoVO ivo) {
        aplcnRegMapper.updateDetailInfo(ivo);
    }

    @Override
    public InfoVO getAllDetailInfo(int user_num) {
        return aplcnRegMapper.getAllDetailInfo(user_num);
    }

    @Override
    public void updateInfo(UserVO uvo) {
        aplcnRegMapper.updateInfo(uvo);
    }

    @Override
    public ArrayList<AddInfoVO> getCareer(int reg_num) {
        return aplcnRegMapper.getCareer(reg_num);
    }

    @Override
    public int getRegnum(int user_num) {
        return aplcnRegMapper.getRegnum(user_num);
    }

    @Override
    public AddInfoVO getSpecial(int reg_num) {
        return aplcnRegMapper.getSpecial(reg_num);
    }

    @Override
    public int getCareerInfo(int reg_num) {
        return aplcnRegMapper.getCareerInfo(reg_num);
    }

    @Override
    public int getSpecialInfo(int reg_num) {
        return aplcnRegMapper.getSpecialInfo(reg_num);
    }

    @Override
    public void updateCareer007(AddInfoVO aivo) {
        aplcnRegMapper.updateCareer007(aivo);
    }

    @Override
    public void setCareer007(AddInfoVO aivo) {
        aplcnRegMapper.setCareer007(aivo);
    }

    @Override
    public void updateCareer007_2(AddInfoVO aivo) {
        aplcnRegMapper.updateCareer007_2(aivo);
    }

    @Override
    public void setCareer007_2(AddInfoVO aivo) {
        aplcnRegMapper.setCareer007_2(aivo);
    }

    @Override
    public ArrayList<AddInfoVO> getSchoolInfo(int reg_num) {
        return aplcnRegMapper.getSchoolInfo(reg_num);
    }

    @Override
    public ArrayList<AddInfoVO> getCertiInfo(int reg_num) {
        return aplcnRegMapper.getCertiInfo(reg_num);
    }

    @Override
    public int getHighCnt(int reg_num) {
        return aplcnRegMapper.getHighCnt(reg_num);
    }

    @Override
    public void setHighSchool(AddInfoVO aivo) {
        aplcnRegMapper.setHighSchool(aivo);
    }

    @Override
    public void updateHighSchool(AddInfoVO aivo) {
        aplcnRegMapper.updateHighSchool(aivo);
    }

    @Override
    public int getUnivInfo(int edpn) {
        return aplcnRegMapper.getUnivInfo(edpn);
    }

    @Override
    public void updateUniv(AddInfoVO aivo) {
        aplcnRegMapper.updateUniv(aivo);
    }

    @Override
    public void setUniv(AddInfoVO aivo) {
        aplcnRegMapper.setUniv(aivo);
    }

    @Override
    public void updateEdcFinal(UserVO uvo) {
        aplcnRegMapper.updateEdcFinal(uvo);
    }

    @Override
    public int getCerti(int cpn) {
        return aplcnRegMapper.getCerti(cpn);
    }

    @Override
    public void updateCerti(AddInfoVO aivo) {
        aplcnRegMapper.updateCerti(aivo);
    }

    @Override
    public void setCerti(AddInfoVO aivo) {
        aplcnRegMapper.setCerti(aivo);
    }

    @Override
    public int getAdpnum(String id) {
        return aplcnRegMapper.getAdpnum(id);
    }

    @Override
    public void uploadFileInfo(AddInfoVO aivo) {
        aplcnRegMapper.uploadFileInfo(aivo);
    }

    @Override
    public void deleteFileInfo(String path) {
        aplcnRegMapper.deleteFileInfo(path);
    }

    @Override
    public String getFilePath(int reg_num, String fileName) {
        return aplcnRegMapper.getFilePath(reg_num, fileName);
    }

    @Override
    public ArrayList<AddInfoVO> getFileInfo(int reg_num) {
        return aplcnRegMapper.getFileInfo(reg_num);
    }

    @Override
    public void updateSts(int reg_num) {
        aplcnRegMapper.updateSts(reg_num);
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
