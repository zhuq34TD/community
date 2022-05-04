package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * 生成随机字符串
 * 比较简单，不托管给IOC容器了，需要的时候直接调用
 */
public class CommunityUtil {

    // 封装生成随机字符串的功能
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5加密，不可逆，并且一样的字符串每次加密结果都是一样的，因此安全性较低
    // hello -> abc123def456
    // 因此在密码后拼接一个随机字符串，对此进行加密
    // hello + 1a3e4r -> abc123def456qwe
    public static String md5(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }else {
            return DigestUtils.md5DigestAsHex(key.getBytes());
        }
    }

}
