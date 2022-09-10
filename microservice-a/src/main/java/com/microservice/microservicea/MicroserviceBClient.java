package com.microservice.microservicea;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b", fallback = GreetFallback.class)
interface MicroserviceBClient {
    @GetMapping("/greet")
    ResponseEntity<String> greet();
}

@Component
class GreetFallback implements MicroserviceBClient{
    @Override
    public ResponseEntity<String> greet() {
        ResponseEntity<String> response= new ResponseEntity<>("You are in fallback!!!", HttpStatus.OK);
        return response;
    }
}

