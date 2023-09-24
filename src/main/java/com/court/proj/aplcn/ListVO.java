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

	// 신청자 리스트
	private Integer user_proper_num;
	private Integer aplcn_dtls_proper_num;
	private String trial_fcltt_clasifi_code;
	private String aplicn_dtls_sts;
	private String court_proper1;
	private String court_proper2;
	private String court_name;
	private String aplicn_dtls_date;

	// 신청자 상세정보
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
	private String edctn_final;
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
	private Integer trial_fcltt_proper_num;
	private Integer court_proper_num;

	// 신청자 기본정보
	private String user_phone;
	private String user_rrn_f;
	private String user_email_f;
	private String user_email_b;
	private String user_edctn_final;
	private String user_ar;

	// 신청자 평가
	private String admin_proper_num;
	private Integer all_carer_score;
	private Integer jrsdc_carer_score;
	private Integer office_score;
	private Integer personality_score;
	private Integer interview_score;
	private Integer certificate_score;
	private Integer evaluate_score;
	private Integer judge_recom_score;
	private String review_etc;

	// 등재하기
	private String accept_date;
	private String accept_etc;
	private String accept_act_yn;

	// 파일 다운로드
	private Integer aplcn_atch_file_proper_num;
	private String file_code;
	private String file_type;
	private String original_file_name;
	private String file_path;

}
