package org.example;

import lombok.RequiredArgsConstructor;
import org.example.tools.DateTimeTools;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class Demo8Application {

    private final ChatModel chatModel;

    @RequestMapping(value = "/ai/function/stream", produces = "text/html;charset=UTF-8;")
    public Flux<String> aiFunctionStream(@RequestParam(value = "message", defaultValue = "今天的日期") String message) {
        return chatModel.stream(
                        new Prompt(
                                new UserMessage(message),
                                OllamaOptions.builder()
                                        .toolCallbacks(ToolCallbacks.from(new DateTimeTools()))
                                        .model("qwen2.5:0.5b")
                                        .temperature(0.8d)
                                        .build()
                        )
                )
                .map(s -> s.getResult())
                .map(s -> s.getOutput())
                .map(s -> s.getText());
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo8Application.class, args);
    }

}