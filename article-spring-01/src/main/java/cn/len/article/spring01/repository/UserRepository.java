package cn.len.article.spring01.repository;

import cn.len.article.spring01.domain.User;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author len
 * 2019-08-11
 */
@Repository
public class UserRepository {
    private final Map<String,User> userMap = new ConcurrentHashMap<String,User>() {
        {
            val user1 = new User("1","1");
            val user2 = new User("2","2");
            val user3 = new User("3","3");
            val user4 = new User("4","4");
            put("1", user1);
            put("2", user2);
            put("3", user3);
            put("4", user4);
        }
    };
    public Optional<User> findById(String userId) {
        return Optional.ofNullable(userMap.get(userId));
    }
}
