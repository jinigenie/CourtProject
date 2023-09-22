package com.court.proj.aplcn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AplcnS3Service {

	// 버킷 객체 다운로드
	public void getObjectBytes(String path, String keyName) {
		/*
		try {
			GetObjectRequest objectRequest = GetObjectRequest.builder().key(keyName).bucket(aplcnFiles).build();

			ResponseBytes<GetObjectResponse> objectBytes = s3.getObjectAsBytes(objectRequest);
			byte[] data = objectBytes.asByteArray();

			// Write the data to a local file.
			File myFile = new File(path);
			OutputStream os = new FileOutputStream(myFile);
			os.write(data);
			System.out.println("Successfully obtained bytes from an S3 object");
			os.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (S3Exception e) {
			System.err.println(e.awsErrorDetails().errorMessage());
		}
		*/
	}
	
}
