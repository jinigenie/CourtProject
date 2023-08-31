package com.court.proj.aplcn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aplcn")
public class AplcnController {

    @GetMapping("/aplcnList")
    public String List() {
        return "aplcn/aplcnList";
    }
    
    @GetMapping("/aplcnResult")
    public String Result() {
        return "aplcn/aplcnResult";
    }
    
    @GetMapping("/aplcnDetails")
    public String Details() {
        return "aplcn/aplcnDetails";
    }
    
    @GetMapping("/aplcnEvaluate")
    public String Evaluate() {
        return "aplcn/aplcnEvaluate";
    }
    
    @GetMapping("/fclttRegist")
    public String Regist() {
        return "aplcn/fclttRegist";
    }

}
