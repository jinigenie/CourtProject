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
	
	private int USER_PROPER_NUM;
	private int TRIAL_FCLTT_PROPER_NUM;
	private String APLICN_DTLS_DATE;
	private String APLICN_DTLS_STS;
	private int APLCN_DTLS_PROPER_NUM;
	private String ANNOUNCE_TITLE;
	private String ANNOUNCE_END_DATE;
	
}
