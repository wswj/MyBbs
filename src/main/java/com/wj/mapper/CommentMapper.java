package com.wj.mapper;

import com.wj.pojo.Comment;
import com.wj.pojo.CommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    //根据fid帖子id获得评论
    List<Comment> selectByFid(int fid);
    //按userid查询评论信息
    List<Comment> selectCommentByUserid(int userid);
    //按fid删除对应帖子的评论信息
    Integer deleteCommentByFid(int fid);
    //添加评论
    Integer insertComment(Comment comment);
    //删除评论通过fid
    Integer deleteByPid(int pid);
    //管理员删除用户时删除该用户的评论信息
    Integer deleteByUserid(int userid);
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}