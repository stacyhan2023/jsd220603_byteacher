package cn.tedu.coolshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//组件扫描注解,添加了此注解后 过滤器才会生效
@ServletComponentScan
@SpringBootApplication
public class CoolsharkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoolsharkApplication.class, args);
    }

}
