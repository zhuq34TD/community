package com.nowcoder.community.controller.interceptor;

import com.nowcoder.community.annotation.LoginRequired;
import com.nowcoder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器，实现拦截未登录状态下的非法请求功能
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果不是映射到方法上，直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        // MVC提供的方法，如果拦截到的是方法，默认是HandlerMethod类型

        // 为了便于操作，确认handler是HandlerMethod之后可以将其强转为HandlerMethod类型
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取它拦截到的方法对象
        Method method = handlerMethod.getMethod();
        // 从方法对象上取得它的注解
        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        // 判断。如果该方法有这个注解，且没有登录，就拒绝请求，强制重定向到登录页面
        if(loginRequired != null && hostHolder.getUser() == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}
