package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // 访问数据库，返回的是多条评论，所以需要一个集合变量来存放
    // offset起始行号   limit最多显示多少条数据
    // 动态传参详见xxx-mapper
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // 分多少页 = 总数据行数/每页显示的数据数
    // @Param注解用于给参数取别名
    // 如果只有一个参数，并且在<if>（动态判断sql标识）里使用，就必须要取别名
    int selectDiscussPostRows(@Param("userId") int userId);

}
