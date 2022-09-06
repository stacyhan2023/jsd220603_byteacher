package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
    @RequestMapping("/p1")
    @ResponseBody
    public String p1(HttpServletRequest request){
        String info = request.getParameter("info");
        return "接收到参数:"+info;
    }

    @RequestMapping("/p2")
    @ResponseBody
    public String p2(String name,int age){
        return name+":"+age;
    }


}
