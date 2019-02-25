package com.zc.en;
/** 
 * @Description: TODO
 * @author: zhangcheng
 * @date: 2019年2月12日 
 */
public enum Video {
	
	Available(1),//可看视频
	Unavailable(0);//冻结的视频
	
	private Integer value;
	
	Video(Integer value){
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	
	
	

}
