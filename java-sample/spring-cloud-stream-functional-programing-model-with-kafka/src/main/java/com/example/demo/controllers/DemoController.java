package com.example.demo.controllers;

import com.example.demo.dtos.SimpleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/demo")
public class DemoController {

    private final StreamBridge streamBridge;

    @GetMapping("/publish")
    ResponseEntity<String> publish () {
        var payload = new SimpleMessage("message");
        var res = streamBridge.send("mqProducer-out-0", payload);
        if (!res) {
            throw new RuntimeException("send error.");
        }
        System.out.println("### producer: " + payload.message());
        return ResponseEntity.ok().body("OK");
    }
}
