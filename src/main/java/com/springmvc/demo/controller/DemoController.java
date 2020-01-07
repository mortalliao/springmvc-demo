package com.springmvc.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.model.User;
import com.springmvc.demo.model.UserForm;

@RequestMapping("/demo")
@Controller
public class DemoController {

	@RequestMapping("/show1")
	public ModelAndView show1() {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show1");

		return mv;
	}

	@RequestMapping("/*/show2")
	public ModelAndView show2() {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show2");

		return mv;
	}

	@RequestMapping("/show3/{userId}")
	public ModelAndView show3(@PathVariable("userId") Long userId) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show3；userId=" + userId);

		return mv;
	}

	@RequestMapping(value = "/show4", method = RequestMethod.GET)
	public ModelAndView show4() {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show4；请求方法只能为get");

		return mv;
	}

	//请求的路径中必须携带userId和userName，并且userId的值必须为1
	@RequestMapping(value = "/show5", params = { "userId=1", "userName" })
	public ModelAndView show5() {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show5；必须携带参数名称为userId的请求参数");

		return mv;
	}

	@RequestMapping(value = "/show6")
	public ModelAndView show6(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test2");

		StringBuilder sb = new StringBuilder();
		sb.append("request = ").append(request).append("response = ").append(response).append("session = ")
				.append(session);

		request.setAttribute("data", "这是request中的数据。");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show6；" + sb.toString());

		return mv;
	}

	@RequestMapping("/show7/{userId}/{userName}")
	public ModelAndView show7(@PathVariable("userId") Long userId, @PathVariable("userName") String userName) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show7；userId=" + userId + "；userName=" + userName);

		return mv;
	}

	//@RequestParam属性required默认值true
	@RequestMapping("/show8")
	public ModelAndView show8(@RequestParam(value = "userId", required = true, defaultValue = "itcast") String userId) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show8；userId=" + userId);

		return mv;
	}

	@RequestMapping("/show9")
	public ModelAndView show9(@CookieValue(value = "itcastCK", defaultValue = "-1") String itcastCK,
			@CookieValue(value = "JSESSIONID", required = false) String sessionId, HttpServletResponse response) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		//写cookie
		Cookie cookie = new Cookie("itcastCK", "itcat");
		response.addCookie(cookie);

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show9；sessionId=" + sessionId + "；itcastCK = " + itcastCK);

		return mv;
	}

	@RequestMapping("/show10")
	public ModelAndView show10(User user) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show10；user=" + user);

		return mv;
	}

	@RequestMapping("/show11")
	public ModelAndView show11(@RequestParam("name") String name, @RequestParam("age") Integer age,
			@RequestParam("gender") Boolean gender, @RequestParam("interests") String[] interests) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		StringBuilder sb = new StringBuilder();
		sb.append("名称：").append(name).append("</br>").append("年龄：").append(age).append("</br>").append("性别：")
				.append(gender).append("</br>").append("兴趣：");
		for (String its : interests) {
			sb.append(its).append("，");
		}

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show11；表单数据为：" + sb.toString());

		return mv;
	}

	@RequestMapping("/show12")
	public ModelAndView show12(UserForm userForm) {
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		StringBuilder sb = new StringBuilder();
		for (User user : userForm.getUsers()) {
			sb.append(user).append("</br>");
		}

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show12；用户列表数据为：" + sb.toString());

		return mv;
	}

	@RequestMapping("/show13")
	public ModelAndView show13() {//带参数的转发
		//创建一个模型视图对象，并指定视图名称为test
		//forward: 表示不需要视图解析器拼接视图路径，而直接转发到该视图（包含地址和名称和后缀的）
		ModelAndView mv = new ModelAndView("forward:/test.jsp");

		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法为：show13。转发到jsp页面");

		return mv;
	}

	@RequestMapping("/show13_1")
	public String show13_1() {//不带参数的做法
		return "forward:/test.jsp";
	}

	@RequestMapping("/show14")
	public ModelAndView show14() {//带参数的重定向
		//创建一个模型视图对象，并指定视图名称为test
		//redirect: 表示不需要视图解析器拼接视图路径，而直接某个地址
		//ModelAndView mv = new ModelAndView("redirect:/testRedirect.mvc");//springmvc/testRedirect.mvc
		ModelAndView mv = new ModelAndView("redirect:testRedirect.mvc");//springmvc/demo/testRedirect.mvc

		try {
			mv.addObject("requestType",
					URLEncoder.encode("这是我的第一个注解spring mvc应用。方法为：show14。测试重定向到testRedirect。", "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/show14_1")
	public String show14_1() {//不带参数的重定向
		return "redirect:testRedirect.mvc";
	}

	@RequestMapping("/testRedirect")
	public ModelAndView testRedirect(@RequestParam(value = "requestType", required = false) String requestType) {

		ModelAndView mv = new ModelAndView("test");
		if (requestType != null && !"".equals(requestType)) {
			try {
				requestType = URLDecoder.decode(requestType, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			mv.addObject("msg", "方法为：testRedirect；参数内容为：" + requestType);
		}

		return mv;
	}

	@RequestMapping("/show15")
	public ModelAndView show15(@RequestBody User user) {//将json字符串转换为java对象
		//创建一个模型视图对象，并指定视图名称为test
		ModelAndView mv = new ModelAndView("test");

		mv.addObject("msg", user);

		return mv;
	}

	@RequestMapping("/show16")
	@ResponseBody
	public List<User> show16() {//将java对象转换为json格式字符串并输出
		List<User> userList = new ArrayList<User>();
		for (long i = 1; i < 11; i++) {
			User user = new User();
			user.setId(i);
			user.setBirthday(new Date());
			user.setName("传智播客 " + i);
			user.setGender(i % 2 == 0);
			userList.add(user);
		}

		return userList;
	}

}
