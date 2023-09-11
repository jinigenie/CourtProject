package com.court.proj.notice;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeVO {

	private Integer admin_proper_num;  // 관리자 번호
	private String notice_title; // 공지 제목
	private String notice_content; // 공지 내용
	private LocalDateTime notice_date; // 공지등록 일자
	
}
