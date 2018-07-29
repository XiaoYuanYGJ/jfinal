package com.javaketang.mapping;

import com.javaketang.model.Native;
import com.javaketang.model.User;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * 映射工具类；有jfinal自动生成model模型;可以在config配置类中编写
 * 
 * @author ygj
 *
 */
public class MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("user", "id", User.class);
		// 此方法用于建立数据库表名到model类的关系映射
		// 参数填写：表名，主键字段，模型类
		// 默认的主键字段为id，如果在设置数据库表时注解字段id时可以不用填写
		arp.addMapping("native", "nId", Native.class);
	}

}
