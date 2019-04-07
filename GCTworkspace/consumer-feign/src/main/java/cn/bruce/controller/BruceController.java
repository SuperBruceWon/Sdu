package cn.bruce.controller;

import cn.bruce.feign.BruceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController //他不做业务，去掉用服务的提供者
public class BruceController {

    @Autowired
    private BruceFeign bruceFeign;


    @RequestMapping("/bruce/{name}")
    public String bruce(@PathVariable String name){
        return bruceFeign.bruce(name);
//        String url = "http://localhost:7900/bruce/"+name; //提供者URL
//        url = "http://provider-user:7900/bruce/"+name;
//        return restTemplate.getForObject(url,String.class);
    }

}
