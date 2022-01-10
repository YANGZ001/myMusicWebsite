package com.yangz.mymusicweb.service;

import com.yangz.mymusicweb.entity.Comment;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service
 * @Author Zhang Yang
 * @Date 9/1/22 10:46 AM
 * @Version V1.0
 */
public interface CommentService {
    List<Comment> allComment();

    boolean deleteComment(int userId);

    boolean addComment(Comment comment);

    List<Comment> commentOfSongId(int songId);

    List<Comment> commentOfSongListId(int songListId);

    boolean commentOfLike(Comment comment);

    boolean updateCommentMsg(Comment comment);
}
