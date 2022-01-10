package com.yangz.mymusicweb.service.impl;

import com.yangz.mymusicweb.dao.ConsumerMapper;
import com.yangz.mymusicweb.entity.Consumer;
import com.yangz.mymusicweb.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service.impl
 * @Author Zhang Yang
 * @Date 8/1/22 12:29 PM
 * @Version V1.0
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public boolean addUser(Consumer consumer) {
        return consumerMapper.addUser(consumer) > 0;
    }

    @Override
    public List<Consumer> allUser() {
        return consumerMapper.allUser();
    }

    @Override
    public List<Consumer> userOfId(int id) {
        return consumerMapper.userOfId(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return consumerMapper.deleteUser(id) > 0;
    }

    @Override
    public boolean updateUserMsg(Consumer consumer) {
        return consumerMapper.updateUserMsg(consumer) > 0;
    }

    @Override
    public boolean updateUserAvator(Consumer consumer) {
        return consumerMapper.updateUserAvator(consumer) > 0;
    }

    @Override
    public boolean verifyPasswd(String username, String password) {
        return consumerMapper.verifyPasswd(username, password) > 0;
    }

    @Override
    public List<Consumer> loginStatus(String username) {
        return consumerMapper.loginStatus(username);
    }
}
