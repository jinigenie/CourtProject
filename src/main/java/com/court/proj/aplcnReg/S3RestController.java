package com.court.proj.aplcnReg;

import com.court.proj.user.CourtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class S3RestController {

    @Autowired
    private S3Service s3;

    @Autowired
    @Qualifier("aplcnRegService")
    private AplcnRegService aplcnRegService;


    // file upload : 한 개 파일
    @PostMapping("/cloudUpload1")
    public ResponseEntity<String> cloudUpload(@RequestParam("file_data") MultipartFile file,
                                              @RequestParam("file_code") String file_code,
                                              @RequestParam("file_type") String file_type,
                                              Authentication auth) {

        CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
        String id = user.getUser_id();

        int reg_num = aplcnRegService.getAdpnum(id);

        AddInfoVO aivo = new AddInfoVO();
        aivo.setFile_code(file_code);
        aivo.setFile_type(file_type);
        aivo.setAplcn_dtls_proper_num(reg_num);

        String folderpath = "app/" + id + "/";

        try {
            String originName = file.getOriginalFilename();

            String uploadName = file_code + "_" + file_type + "_" + originName;
            byte[] originData = file.getBytes();

            aivo.setOriginal_file_name(originName);
            aivo.setFile_path(folderpath + uploadName);

            s3.putS3Object(uploadName, originData, folderpath);
            aplcnRegService.uploadFileInfo(aivo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("응답 데이터", HttpStatus.OK);
    }

    // file upload : 여러 개 파일
    @PostMapping("/cloudUpload2")
    public ResponseEntity<String> cloudUpload(@RequestParam("file_data") List<MultipartFile> files,
                                              @RequestParam("file_code") List<String> file_code,
                                              @RequestParam("file_type") List<String> file_type,
                                              Authentication auth) {

        CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
        String id = user.getUser_id();

        int reg_num = aplcnRegService.getAdpnum(id);

        String folderpath = "app/" + id + "/";

        try {
            for (int i = 0 ; i < files.size(); i++) {

                AddInfoVO aivo = new AddInfoVO();
                aivo.setFile_code(file_code.get(i));
                aivo.setFile_type(file_type.get(i));
                aivo.setAplcn_dtls_proper_num(reg_num);

                String originName = files.get(i).getOriginalFilename();
                byte[] originData = files.get(i).getBytes();
                String uploadName = file_code.get(i) + "_" + file_type.get(i) + "_" + originName;

                aivo.setOriginal_file_name(originName);
                aivo.setFile_path(uploadName);

                s3.putS3Object(uploadName, originData, folderpath);
                aplcnRegService.uploadFileInfo(aivo);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("응답 데이터", HttpStatus.OK);
    }

    @PostMapping("/delete_file")
    public ResponseEntity delete_file(@RequestParam("del_file") String del_file,
                                      Authentication auth){

        CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
        String id = user.getUser_id();

        int reg_num = aplcnRegService.getAdpnum(id);
        String del_path = aplcnRegService.getFilePath(reg_num, del_file);

        s3.deleteBucketObjects(del_path);
        aplcnRegService.deleteFileInfo(del_path);
        return new ResponseEntity<>("응답 데이터", HttpStatus.OK);
    }

    @PostMapping("/delete_files")
    public ResponseEntity delete_file(@RequestParam("del_file") List<String> del_files,
                                      Authentication auth){

        CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
        String id = user.getUser_id();

        int reg_num = aplcnRegService.getAdpnum(id);
        String del_path = "";


        String del_file;
        for(int i = 0; i < del_files.size(); i++) {
            del_file = del_files.get(i);
            del_path = aplcnRegService.getFilePath(reg_num, del_file);
            s3.deleteBucketObjects(del_path);
            aplcnRegService.deleteFileInfo(del_path);
        }

        return new ResponseEntity<>("응답 데이터", HttpStatus.OK);
    }

}
