package com.yangz.mymusicweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yangz.mymusicweb.entity.Comment;
import com.yangz.mymusicweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Package com.yangz.mymusicweb.controller
 * @Author Zhang Yang
 * @Date 9/1/22 10:45 AM
 * @Version V1.0
 */

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public Object addComment(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId").trim());
        String type = request.getParameter("type").trim();
        int songListId = Integer.parseInt(request.getParameter("songListId").trim());
        int songId = Integer.parseInt(request.getParameter("songId").trim());
        String content = request.getParameter("content").trim();

        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setType(new Byte(type));
        if (comment.getType() == 0) {
            comment.setSongId(songId);
        } else if (comment.getType() == 1) {
            comment.setSongListId(songListId);
        }
        comment.setContent(content);
        comment.setCreateTime(new Date());

        boolean res = commentService.addComment(comment);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Comment successful");
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Comment unsuccessful");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public Object allComment(HttpServletRequest request) {
        return commentService.allComment();
    }

    @RequestMapping(value = "/comment/song/detail", method = RequestMethod.GET)
    public Object commentOfSongId(HttpServletRequest request) {
        int songId = Integer.parseInt(request.getParameter("songId").trim());
        return commentService.commentOfSongId(songId);
    }

    @RequestMapping(value = "/comment/songList/detail", method = RequestMethod.GET)
    public Object commentOfSongListId(HttpServletRequest request) {
        int songListId = Integer.parseInt(request.getParameter("songListId").trim());
        return commentService.commentOfSongListId(songListId);
    }

    // post like for a comment
    @RequestMapping(value = "/comment/like", method = RequestMethod.POST)
    public Object commentOfLike(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id").trim());
        int up = Integer.parseInt(request.getParameter("up").trim());
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUp(up);
        boolean res = commentService.commentOfLike(comment);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Like comment successful");
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Like comment unsuccessful");
        }
        return jsonObject;
    }
    @RequestMapping(value = "/comment/delete", method = RequestMethod.GET)
    public Object deleteComment(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id").trim());
        boolean res = commentService.deleteComment(id);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Delete comment successful");
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Delete comment unsuccessful");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/comment/update", method = RequestMethod.POST)
    public Object updateCommentMsg(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String user_id = req.getParameter("userId").trim();
        String song_id = req.getParameter("songId").trim();
        String song_list_id = req.getParameter("songListId").trim();
        String content = req.getParameter("content").trim();
        String type = req.getParameter("type").trim();
        String up = req.getParameter("up").trim();

        Comment comment = new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setUserId(Integer.parseInt(user_id));
        if (song_id == "") {
            comment.setSongId(null);
        } else {
            comment.setSongId(Integer.parseInt(song_id));
        }

        if (song_list_id == "") {
            comment.setSongListId(null);
        } else {
            comment.setSongListId(Integer.parseInt(song_list_id));
        }
        comment.setContent(content);
        comment.setType(new Byte(type));
        comment.setUp(Integer.parseInt(up));

        boolean res = commentService.updateCommentMsg(comment);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "Comment changed successful");
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "Comment changed unsuccessful");
        }
        return jsonObject;
    }
}