package com.github.hellxz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatherResultApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(GatherResultApp.class, args);
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("Log4j2 LDAP漏洞存在,请尽快修复!");
    }

    @PostMapping("/getExploitIP")
    public String getExploitIP(@RequestBody String json) {
        System.out.println("Log4j2 LDAP漏洞存在,请尽快修复！\n返回体：" + json);
        return "OK";
    }
}