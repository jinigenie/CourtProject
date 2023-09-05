package com.court.proj.aplcnReg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private AplcnRegService aplcnRegService;

    @PostMapping("/api/setData")
    public String setData(@RequestBody Map<String, List<CertiVO>> vo) {
        List<CertiVO>list=(List<CertiVO>)vo.get("list");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
//            aplcnRegService.setCerti(list.get(i));
        }

        return "b";
    }



}
