package com.zc.domain.dto;


import javax.persistence.Table;

/**
 * @createAuthor zhangcheng
 * @createDate 2019-02-11 15:37:57
 * @modifyAuthor zhangcheng
 * @modifyDate 2019-02-11 15:37:57
 */
@Table(name = "video_videos")
public class VideosDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private Integer audioId;
	private String videoDesc;
	private String videoPath;
	
	private Double videoSeconds;
	private Integer videoWidth;
	private Integer videoHeight;
	private String coverPath;
	private Long likeCounts;
	private Integer status;
	private Long createTime;

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAudioId() {
		return audioId;
	}
	public void setAudioId(Integer audioId) {
		this.audioId = audioId;
	}
	public String getVideoDesc() {
		return videoDesc;
	}
	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	public Double getVideoSeconds() {
		return videoSeconds;
	}
	public void setVideoSeconds(Double videoSeconds) {
		this.videoSeconds = videoSeconds;
	}
	public Integer getVideoWidth() {
		return videoWidth;
	}
	public void setVideoWidth(Integer videoWidth) {
		this.videoWidth = videoWidth;
	}
	public Integer getVideoHeight() {
		return videoHeight;
	}
	public void setVideoHeight(Integer videoHeight) {
		this.videoHeight = videoHeight;
	}
	public String getCoverPath() {
		return coverPath;
	}
	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}
	public Long getLikeCounts() {
		return likeCounts;
	}
	public void setLikeCounts(Long likeCounts) {
		this.likeCounts = likeCounts;
	}
	

}