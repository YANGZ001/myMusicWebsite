package com.yangz.mymusicweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangz.mymusicweb.config.Constants;
import com.yangz.mymusicweb.entity.Singer;
import com.yangz.mymusicweb.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package com.yangz.mymusicweb.controller
 * @Author Zhang Yang
 * @Date 9/1/22 3:21 PM
 * @Version V1.0
 */
@RestController
public class SingerController {
    @Autowired
    private SingerService singerService;

    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) { // windows
                registry.addResourceHandler("/img/singerPic/**")
                        .addResourceLocations("file:" + Constants.RESOURCE_WIN_PATH + "\\img\\singerPic\\");
            } else { //  UNIX
                registry.addResourceHandler("/img/singerPic/**")
                        .addResourceLocations("file:" + Constants.RESOURCE_MAC_PATH + "/img/singerPic/");
            }
        }
    }

    //add singer
    @ResponseBody
    @RequestMapping(value = "/singer/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String name = req.getParameter("name").trim();
        String sex = req.getParameter("sex").trim();
        String pic = req.getParameter("pic").trim();
        String birth = req.getParameter("birth").trim();
        String location = req.getParameter("location").trim();
        String introduction = req.getParameter("introduction").trim();
        //leave id, cause auto incremental.

        Singer singer = new Singer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        }catch (Exception e){
            e.printStackTrace();
        }
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);

        boolean res = singerService.addSinger(singer);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Add singer successful");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Add singer unsuccessful");
            return jsonObject;
        }
    }

    //return all singers
    @RequestMapping(value = "/singer", method = RequestMethod.GET)
    public Object allSinger(){
        return singerService.allSinger();
    }

    //find singer by name
    @RequestMapping(value = "/singer/name/detail", method = RequestMethod.GET)
    public Object singerOfName(HttpServletRequest req){
        String name = req.getParameter("name").trim();
        return singerService.singerOfName(name);
    }

    //fing singer by gender
    @RequestMapping(value = "/singer/sex/detail", method = RequestMethod.GET)
    public Object singerOfSex(HttpServletRequest req){
        String sex = req.getParameter("sex").trim();
        return singerService.singerOfSex(Integer.parseInt(sex));
    }

    @RequestMapping(value = "/singer/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest req){
        String id = req.getParameter("id");
        return singerService.deleteSinger(Integer.parseInt(id));
    }

    @RequestMapping(value = "/singer/update", method = RequestMethod.POST)
    public Object updateSingerMsg(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String name = req.getParameter("name").trim();
        String sex = req.getParameter("sex").trim();
        String pic = req.getParameter("pic").trim();
        String birth = req.getParameter("birth").trim();
        String location = req.getParameter("location").trim();
        String introduction = req.getParameter("introduction").trim();

        Singer singer = new Singer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        }catch (Exception e){
            e.printStackTrace();
        }
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);

        boolean res = singerService.updateSingerMsg(singer);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Updated successful");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Updated unsuccessful");
            return jsonObject;
        }
    }

    @RequestMapping(value = "/singer/avatar/update", method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();

        if (avatorFile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "File upload unsuccessful！");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "singerPic" ;
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeAvatorPath = "/img/singerPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storeAvatorPath);
            boolean res = singerService.updateSingerPic(singer);
            if (res){
                jsonObject.put("code", 1);
                jsonObject.put("pic", storeAvatorPath);
                jsonObject.put("msg", "File upload successful");
                return jsonObject;
            }else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "File upload unsuccessful");
                return jsonObject;
            }
        }catch (IOException e){
            jsonObject.put("code", 0);
            jsonObject.put("msg", "File upload unsuccessful" + e.getMessage());
            return jsonObject;
        }finally {
            return jsonObject;
        }
    }
}
