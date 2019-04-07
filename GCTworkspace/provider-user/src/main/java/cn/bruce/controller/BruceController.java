package cn.bruce.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BruceController
{

    @RequestMapping("/bruce/{name}")
    public String bruce(@PathVariable String name)
    {
        return "springboot-bruce now"+name;
    }

}
