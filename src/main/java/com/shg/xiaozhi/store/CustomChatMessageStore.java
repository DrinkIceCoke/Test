package com.shg.xiaozhi.store;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CustomChatMessageStore implements ChatMemoryStore {
    @Override
    public List<ChatMessage> getMessages(Object o) {
        return null;
    }

    @Override
    public void updateMessages(Object o, List<ChatMessage> list) {

    }

    @Override
    public void deleteMessages(Object o) {

    }
}
