package com.yangz.mymusicweb.service;

import org.springframework.stereotype.Component;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 8/1/22 9:07 PM
 * @Version V1.0
 */

public interface AdminService {
    boolean verifyPasswd(String username, String password);
}
