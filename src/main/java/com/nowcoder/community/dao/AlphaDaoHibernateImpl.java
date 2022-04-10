package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;
//必须添加Repository注解才能被容器扫描到
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{

    @Override
    public String select() {
        return "Hibernate";
    }
}
