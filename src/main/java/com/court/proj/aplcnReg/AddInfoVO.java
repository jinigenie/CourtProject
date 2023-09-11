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
public class AddInfoVO {

    private int aplcn_carer_proper_num;
    private int aplcn_dtls_proper_num;
    private String company_name;
    private String carer_type;
    private String work_start_date;
    private String work_end_date;
    private String work_description;
    private String work_department;
    private String work_position;

    private String carer_description;
    private String special_note_description;

    private String edctn_school_name;
    private String edctn_major;
    private String edctn_degree;
    private String edctn_admsn_date;
    private String edctn_grdtn_date;


    private String crtfc_type;
    private String issue_agency;
    private String crtfc_number;
    private String issue_date;

}
