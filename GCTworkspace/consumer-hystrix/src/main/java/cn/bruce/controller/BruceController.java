package cn.bruce.controller;

import cn.bruce.feign.BruceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //他不做业务，去掉用服务的提供者
public class BruceController {

    @Autowired
    private BruceFeign bruceFeign;


    @RequestMapping("/bruce/{name}")
    @HystrixCommand(fallbackMethod = "fallbackBruce")
    public String bruce(@PathVariable String name){
        return bruceFeign.bruce(name);
    }

    //断路器方法，返回值要和方法一致，参数也一致
    //注意一个bug，断路器刚启动时，第一次访问就到断路器。不正常。第一次进入断路器不算数
    public String fallbackBruce(String name){
        return "James";  //当发生异常时，直接返回默认值，这种形式称为：降级
    }



}
