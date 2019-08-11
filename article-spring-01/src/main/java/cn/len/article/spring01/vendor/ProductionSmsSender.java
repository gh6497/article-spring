package cn.len.article.spring01.vendor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author len
 * 2019-08-11
 */
@Profile("production")
@Component
@Slf4j
public class ProductionSmsSender implements SmsSender {
    @Override
    public void sender(String phone, String content) {
        log.info("向手机号:{} 发送内容:{}", phone, content);
    }
}
