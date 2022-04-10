package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//提高了该实现类的优先级，再通过getBean获取Bean时，会首先返回该Bean
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
