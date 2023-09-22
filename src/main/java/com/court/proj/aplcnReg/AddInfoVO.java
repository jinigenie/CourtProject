package com.court.proj.aplcnReg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddInfoVO {

    //회사경력
    private int aplcn_carer_proper_num;
    private int aplcn_dtls_proper_num;
    private String company_name;
    private String carer_type;
    private String[] carer_typeList;
    private String work_start_date;
    private String work_end_date;
    private String work_description;
    private String work_department;
    private String work_position;

    //활동내용, 특기사항
    private String carer_description;
    private String special_note_description;

    //학력
    private int edctn_dtls_proper_num;
    private String edctn_school_name;
    private String edctn_major;
    private String edctn_degree;
    private String edctn_admsn_date;
    private String edctn_grdtn_date;
    private String edctn_final;  //졸업구분

    //자격증
    private int aplcn_crtfc_proper_num;
    private String crtfc_type;
    private String issue_agency;
    private String crtfc_number;
    private String issue_date;

    //파일
    private int aplcn_atch_file_proper_num;
    private String file_code;
    private String file_type;
    private String original_file_name;
    private String file_path;

}
