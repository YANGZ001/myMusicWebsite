package com.yangz.mymusicweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangz.mymusicweb.entity.ListSong;
import com.yangz.mymusicweb.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package com.yangz.mymusicweb.controller
 * @Author Zhang Yang
 * @Date 9/1/22 11:59 AM
 * @Version V1.0
 */
@RestController
public class ListSongController {
    @Autowired
    private ListSongService listSongService;

    @RequestMapping(value = "/listSong.add", method = RequestMethod.POST)
    public Object addListSong(HttpServletRequest request) {
            JSONObject jsonObject = new JSONObject();
            String song_id = request.getParameter("songId").trim();
            String song_list_id = request.getParameter("songListId").trim();

            ListSong listsong = new ListSong();
            listsong.setSongId(Integer.parseInt(song_id));
            listsong.setSongListId(Integer.parseInt(song_list_id));

            boolean res = listSongService.addListSong(listsong);
            if (res) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "Add successfully");
                return jsonObject;
            }
            else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "Add unsuccessfully");
                return jsonObject;
            }
    }

    @RequestMapping(value = "/listSong/update", method = RequestMethod.POST)
    public Object updateListSongMsg(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String song_id = req.getParameter("songId").trim();
        String song_list_id = req.getParameter("songListId").trim();

        ListSong listsong = new ListSong();
        listsong.setId(Integer.parseInt(id));
        listsong.setSongId(Integer.parseInt(song_id));
        listsong.setSongListId(Integer.parseInt(song_list_id));

        boolean res = listSongService.updateListSongMsg(listsong);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Update successfully");
            return jsonObject;
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Update unsuccessfully");
            return jsonObject;
        }
    }


    @RequestMapping(value = "/listSong/delete", method = RequestMethod.GET)
    public Object deleteListSong(HttpServletRequest request) {
        String songId = request.getParameter("songId");
        return listSongService.deleteListSong(Integer.parseInt(songId));
    }


    @RequestMapping(value = "/listSong/detail", method = RequestMethod.GET)
    public Object listSongOfSongId(HttpServletRequest request) {
        String songListId = request.getParameter("songListId");
        return listSongService.listSongOfSongId(Integer.parseInt(songListId));
    }


    @RequestMapping(value = "/listSong", method = RequestMethod.GET)
    public Object allListSong(HttpServletRequest request) {
        return listSongService.allListSong();
    }
}
