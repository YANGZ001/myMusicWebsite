package com.yangz.mymusicweb.service;

import com.yangz.mymusicweb.entity.Consumer;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 8/1/22 12:29 PM
 * @Version V1.0
 */
public interface ConsumerService {
    boolean addUser(Consumer consumer);
    List<Consumer> allUser();
    List<Consumer> userOfId(int id);
    boolean deleteUser(int id);

    boolean updateUserMsg(Consumer consumer);

    boolean updateUserAvator(Consumer consumer);

    boolean verifyPasswd(String username, String password);

    List<Consumer> loginStatus(String username);
}
