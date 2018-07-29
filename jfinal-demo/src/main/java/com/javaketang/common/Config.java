package com.javaketang.common;

import com.javaketang.controller.BaseController;
import com.javaketang.controller.UserController;
import com.javaketang.interceptor.GlobalInerceptor;
import com.javaketang.mapping.MappingKit;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/**
 * jfinal环境配置
 * 
 * @author ygj
 *
 */
public class Config extends JFinalConfig {

	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 使用PropKit对象读取配置文件
		PropKit.use("base_config.txt");

		// 设置开发模式
		me.setDevMode(PropKit.getBoolean("devMode"));

	}

	/**
	 * 配置路由;配置显示的地址
	 */
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		// 第三个参数为该Controller的视图存放路径;第一个参数为访问url，如果为业务逻辑url时，访问其方法需在后面加上--/方法名；例如：/user/reg
		me.add("/", BaseController.class);
		me.add("/user", UserController.class, "/view/user_view");
	}

	/**
	 * 配置模板
	 */
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
	}

	/**
	 * 配置插件，例如数据库连接
	 */
	public void configPlugin(Plugins me) {
		// 配置 druid 数据库连接池插件
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
		me.add(druidPlugin);

		// 配置ActiveRecord插件，用于建立数据库表名到model模型的映射关系
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 将所有映射在MappingKit类中完成，也可以写在这里完成映射
		MappingKit.mapping(arp);
		me.add(arp);
	}

	/**
	 * 配置拦截器
	 */
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		// 设置全局拦截器，用于在模板中使用#(session.key)
		me.add(new SessionInViewInterceptor());
		
		// 设置全局未登录拦截器
		me.add(new GlobalInerceptor());
		
	}

	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// 这里为配置请求时访问地址和端口号；第一个参数为模板所在项目位置；第二个参数为端口号；第三个为访问地址；第四个参数为设置扫面起间隔的时间
		JFinal.start("src/main/webapp", 8080, "/", 5);
		
	}
	
}
