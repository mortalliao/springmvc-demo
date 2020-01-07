package com.springmvc.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptor1 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截器MyHandlerInterceptor1的preHandle前置方法。");
		//如果返回为false的话，将不再继续执行后续的拦截器包括处理器，如果为true则继续执行后续拦截器或者直接到处理器
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//如果上述的preHandle方法返回true的话则执行；否则不再执行postHandle方法
		System.out.println("拦截器MyHandlerInterceptor1的postHandle后置方法。");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//如果上述的preHandle方法返回true的话必定执行 完成方法
		System.out.println("拦截器MyHandlerInterceptor1的afterCompletion完成方法。");
	}

}
