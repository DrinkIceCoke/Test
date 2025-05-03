package com.shg.xiaozhi.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        chatModel = "qwenChatModel",
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {

    String chat(String message);

}
