package com.court.proj.aplcn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AplcnCloudController {
	
	@Autowired
    //private AmazonS3 amazonS3;

	// 다운로드
	@PostMapping("/aplcnFiles")
	public ResponseEntity<String> aplcnFiles(@RequestParam("aplcn_dtls_proper_num") String aplcn_dtls_proper_num, Model model) {

		String path = "/Users/user/Desktop/downtest";
		String fileCode = "file_code";
		String fileType = "file_type";
		String originalFileName = "original_file_name";

		String path1 = path + "/" + fileCode + "_" + fileType + "_" + originalFileName;

		String keyName = "path1"; // 디비에 있는 file_path 컬럼을 불러온다.

		// s3.getObjectBytes(path, keyName);
		return new ResponseEntity<>("다운로드 결과", HttpStatus.OK);
	}

}
