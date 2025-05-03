package com.shg.xiaozhi;



import com.shg.xiaozhi.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String answer = assistant.chat("你好，你是谁？");
        System.out.println(answer);
    }

    @Autowired
    private Assistant assistant;
    @Test
    public void testChat2() {
        String answer = assistant.chat("你好，你是谁？1+1的答案是什么");
        System.out.println(answer);
    }
}
