package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * 例子
 */
@Configuration
public class AlphaConfig {

    //通过Bean注解，该方法返回的对象将被注入容器中，方法名就是该Bean的名字
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
