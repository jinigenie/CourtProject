package com.court.proj.aplcnReg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrialVO {

    private String trial_fcltt_proper_num;
    private String trial_fcltt_main_code;
    private String trial_fcltt_clasifi_code;
    private String trial_fcltt_sbcls_code;
    private String trial_fcltt_description;
}
