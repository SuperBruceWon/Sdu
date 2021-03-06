package cn.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //Eureka客户端
public class AunAppPUSecond {

    public static void main(String[] args) {
        SpringApplication.run(AunAppPUSecond.class,args);
    }

}
