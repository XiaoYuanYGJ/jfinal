package com.javaketang.service;

import org.apache.log4j.Logger;

import com.javaketang.model.Native;
import com.jfinal.aop.Enhancer;

/**
 * 公告服务类，将所有sql与业务逻辑都编写在service中，不建议放在model中
 * 
 * @author ygj
 *
 */
public class NativeService {

	// 创建日志对象
	private Logger log = Logger.getLogger(NativeService.class);

	// 设置nativeService服务对象变量，方便在任何地方调用；也可以通过jfinal提供的Enhancer.enhance(Class)创建
	public static final NativeService nativeService = Enhancer.enhance(NativeService.class);

	/**
	 * 创建用户model类或者为公告数据访问类，只使用在service中，避免在每个地方都创建，导致冗余
	 */
	private Native nativeDao = new Native().dao();
	
	
	
}
