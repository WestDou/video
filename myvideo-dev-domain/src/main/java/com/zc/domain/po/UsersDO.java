package com.zc.domain.po;


import javax.persistence.Table;

/**
 * @createAuthor zhangcheng
 * @createDate 2019-01-12 15:07:05
 * @modifyAuthor zhangcheng
 * @modifyDate 2019-01-12 15:07:05
 */
@Table(name = "video_users")
public class UsersDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String faceImage;
	private String nickname;
	private Long fansCounts;
	private Long followCounts;
	private Long receiveLikeCounts;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFaceImage() {
		return faceImage;
	}
	public void setFaceImage(String faceImage) {
		this.faceImage = faceImage;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Long getFansCounts() {
		return fansCounts;
	}
	public void setFansCounts(Long fansCounts) {
		this.fansCounts = fansCounts;
	}
	public Long getFollowCounts() {
		return followCounts;
	}
	public void setFollowCounts(Long followCounts) {
		this.followCounts = followCounts;
	}
	public Long getReceiveLikeCounts() {
		return receiveLikeCounts;
	}
	public void setReceiveLikeCounts(Long receiveLikeCounts) {
		this.receiveLikeCounts = receiveLikeCounts;
	}
	@Override
	public String toString() {
		return "UsersDO [username=" + username + ", password=" + password + ", faceImage=" + faceImage + ", nickname="
				+ nickname + ", fansCounts=" + fansCounts + ", followCounts=" + followCounts + ", receiveLikeCounts="
				+ receiveLikeCounts + "]";
	}
	

}