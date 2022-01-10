package com.yangz.mymusicweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangz.mymusicweb.entity.Collect;
import com.yangz.mymusicweb.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Package com.yangz.mymusicweb.controller
 * @Author Zhang Yang
 * @Date 8/1/22 9:19 PM
 * @Version V1.0
 */
@RestController
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping(value = "/collection/add", method = RequestMethod.POST)
    public Object addCollection(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String user_id = req.getParameter("userId").trim();
        String type = req.getParameter("type").trim();
        String song_id=req.getParameter("songId").trim();
        String song_list_id=req.getParameter("songListId").trim();
        if (song_id == null || song_id.equals("")) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "The song is Empty");
            return jsonObject;
        }
        else if (collectService.existSongId(Integer.parseInt(user_id), Integer.parseInt(song_id))) {
            jsonObject.put("code", 2);
            jsonObject.put("msg", "Has been added to your collection");
            return jsonObject;
        }
        Collect collect = new Collect();
        collect.setUserId(Integer.parseInt(user_id));
        collect.setType(new Byte(type));
        if (new Byte(type) == 0) {
            collect.setSongId(Integer.parseInt(song_id));
        }
        else {
            collect.setSongListId(Integer.parseInt(song_list_id));
        }
        collect.setCreateTime(new Date());
        boolean res = collectService.addCollection(collect);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Collected successful");
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Collected failed");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public Object allCollection(HttpServletRequest req) {
        return collectService.allCollection();
    }

    @RequestMapping(value = "/collection/detail", method = RequestMethod.GET)
    public Object collectionOfUser(HttpServletRequest req) {
        int user_id = Integer.parseInt(req.getParameter("userId").trim());
        return collectService.collectionOfUser(user_id);
    }

    @RequestMapping(value = "/collection/delete", method = RequestMethod.GET)
    public Object deleteCollection(HttpServletRequest req) {
        int user_id = Integer.parseInt(req.getParameter("userId").trim());
        int song_id = Integer.parseInt(req.getParameter("songId").trim());
        return collectService.deleteCollection(user_id, song_id);
    }

    @RequestMapping(value = "/collection/update", method = RequestMethod.POST)
    public Object updateCollectMsg(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String user_id = req.getParameter("userId").trim();
        String type = req.getParameter("type").trim();
        String song_id= req.getParameter("songId").trim();

        Collect collect = new Collect();
        collect.setId(Integer.parseInt(id));
        collect.setUserId(Integer.parseInt(user_id));
        collect.setType(new Byte(type));
        collect.setSongId(Integer.parseInt(song_id));

        boolean res = collectService.updateCollectMsg(collect);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Updated successful");
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Updated failed");
        }
        return jsonObject;
    }
}