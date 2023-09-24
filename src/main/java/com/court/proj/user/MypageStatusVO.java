package com.court.proj.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MypageStatusVO {
	
	private String user_proper_num;
	private String trial_fcltt_proper_num;
	private String aplicn_dtls_date;
	private String aplicn_dtls_sts;
	private String aplcn_dtls_proper_num;
	private String announce_title;
	private String trial_fcltt_clasifi_code;
	
}
