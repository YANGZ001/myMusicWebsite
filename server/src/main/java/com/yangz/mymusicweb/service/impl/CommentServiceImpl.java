package com.yangz.mymusicweb.service.impl;

import com.yangz.mymusicweb.dao.CommentMapper;
import com.yangz.mymusicweb.entity.Comment;
import com.yangz.mymusicweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package com.yangz.mymusicweb.service.impl
 * @Author Zhang Yang
 * @Date 9/1/22 10:46 AM
 * @Version V1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    @Override
    public boolean deleteComment(int id) {
        return commentMapper.deleteComment(id) > 0;
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.addComment(comment) > 0;
    }

    @Override
    public List<Comment> commentOfSongId(int songId) {
        return commentMapper.commentOfSongId(songId);
    }

    @Override
    public List<Comment> commentOfSongListId(int songListId) {
        return commentMapper.commentOfSongListId(songListId);
    }

    @Override
    public boolean commentOfLike(Comment comment) {
        return commentMapper.commentOfLike(comment) > 0;
    }

    @Override
    public boolean updateCommentMsg(Comment comment) {
        return commentMapper.updateCommentMsg(comment) > 0;
    }
}
