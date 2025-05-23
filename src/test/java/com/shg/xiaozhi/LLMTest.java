package com.shg.xiaozhi;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

@SpringBootTest
class LLMTest {

    //gpt-4o-mini
    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testSpringBoot() {
        //向模型提问
        String answer = openAiChatModel.chat("我是谁?你是谁?");
        //输出结果
        System.out.println(answer);
    }

    //本地部署
    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    public void test() {
        String answer = ollamaChatModel.chat("你是谁?");
        System.out.println(answer);
        String anser1 = ollamaChatModel.chat("你能记住我上个问题么?");
        System.out.println(anser1);
    }


    //阿里云接入 收费
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testQwen() {
        String answer = qwenChatModel.chat("你是谁?");
        System.out.println(answer);
    }
    //阿里云接入图片测试 收费
    @Test
    public void testDashScopeWanx(){
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .modelName("wanx2.1-t2i-plus")
                .apiKey(System.getenv("DASH_SCOPE_API_KEY"))
                .build();
        Response<Image> response = wanxImageModel.generate("奇幻森林精灵：在一片弥漫着轻柔薄雾的古老森林深处，" +
                "阳光透过茂密枝叶洒下金色光斑。一位身材娇小、长着透明薄翼的精灵少女站在一朵硕大的蘑菇上。" +
                "她 有着海藻般的绿色长发，发间点缀着蓝色的小花，皮肤泛着珍珠般的微光。身上穿着由翠绿树叶和白色藤蔓编织而成的" +
                "连衣裙，手中捧着一颗散发着柔和光芒的水晶球，周围环绕着五彩斑斓的蝴蝶，脚下是铺满苔藓的地面，蘑菇和蕨类植物丛生，" +
                "营造出神秘而梦幻的氛围。");
        URI url = response.content().url();
        System.out.println(url);

    }


}
