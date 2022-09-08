package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    @RequestMapping("/helloAxios")
    public String helloAxios(String info){
        return "测试成功! info="+info;
    }

    //如果客户端发出的是异步post请求 并且提交的是自定义JS对象参数
    // 必须使用@RequestBody注解修饰接收参数的对象
    @RequestMapping("/postAxios")
    public String postAxios(@RequestBody User user){

        return "测试成功!"+user.toString();
    }

}
