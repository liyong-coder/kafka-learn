package com.example.providerone;

import com.example.providerone.provider.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProviderOneApplication {
    @Autowired
    private KafkaSender kafkaSender;

    public static void main(String[] args) {
        SpringApplication.run(ProviderOneApplication.class, args);
    }

    @RequestMapping("/send")
    public String send(@RequestParam(value = "name",required = false) String name){
        kafkaSender.send(name);
        return "发送成功";
    }

}
