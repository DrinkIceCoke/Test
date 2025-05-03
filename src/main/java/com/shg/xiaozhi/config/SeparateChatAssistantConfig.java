package com.shg.xiaozhi.config;

import com.shg.xiaozhi.store.CustomChatMessageStore;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeparateChatAssistantConfig {

    @Autowired
    private CustomChatMessageStore  customChatMessageStore;


    @Bean
    public ChatMemoryProvider chatMemoryProvider() {

        return MemoryId -> MessageWindowChatMemory.builder()
                .id(MemoryId)
                .chatMemoryStore(customChatMessageStore)
                .maxMessages(10)
                .build();
    }
}
