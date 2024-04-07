package net.hicham.customerservice.web;

import lombok.AllArgsConstructor;
import net.hicham.customerservice.Config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
/*
    @Value("${global.params.x}")
    private int x;
    @Value("${global.params.y}")
    private int y;
    @Value("${customer.params.a}")
    private int a;
    @Value("${customer.params.b}")
    private int b;
    @Value("${account.params.c}")
    private int c;
    @Value("${account.params.d}")
    private int d;
    @GetMapping("/testconfig")
    public Map<String, Integer> params(){
        return Map.of("x",x,"y",y,"a",a,"b",b,"c",c,"d",d);
    }

 */
    @Autowired
    private GlobalConfig globalConfig;
    @GetMapping("/globalconfig")
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }
}
