package com.yangz.mymusicweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangz.mymusicweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Package com.yangz.mymusicweb.controller
 * @Author Zhang Yang
 * @Date 8/1/22 9:04 PM
 * @Version V1.0
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean res = adminService.verifyPasswd(name, password);

        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Login successful");
            session.setAttribute("username", name);
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Username or password incorrect");
        }
        return  jsonObject;
    }

}
