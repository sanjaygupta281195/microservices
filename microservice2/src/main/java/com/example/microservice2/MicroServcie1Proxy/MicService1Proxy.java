package com.example.microservice2.MicroServcie1Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservice1", url = "${microservice1.url}")
public interface MicService1Proxy {

    @GetMapping("/endpoint") // Example endpoint
    String getService1Data();

}
