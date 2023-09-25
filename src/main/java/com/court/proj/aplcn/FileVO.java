package com.court.proj.aplcn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileVO {

	// 파일 다운로드
	private Integer aplcn_atch_file_proper_num;
	private String file_code;
	private String file_type;
	private String original_file_name;
	private String file_path;
}
