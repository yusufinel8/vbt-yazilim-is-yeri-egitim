package com.springexercise.springexercise.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WorkerInterceptor implements HandlerInterceptor {


    private static Logger log = LoggerFactory.getLogger(WorkerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("PREHANDLEEEEEE");

       if(request.getMethod().equalsIgnoreCase("post")){
           return false;
       }

 boolean flag=false;

       String method=request.getMethod();

       if(method.equalsIgnoreCase("post")||method.equalsIgnoreCase("put")){
           String contentType=request.getContentType();
           if(contentType!=null && contentType.equalsIgnoreCase("application/json")){
               flag=false;
           }
       }
       if(!flag){
           response.sendRedirect("worker/Error");
       }


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("POSTHANDLEEEEEE");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("AFTERHANDLEEEEEE");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
