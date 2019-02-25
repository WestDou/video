package com.zc.domain.vo;
/** 
 * @Description: 自定义响应数据结构
 * 				200：表示成功
 *				500：表示错误，错误信息在msg字段中
 *				
 * 				 
 * @author: zhangcheng
 * @date: 2019年1月12日 
 */
public class ResultVO {

	private Integer status;
	private String msg;
	private Object data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResultVO(Integer status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public ResultVO() {
		super();
	}
	
	
}
