package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//localhost:8080/hello
//次注解的作用是声明当前类为 控制器类 当Web服务软件接收到请求后
//会找到所有的控制器类,然后再通过请求的路径找到对应的方法
@Controller
public class HelloController {

//    @RequestMapping("/hello")  //设置当前方法所处理的网络地址
//    public void hello(HttpServletResponse response) throws IOException {
//        //设置响应类型
//        response.setContentType("text/html;charset=utf-8");
//        //得到输出对象  异常抛出
//        PrintWriter pw = response.getWriter();
//        //给客户端响应数据
//        pw.println("请求成功!");
//        //关闭资源
//        pw.close();
//    }

    @RequestMapping("/hello")
    @ResponseBody    //此注解的作用是通过返回值的方式给客户端响应数据
    public String hello(){
        return "请求成功!";
    }
}
