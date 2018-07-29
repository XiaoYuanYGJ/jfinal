package com.javaketang.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * 公告基本模型
 * 
 * @author ygj
 *
 * @param <M>
 */
@SuppressWarnings({ "serial", "unchecked" })
public class BaseNative<M extends BaseNative<M>> extends Model<M>implements IBean {

	public M setNId(java.lang.Integer nId) {
		set("nId", nId);
		return (M) this;
	}

	public java.lang.Integer getNId() {
		return getInt("nId");
	}

	public M setUId(java.lang.Integer uId) {
		set("uId", uId);
		return (M) this;
	}

	public java.lang.Integer getUId() {
		return getInt("uId");
	}

	public M setNTitle(java.lang.String nTitle) {
		set("nTitle", nTitle);
		return (M) this;
	}

	public java.lang.Integer getNTitle() {
		return getInt("nTitle");
	}

	public M setNContent(java.lang.String nContent) {
		set("nContent", nContent);
		return (M) this;
	}

	public java.lang.String getNContent() {
		return getStr("nContent");
	}

	public M setNPicpath(java.lang.String nPicpath) {
		set("nPicpath", nPicpath);
		return (M) this;
	}

	public java.lang.String getNPicpath() {
		return getStr("nPicpath");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
		return (M) this;
	}

	public java.util.Date getCreateTime() {
		return getDate("createTime");
	}
}
