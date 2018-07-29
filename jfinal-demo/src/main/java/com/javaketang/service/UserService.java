package com.javaketang.service;

import org.apache.log4j.Logger;

import com.javaketang.model.User;

/**
 * 用户服务类，将所有sql与业务逻辑都编写在service中，不建议放在model中
 * 
 * @author ygj
 *
 */
public class UserService {

	// 创建log对象
	private Logger log = Logger.getLogger(UserService.class);

	/**
	 * 设置userService服务对象变量，方便在任何地方调用；也可以通过jfinal提供的Enhancer.enhance(Class)创建
	 */
	public static final UserService userService = new UserService();

	/**
	 * 创建用户model类或者为用户数据访问类，只使用在service中，避免在每个地方都创建，导致冗余
	 */
	private User userDao = new User().dao();

	/**
	 * 登录方法
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User login(String userName, String password) {

		log.debug("传入的参数---》》》" + userName + ",---->>>>>" + password);

		// findFirst是查询单条数据
		User user = userDao.findFirst("select id,userName,gender,picUrl,createTime from user where userName='"
				+ userName + "' and password='" + password + "'");

		log.debug("登录时查询出来的用户模型------》》》》》" + user);

		return user;
	}

	/**
	 * 注册方法
	 * 
	 * @param user
	 * @return
	 */
	public boolean register(User user) {

		return user.save();
	}

	/**
	 * 修改用户方法
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(User user) {

		return user.update();
	}

	/**
	 * 根据编号删除用户
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id) {
		return userDao.deleteById(id);
	}

	public User findById(int id) {
		return userDao.findById(id);
	}

}
