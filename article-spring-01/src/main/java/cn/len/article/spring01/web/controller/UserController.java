package cn.len.article.spring01.web.controller;

import cn.len.article.spring01.domain.User;
import cn.len.article.spring01.service.UserService;
import cn.len.article.spring01.vendor.SmsSender;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;

/**
 * @author len
 * 2019-08-11
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {
    UserService userService;
    /**
     * 只有生产环境才真正的发送短信,其它环境打印日志即可,此依赖是可选的
     *
     */
    @Nullable
    @NonFinal
    @NotBlank
    @Setter(onMethod_ = {@Autowired})
    SmsSender smsSender;

    @GetMapping({"{userId}"})
    public User me(@PathVariable String userId) {
        final User user = userService.findById(userId);
        if (user == null) {
            // 抛出一个404异常,spring5.0新增类
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "未找到" + userId);
        }
        return user;
    }

    @PostMapping("sms-send")
    public void sendSms(@RequestParam String phone, @RequestParam String content) {
        sendSmsIfAvailable(phone, content);
    }

    private void sendSmsIfAvailable(String phone, String content) {
        if (smsSender != null) {
            smsSender.sender(phone, content);
        } else {
            log.info("向手机号:{} 发送内容:{}", phone, content);
        }
    }
}
