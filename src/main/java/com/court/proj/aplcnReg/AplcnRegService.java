package com.court.proj.aplcnReg;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.user.UserVO;

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
    // 선택된 공고 불러오기
    public AnnounceVO getSelectedAnnounce(int listNum);

    // 선택된 재판조력자 데이터 불러오기
    public TrialVO getTrialVO(int trial_pn);
    // 선택한 재판조력자 pk 불러오기
    public int getTrialNum1(String st1, String st2);
    public int getTrialNum2(String st1, String st2, String st3);
    // 상세정보 테이블에 유저 정보가 있는지 확인하기
    public int getDetailInfo(int user_num);
    // 상세정보 테이블에 데이터 넣기
    public void setDetailInfo(InfoVO ivo);
    // 상세정보 테이블 업데이트하기
    public void updateDetailInfo(InfoVO ivo);
    // 상세정보 테이블값 불러오기
    public InfoVO getAllDetailInfo(int user_num);
    // 기본정보 업데이트하기
    public void updateInfo(UserVO uvo);

    // 경력사항 불러오기
    public ArrayList<AddInfoVO> getCareer(int reg_num);
    // reg_num(aplcn_dtls_proper_num) 불러오기
    public int getRegnum(int user_num);
    // 활동기록 불러오기
    public AddInfoVO getSpecial(int reg_num);
    // 경력 테이블에 유저 정보가 있는지 확인하기
    public int getCareerInfo(int reg_num);
    // 특기사항 테이블에 유저 정보가 있는지 확인하기
    public int getSpecialInfo(int reg_num);
    // 경력정보 업데이트하기
    public void updateCareer007(AddInfoVO aivo);
    // 경력정보 저장하기
    public void setCareer007(AddInfoVO aivo);
    // 특기사항 업데이트하기
    public void updateCareer007_2(AddInfoVO aivo);
    // 특기사항 저장하기
    public void setCareer007_2(AddInfoVO aivo);

    // 학력정보 불러오기
    public ArrayList<AddInfoVO> getSchoolInfo(int reg_num);
    // 자격증 불러오기
    public ArrayList<AddInfoVO> getCertiInfo(int reg_num);
    // 고등학교 정보 있는지 확인하기
    public int getHighCnt(int reg_num);
    // 고등학교 정보 저장하기
    public void setHighSchool(AddInfoVO aivo);
    // 고등학교 정보 업데이트하기
    public void updateHighSchool(AddInfoVO aivo);
    // 학력 테이블에 대학정보가 있는지 확인하기
    public int getUnivInfo(int edpn);
    // 대학 정보 업데이트하기
    public void updateUniv(AddInfoVO aivo);
    // 대학 정보 저장하기
    public void setUniv(AddInfoVO aivo);
    // 최종학력 업데이트하기
    public void updateEdcFinal(UserVO uvo);


    // 자격증 테이블에 자격증 정보가 있는지 확인하기
    public int getCerti(int cpn);
    // 자격증 정보 업데이트하기
    public void updateCerti(AddInfoVO aivo);
    // 자격증 정보 저장하기
    public void setCerti(AddInfoVO aivo);


    // aplcn_dtls_proper_num 받아오기
    public int getAdpnum(String id);
    // file info 업로드하기
    public void uploadFileInfo(AddInfoVO aivo);
    // file info 삭제하기
    public void deleteFileInfo(String path);
    // file path 가져오기
    public String getFilePath(int reg_num, String fileName);
    // file Info 가져오기
    public ArrayList<AddInfoVO> getFileInfo(int reg_num);

    // 신청완료 상태 변경하기
    public void updateSts(int reg_num);

//    void setCerti(CertiVO vo);
//    public ArrayList<CertiVO> getCerti(@Param("vo") CertiVO vo);


}
