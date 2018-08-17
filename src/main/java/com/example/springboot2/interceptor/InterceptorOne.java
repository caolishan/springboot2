package com.example.springboot2.interceptor;

import com.example.springboot2.model.User;
import com.example.springboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class InterceptorOne implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandler");
        User user =new User();
        user.setName("Jack Ma");
//        userService.add(user);
       if (handler instanceof HandlerMethod){
           HandlerMethod h1 = (HandlerMethod) handler;
           Object bean = h1.getBean();
           System.out.println(bean.getClass());
           Method method = h1.getMethod();
           System.out.println(method.getName());
           MethodParameter[] methodParameters = h1.getMethodParameters();
           for (MethodParameter methodParameter : methodParameters) {
               String parameterName = methodParameter.getParameterName();
               System.out.println(parameterName);
               System.out.println(methodParameter.getParameterType());
           }
       }
        System.out.println(user.toString());
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("post handle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("after Completion");
    }



}
