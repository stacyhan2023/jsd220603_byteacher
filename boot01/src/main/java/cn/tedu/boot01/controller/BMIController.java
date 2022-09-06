package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(double h,double w){
        double bmi = w/(h*h);
        if (bmi<18.4){
            return "兄弟你瘦了!";
        }
        if(bmi<23.9){
            return "身体呗儿棒!";
        }
        if(bmi<27.9){
            return "微微胖!";
        }
        return "该运动起来了!";
    }
}

