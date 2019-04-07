package cn.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //启动zuul的API GateWay网关
public class RunAppZuul
{

    public static void main(String[] args)
    {
        SpringApplication.run(RunAppZuul.class,args);
    }

}
