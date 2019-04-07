package cn.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class RunAppSidecar {
    public static void main(String[] args) {
        SpringApplication.run(RunAppSidecar.class,args);
    }
}
