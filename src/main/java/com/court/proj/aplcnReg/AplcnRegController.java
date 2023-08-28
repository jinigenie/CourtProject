package com.court.proj.aplcnReg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aplcn")
public class AplcnRegController {

    @GetMapping("/info")
    public String getInfo() {
        return "aplcnRegInfo";
    }

}
