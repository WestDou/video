package com.zc.domain.util;
/** 
 * @Description: 返回结果工具类
 * @author: zhangcheng
 * @date: 2019年1月12日 
 */

import com.zc.domain.vo.ResultVO;

public class ResultUtil {

	public static ResultVO ok() {
		return new ResultVO(200, "操作成功", null);
	}

	public static ResultVO ok(final Object data) {
		return new ResultVO(200, "操作成功", data);
	}

	public static ResultVO ok(final Object data, final String msg) {
		return new ResultVO(200, msg, data);
	}

	public static ResultVO errorMsg(final String msg) {
		return new ResultVO(500, msg, null);
	}
}
