package org.example;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class Demo2Application {

    private final ChatModel chatModel;

    @RequestMapping(value = "/ai/chat/stream", produces = "text/html;charset=UTF-8;")
    public Flux<String> aiChatStream(@RequestParam(value = "message", defaultValue = "你是谁？") String message) {
        return chatModel.stream(
                        new Prompt(
                                Arrays.asList(
                                        new UserMessage(message),
                                        new SystemMessage("你是一个英语翻译专家，将用户输入的内容，翻译为英文作为输出。")
                                ),
                                OllamaOptions.builder()
                                        .model("deepseek-r1:1.5b")
                                        .temperature(0.8d)
                                        .build()
                        )
                )
                .map(s -> s.getResult())
                .map(s -> s.getOutput())
                .map(s -> s.getText());
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}