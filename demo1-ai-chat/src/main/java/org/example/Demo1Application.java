package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class Demo1Application {

    private final ChatModel chatModel;

    @RequestMapping("/ai/chat")
    public String aiChat(@RequestParam(value = "message", defaultValue = "你是谁？") String message) {
        return chatModel.call(message);
    }

    @RequestMapping(value = "/ai/chat/stream", produces = "text/html;charset=UTF-8;")
    public Flux<String> aiChatStream(@RequestParam(value = "message", defaultValue = "你是谁？") String message) {
        return chatModel.stream(message);
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}