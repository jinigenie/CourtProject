package com.court.proj.aplcnReg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AplcnRegController {

    @GetMapping("/info")
    public String getInfo() {
        return "app/aplcnRegInfo";
    }

    @GetMapping("/career")
    public String getCareer() {
        return "app/aplcnRegCareerAndCert";
    }

    @GetMapping("/test")
    public String teste() {
        return "app/test";
    }


}
