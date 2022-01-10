package com.yangz.mymusicweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangz.mymusicweb.config.Constants;
import com.yangz.mymusicweb.entity.Consumer;
import com.yangz.mymusicweb.service.impl.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package com.yangz.mymusicweb.controller
 * @Author Zhang Yang
 * @Date 8/1/22 3:57 PM
 * @Version V1.0
 */
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerServiceImpl consumerService;

    @Configuration
    public class myPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) { // windows
                registry.addResourceHandler("/img/avatorImages/**")
                        .addResourceLocations("file:" + Constants.RESOURCE_WIN_PATH + "\\img\\avatorImages\\");
            } else { // Unix
                registry.addResourceHandler("/img/avatorImages/**")
                        .addResourceLocations("file:" + Constants.RESOURCE_MAC_PATH + "/img/avatorImages/");
            }
        }
    }

    //get all users
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object allUser() {
        return consumerService.allUser();
    }

    //add user
    @ResponseBody
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String sex = request.getParameter("sex").trim();
        String phone_num = request.getParameter("phone_num").trim();
        String email = request.getParameter("email").trim();
        String birth = request.getParameter("birth").trim();
        String introduction = request.getParameter("introduction").trim();
        String location = request.getParameter("location").trim();
        String avator = request.getParameter("avator").trim();

        if (username == null || username.equals("null")) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Username Or password incorrect");
            return jsonObject;
        }

        Consumer consumer = new Consumer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        if (phone_num == null || phone_num.equals("")) {
            consumer.setPhoneNum(null);
        }
        else {
            consumer.setPhoneNum(phone_num);
        }

        if (email == null || email.equals("")) {
            consumer.setEmail(null);
        }
        else {
            consumer.setEmail(email);
        }

        consumer.setBirth(myBirth);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        consumer.setAvator(avator);
        consumer.setCreateTime(new Date());
        consumer.setUpdateTime(new Date());

        //send to consumerService to handler
        boolean res = consumerService.addUser(consumer);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Register successfully");
            return jsonObject;
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Register unsuccessfully");
            return jsonObject;
        }
    }

    //get user of id
    @RequestMapping(value = "/user/detail", method = RequestMethod.GET)
    public Object userOfId(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return consumerService.userOfId(id);
    }

    //delete user of id
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public Object deleteUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return consumerService.deleteUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Object updateUserMsg(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String sex = request.getParameter("sex").trim();
        String phone_num = request.getParameter("phone_num").trim();
        String email = request.getParameter("email").trim();
        String birth = request.getParameter("birth").trim();
        String introduction = request.getParameter("introduction").trim();
        String location = request.getParameter("location").trim();
        String avator = request.getParameter("avator").trim();

        if (username == null || username.equals("null")) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Username Or password incorrect");
            return jsonObject;
        }

        Consumer consumer = new Consumer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        if (phone_num == null || phone_num.equals("")) {
            consumer.setPhoneNum(null);
        }
        else {
            consumer.setPhoneNum(phone_num);
        }

        if (email == null || email.equals("")) {
            consumer.setEmail(null);
        }
        else {
            consumer.setEmail(email);
        }

        consumer.setBirth(myBirth);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        if (avator == null || avator.equals("")) {
            consumer.setAvator(null);
        }
        else {
            consumer.setAvator(email);
        }
        consumer.setUpdateTime(new Date());

        //send to consumerService to handler
        boolean res = consumerService.updateUserMsg(consumer);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Register successfully");
            return jsonObject;
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Register unsuccessfully");
            return jsonObject;
        }
    }

    //update user avator
    @ResponseBody
    @RequestMapping(value = "/user/avatar/update", method = RequestMethod.POST)
    public Object updateUserPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();

        if (avatorFile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Picture uploaded unsuccessful");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "avatorImages" ;
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeAvatorPath = "/img/avatorImages/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvator(storeAvatorPath);
            boolean res = consumerService.updateUserAvator(consumer);
            if (res){
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeAvatorPath);
                jsonObject.put("msg", "Uploaded successful");
                return jsonObject;
            }else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "Uploaded unsuccessful");
                return jsonObject;
            }
        }catch (IOException e){
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Uploaded unsuccessful"+e.getMessage());
            return jsonObject;
        }finally {
            return jsonObject;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean res = consumerService.verifyPasswd(username, password);

        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Login successful");
            jsonObject.put("userMsg", consumerService.loginStatus(username));
            session.setAttribute("username", username);
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Username or password incorrect");
        }
        return  jsonObject;
    }
}
