package com.javaketang.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * 定义基本用户模型类，例如getset方法，通过jfinal生成
 * 
 * @author ygj
 *
 * @param <M>
 * @SuppressWarnings注解是禁止警告窗口
 */
@SuppressWarnings({ "serial", "unchecked" })
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	/**
	 * 设置id set方法
	 * 
	 * @param id
	 * @return
	 */
	public M setId(java.lang.Integer id) {
		// set方法是model模型类的，设置属性和传入的参数设值
		set("id", id);
		return (M) this;
	}

	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setUserName(java.lang.String userName) {

		set("userName", userName);

		return (M) this;
	}

	public java.lang.String getUserName() {

		return getStr("userName");
	}

	public M setPassword(java.lang.String password) {

		set("password", password);

		return (M) this;
	}

	public java.lang.String getPassword() {
		return getStr("password");
	}

	public M setGender(java.lang.String gender) {
		set("gender", gender);
		return (M) this;
	}

	public java.lang.String getGender() {

		return getStr("gender");
	}

	public M setPicUrl(java.lang.String picUrl) {

		set("picUrl", picUrl);
		return (M) this;
	}

	public java.lang.String getPicUrl() {
		return getStr("picUrl");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
		return (M) this;
	}

	public java.util.Date getCreateTime() {

		return getDate("createTime");
	}
}
