package com.court.proj.aplcnReg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoVO {

    private int user_propoer_num;
    private int trial_fcltt_proper_num;
    private int court_proper_num;
    private char ligtn_case_carer_yn;
    private String ligtn_case_carer_etc;
    private char insrn_indst_carer_yn;
    private String insrn_indst_carer_etc;
    private char criminal_penalty_carer_yn;
    private String criminal_penalty_carer_etc;
    private String aplcn_dtls_sts;
    private Date aplcn_dtls_date;
}
