package com.court.proj.aplcnReg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class S3Service {

    @Autowired
    private S3Client s3;

    @Value("${aws_bucket_name}")
    private String aws_bucket_name;

    public void getBucketList() {
        // s3기능 사용
        // List buckets
        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
        ListBucketsResponse listBucketsResponse = s3.listBuckets(listBucketsRequest);
        listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));
    }

    // S3파일 업로드
    public void putS3Object(String uploadName, byte[] originData, String folderpath) {
        try {
            Map<String, String> metadata = new HashMap<>();
            String keyName = folderpath + uploadName;

            metadata.put("x-amz-meta-myVal", "test");
            PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(aws_bucket_name) // 버킷명
                    .key(keyName) // 파일명
                    .metadata(metadata)
                    .build();

            PutObjectResponse response = s3.putObject(putOb, RequestBody.fromBytes(originData));
            System.out.println("Successfully placed " + uploadName + " into bucket " + aws_bucket_name);
            System.out.println("성공 실패 여부 : " + response.sdkHttpResponse().statusCode()); // 성공, 실패 여부

            //////////////////////////////////////////////////////////
            // db code 구현

        } catch (S3Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // 버킷 객체 삭제
    public void deleteBucketObjects(String keyName) {

        ObjectIdentifier objectId = ObjectIdentifier.builder()
                .key(keyName)
                .build();


        Delete del = Delete.builder()
                .objects(objectId)
                .build();

        try {
            DeleteObjectsRequest multiObjectDeleteRequest = DeleteObjectsRequest.builder()
                    .bucket(aws_bucket_name)
                    .delete(del)
                    .build();
            DeleteObjectsResponse result = s3.deleteObjects(multiObjectDeleteRequest);
            System.out.println("Multiple objects are deleted!");
            System.out.println(result.sdkHttpResponse());

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }

    }

}
