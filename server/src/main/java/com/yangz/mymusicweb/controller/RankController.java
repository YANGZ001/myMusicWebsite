package com.yangz.mymusicweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangz.mymusicweb.config.Constants;
import com.yangz.mymusicweb.entity.Rank;
import com.yangz.mymusicweb.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package com.yangz.mymusicweb.controller
 * @Author Zhang Yang
 * @Date 9/1/22 2:59 PM
 * @Version V1.0
 */
@RestController
public class RankController {
    @Autowired
    private RankService rankService;

    @RequestMapping(value = "/rank/add", method = RequestMethod.POST)
    public Object addRank(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String songListId = req.getParameter("songListId").trim();
        String consumerId = req.getParameter("consumerId").trim();
        String score = req.getParameter("score").trim();

        Rank rank = new Rank();
        rank.setSonglistid(Long.parseLong(songListId));
        rank.setConsumerid(Long.parseLong(consumerId));
        rank.setScore(Integer.parseInt(score));

        boolean res = rankService.addRank(rank);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Add rank successful");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Add rank unsuccessful");
            return jsonObject;
        }
    }

    //get the rank of a song list
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public Object rankOfSongListId(HttpServletRequest req){
        String songListId = req.getParameter("songListId");
        return rankService.rankOfSongListId(Long.parseLong(songListId));
    }
}
