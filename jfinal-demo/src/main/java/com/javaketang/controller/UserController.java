package com.javaketang.controller;

import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.log.Log;

import com.javaketang.interceptor.GlobalInerceptor;
import com.javaketang.model.User;
import com.javaketang.service.UserService;
import com.javaketang.validator.UserValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 用户控制器 render转发至页面，类似request中的转发，setAttr设置参数，类似转发携带的参数；redirect为重定向
 * 
 * @author ygj
 *
 */
// @Before(GlobalInerceptor.class) 配置拦截器
public class UserController extends Controller {

	// 创建用户服务
	UserService userService = UserService.userService;

	// 登录页面进入
	public void index() {
		render("login.html");
	}

	/**
	 * 登录时进行验证;
	 * 
	 * @Before注解：面向切面进行切入，类似spring中的AOP，在执行登录方法之前执行UserValidator验证类方法
	 */
	@Before(UserValidator.class)
	public void login() {

		// 获取参数用户名
		String userName = getPara("user.userName");

		// 获取参数密码
		String password = getPara("user.password");

		// 获取用户model
		User user = userService.login(userName, password);

		// 获取session对象
		HttpSession session = getSession();

		session.setAttribute("user", user);

		// 判断是否存在该用户
		if (user != null) {
			redirect("/");
		} else {
			setAttr("message", "用户名或密码错误");
			render("login.html");
		}
	}

	/**
	 * 注册
	 */
	@Before(UserValidator.class)
	public void register() {

		// 注册用户
		boolean flag = userService.register(getBean(User.class));

		if (flag) {

			redirect("/user");
		} else {
			setAttr("message", "注册失败，服务器发生错误");
		}

	}

	public void reg() {
		render("register.html");
	}

	public void back() {
		getSession().removeAttribute("user");
		redirect("/user");
	}
}
