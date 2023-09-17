package com.court.proj.faq;

import java.time.LocalDateTime;

import com.court.proj.fcltt.FclttPageVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaqVO {
	
	private FclttPageVO fclttPageVO;
	private Integer faq_proper_num;  // faq 번호
	private Integer admin_proper_num; // 작성 관리자 번호
	private String faq_ask_content; //질문 
	private String faq_ask_comment; //답변 
	private LocalDateTime faq_ask_date; //작성일
	
	
	
	
}
