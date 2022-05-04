package com.nowcoder.community.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 写LoginTicketInterceptor时，需要用到cookie中存的ticket，
 * 尽管可以通过preHandle中提供的request参数获取cookie，但还是有点麻烦，
 * 所以另写一个小工具CookieUtil类封装一下这个功能
 */
public class CookieUtil {

    public static String getValue(HttpServletRequest request, String name){
        if(request == null || name == null){
            throw new IllegalArgumentException("参数为空！");
        }

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
