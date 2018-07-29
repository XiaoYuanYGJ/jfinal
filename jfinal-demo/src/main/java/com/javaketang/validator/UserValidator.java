package com.javaketang.validator;

import org.apache.log4j.Logger;

import com.javaketang.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 用户验证器
 * 
 * @author ygj
 *
 */
public class UserValidator extends Validator {

	private Logger log = Logger.getLogger(UserValidator.class);

	/**
	 * 验证用户表单数据
	 */
	protected void validate(Controller c) {
		// validateRequired(index, errorKey, errorMessage); 验证必填字段，参数1为int
		// index时，根据参数的角标区分；errorKey参数为提示信息变量名，用于在页面显示提示错误时使用；errorMessage参数表示提示的错误信息
		// validateRequired(field, errorKey, errorMessage); 验证必填字段，参数1位String
		// field时，根据参数名称区分，其他参数同上
		// form表单中参数名称都会取名为表名.字段名，这样才能进行数据封装并执行sql，不然数据不会被封装到对应的dao中
		validateRequiredString("user.userName", "userMsg", "用户名不能为空！");
		validateRequiredString("user.password", "pwdMsg", "密码不能为空！");
	
		// 注册时验证
		if (getActionKey().equals("/user/register")) {
			validateRequiredString("password2", "pwd2Msg", "确认密码不能为空！");
			validateEqualField("user.password", "password2", "pwdMsg", "两次密码不相同！");
 
		}
	}

	/**
	 * 验证参数失败时，通过getActionKey()方法获取请求的url地址，并跳转至相应的HTML页面
	 */
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub

		c.keepModel(User.class); // 保持用户模型

		// 获取请求url地址
		String actionKey = getActionKey();

		log.debug("用户请求验证url地址----》》》》" + actionKey);

		// 用户登录请求
		if (actionKey.equals("/user/login")) {
			controller.render("login.html");
		}

	}

}
