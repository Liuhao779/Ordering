package com.dcxt.backstage.service;

import com.dcxt.backstage.mapper.CommentMapper;
import com.dcxt.bean.CommentBean;
import com.dcxt.bean.ConsumeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by yyangcr on 17-11-11.
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    //获取所有的评论
    public ArrayList<CommentBean> getallcommentBean(){
       return  commentMapper.getallcommentBean();
    }

    //获取id一个评论
    public ConsumeBean getbyid(int id){
        return commentMapper.getbyid(id);
    }

    //更改评论
    public boolean updateCommentBean(CommentBean commentBean){
        return commentMapper.updateCommentBean(commentBean);
    }
    //添加评论
    public boolean addupdae(CommentBean commentBean){
        return commentMapper.addupdae(commentBean);
    }

}
