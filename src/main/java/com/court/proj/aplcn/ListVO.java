package com.court.proj.aplcn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListVO {

	private Integer user_proper_num;
	private Integer aplcn_dtls_proper_num;
	private String trial_fcltt_clasifi_code;
	private String aplicn_dtls_sts;
	private String court_name;
	
	private String user_name;
	private String user_id;
	private String ligtn_case_carer_yn;
	private String ligtn_case_carer_etc;
	private String insrn_indst_carer_yn;
	private String insrn_indst_carer_etc;
	private String criminal_penalty_carer_yn;
	private String criminal_penalty_carer_etc;
	private String edctn_school_name;
	private String edctn_major;
	private String edctn_admsn_date;
	private String edctn_grdtn_date;
	private String edctn_degree;
	private String edctn_final_yn;
	private String company_name;
	private String carer_type;
	private String work_start_date;
	private String work_end_date;
	private String work_department;
	private String work_position;
	private String work_description;
	private String carer_description;
	private String special_note_description;
	private String crtfc_type;
	private String issue_agency;
	private String crtfc_number;
	private String issue_date;
	private String trial_fcltt_sbcls_code;
	private String court_region;

	private Integer all_carer_score;
	private Integer jrsdc_carer_score;
	private Integer office_score;
	private Integer personality_score;
	private Integer interview_score;
	private Integer certificate_score;
	private Integer evaluate_score;
	private Integer judge_recom_score;
	private String review_etc;
	
}
