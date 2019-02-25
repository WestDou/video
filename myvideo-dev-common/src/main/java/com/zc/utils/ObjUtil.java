package com.zc.utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 对象操作工具类
 * @author: zhangcheng
 * @date: 2019年1月20日
 */
public class ObjUtil {
	private static Logger log = LoggerFactory.getLogger(ObjUtil.class);

	/**
	 * @Description: 对象自动映射
	 * @param obj1
	 *            原始对象
	 * @param obj2
	 *            待赋值对象
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public static void copy(Object obj1, Object obj2) {
		Class<? extends Object> obj1Class = obj1.getClass();
		Class<? extends Object> obj2Class = obj2.getClass();
		Field[] fields1 = obj1Class.getDeclaredFields();
		Field[] fields2 = obj2Class.getDeclaredFields();
		for (Field field1 : fields1) {
			for (Field field2 : fields2) {
				if (field1.getName().equals(field2.getName()) && !field1.getName().equals("serialVersionUID")) {
					try {
						field2.setAccessible(true);
						field1.setAccessible(true);
						field2.set(obj2, field1.get(obj1));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						log.error("{}", e);
					}
				}
			}
		}
	}
}
