package cn.len.article.spring01.vendor;

/**
 * @author len
 * 2019-08-11
 */
public interface SmsSender {
    void sender(String phone,String content);
}
