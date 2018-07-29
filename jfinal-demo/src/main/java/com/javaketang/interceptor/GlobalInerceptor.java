package com.javaketang.interceptor;

import javax.servlet.http.HttpSession;

import org.xml.sax.SAXException;

import com.javaketang.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * 全局拦截器；先用于拦截未登录用户
 * 
 * @author ygj
 *
 */
public class GlobalInerceptor implements Interceptor {

	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub

		// 获取请求地址
		String actionKey = inv.getActionKey();

		// 获取控制类
		Controller contro = inv.getController();

		// 获取session
		HttpSession session = contro.getSession();

		// 获取用户model模型
		User user = session.getAttribute("user") == null ? null : (User) session.getAttribute("user");

		// 判断用户模型为空时，将进行拦截
		if (user == null) {
			// 不为用户界面操作时，跳转至登录页面
			if (actionKey.indexOf("/user") == -1) {
				contro.setAttr("message", "请先登录，才能进入系统");
				contro.render("/view/user_view/login.html");
				return;
			}
		}
		inv.invoke();
	}

}
