package com.court.proj.aplcnReg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoVO {

    private int aplcn_dtls_proper_num;
    private int user_proper_num;
    private int trial_fcltt_proper_num;
    private String court_proper1;
    private String court_proper2;
    private String ligtn_case_carer_yn;
    private String ligtn_case_carer_etc;
    private String insrn_indst_carer_yn;
    private String insrn_indst_carer_etc;
    private String criminal_penalty_carer_yn;
    private String criminal_penalty_carer_etc;
    private String aplicn_dtls_sts;
    private String aplicn_dtls_date;

    // 선택한 재판조력자 유형
    private String selectType1;
    private String selectType2;
    private String selectType3;

    // 선택한 법원 목록
    private String[] selectCourts;

}
