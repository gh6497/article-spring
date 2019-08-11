package cn.len.article.spring01.service;

import cn.len.article.spring01.domain.User;
import org.springframework.lang.Nullable;

/**
 * @author len
 * 2019-08-11
 */
public interface UserService {
    @Nullable
    User findById(String userId);
}
