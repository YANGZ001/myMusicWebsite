package com.yangz.mymusicweb.service.impl;

import com.yangz.mymusicweb.dao.AdminMapper;
import com.yangz.mymusicweb.dao.ConsumerMapper;
import com.yangz.mymusicweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.yangz.mymusicweb.service.impl
 * @Author Zhang Yang
 * @Date 8/1/22 9:08 PM
 * @Version V1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean verifyPasswd(String username, String password) {
        return adminMapper.verifyPasswd(username, password) > 0;
    }
}
