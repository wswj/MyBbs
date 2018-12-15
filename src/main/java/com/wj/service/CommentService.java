package com.wj.service;

import com.wj.mapper.CommentMapper;
import com.wj.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    public List<Comment> getCommentByFid(int fid){
        return commentMapper.selectByFid(fid);
    }
    public List<Comment> getCommentByUserid(int userid){
        return commentMapper.selectCommentByUserid(userid);
    }
    public void deleteCommentByFid(int fid){
        commentMapper.deleteCommentByFid(fid);
    }
    //添加帖子
    public void setComment(Comment comment){
        commentMapper.insertComment(comment);
    }
    //根据帖子id（fid）删除
    public void deleteByPid(int pid){
        commentMapper.deleteByPid(pid);
    }
    //删除用户时删除该用户的评论信息
    public void deleteComment(int userid){commentMapper.deleteByUserid(userid);}

}
