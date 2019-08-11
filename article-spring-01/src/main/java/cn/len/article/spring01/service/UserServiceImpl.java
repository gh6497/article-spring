package cn.len.article.spring01.service;

import cn.len.article.spring01.domain.User;
import cn.len.article.spring01.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * @author len
 * 2019-08-11
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    @Nullable
    public User findById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
