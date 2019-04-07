package cn.bruce.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//调用服务的提供者
@FeignClient("provider-user")
public interface BruceFeign {
    @RequestMapping("/bruce/{name}")
    public String bruce(@PathVariable("name") String name);

}
