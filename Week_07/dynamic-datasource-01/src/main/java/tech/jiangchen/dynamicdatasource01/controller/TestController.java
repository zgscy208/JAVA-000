package tech.jiangchen.dynamicdatasource01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangchen.dynamicdatasource01.service.TestService;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        return testService.doSth();
    }
}
