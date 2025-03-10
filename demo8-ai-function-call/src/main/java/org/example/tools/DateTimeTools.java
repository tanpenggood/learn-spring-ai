package org.example.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
public class DateTimeTools {

    @Tool(description = "获取今天的日期")
    String getToday() {
        String result = LocalDate.now().toString();
        log.info("result={}", result);
        return result;
    }

    @Tool(description = "获取现在的时间")
    String getCurrentTime() {
        String result = LocalDateTime.now().toString();
        log.info("result={}", result);
        return result;
    }

}