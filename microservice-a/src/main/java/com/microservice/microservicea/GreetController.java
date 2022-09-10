package com.microservice.microservicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @Autowired
    private MicroserviceBClient client;

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        String msg = client.greet().getBody();
        return new ResponseEntity<String>("Response from service 1 - " + msg,HttpStatus.OK);
    }
}
