package com.scut.blockchain.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/person")
    public String person(){
        return "person";
    }
    @RequestMapping(value = "/person/person_history")
    public String person_history(){
        return "person/person_history";
    }
    @RequestMapping(value = "/person/person_mall")
    public String person_mall(){
        return "person/person_mall";
    }
    @RequestMapping(value = "/person/person_presentscore")
    public  String person_presentscore(){
        return "person/person_presentscore";
    }
    @RequestMapping(value = "/person/person_queryscore")
    public String person_queryscore(){
        return "person/person_queryscore";
    }
    @RequestMapping(value = "/register/registerinside")
    public String registerinside(){
        return "register/registerinside";
    }
    @RequestMapping(value = "/person/brands/adidas")
    public String adidas(){
        return "person/brands/adidas";
    }
    @RequestMapping(value = "/person/brands/apple")
    public String apple(){
        return "person/brands/apple";
    }
    @RequestMapping(value = "/person/brands/aj")
    public String aj(){
        return "person/brands/aj";
    }
    @RequestMapping(value = "/person/brands/baidefeili")
    public String baidefeili(){
        return "person/brands/baidefeili";
    }    @RequestMapping(value = "/person/brands/chanel")
    public String chanel(){
        return "person/brands/chanel";
    }
    @RequestMapping(value = "/person/brands/dior")
    public String dior(){
        return "person/brands/dior";
    }    @RequestMapping(value = "/person/brands/hermes")
    public String hermes(){
        return "person/brands/hermes";
    }
    @RequestMapping(value = "/person/brands/huawei")
    public String huawei(){
        return "person/brands/huawei";
    }    @RequestMapping(value = "/person/brands/jiangshidandun")
    public String jiangshidandun(){
        return "person/brands/jiangshidandun";
    }
    @RequestMapping(value = "/person/brands/nike")
    public String nike(){
        return "person/brands/nike";
    }    @RequestMapping(value = "/person/brands/rog")
    public String rog(){
        return "person/brands/rog";
    }
    @RequestMapping(value = "/person/brands/rolex")
    public String rolex(){
        return "person/brands/rolex";
    }
}
