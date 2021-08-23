package com.dcxt.backstage.mapper;

import com.dcxt.bean.CommentBean;
import com.dcxt.bean.ConsumeBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * Created by yyangcr on 17-11-11.
 */
@Mapper
public interface CommentMapper {
    //获取所有的评论
    public ArrayList<CommentBean> getallcommentBean();

    //获取id一个评论
    public ConsumeBean getbyid(int id);

    //更改评论
    public boolean updateCommentBean(CommentBean commentBean);
    //添加评论
    public boolean addupdae(CommentBean commentBean);

}
