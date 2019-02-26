/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : video-dev

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2019-02-26 13:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for video_bgm
-- ----------------------------
DROP TABLE IF EXISTS `video_bgm`;
CREATE TABLE `video_bgm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(64) NOT NULL,
  `path` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video_comments
-- ----------------------------
DROP TABLE IF EXISTS `video_comments`;
CREATE TABLE `video_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) NOT NULL,
  `from_user_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `create_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video_search_records
-- ----------------------------
DROP TABLE IF EXISTS `video_search_records`;
CREATE TABLE `video_search_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video_users
-- ----------------------------
DROP TABLE IF EXISTS `video_users`;
CREATE TABLE `video_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `face_image` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) NOT NULL,
  `fans_counts` bigint(20) NOT NULL,
  `follow_counts` bigint(20) NOT NULL,
  `receive_like_counts` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video_users_fans
-- ----------------------------
DROP TABLE IF EXISTS `video_users_fans`;
CREATE TABLE `video_users_fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fan_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video_users_likes_videos
-- ----------------------------
DROP TABLE IF EXISTS `video_users_likes_videos`;
CREATE TABLE `video_users_likes_videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `video_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video_users_report
-- ----------------------------
DROP TABLE IF EXISTS `video_users_report`;
CREATE TABLE `video_users_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deal_user_id` int(11) NOT NULL,
  `deal_video_id` int(11) NOT NULL,
  `title` varchar(128) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video_videos
-- ----------------------------
DROP TABLE IF EXISTS `video_videos`;
CREATE TABLE `video_videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `audio_id` int(11) DEFAULT NULL,
  `video_desc` varchar(128) DEFAULT NULL,
  `video_path` varchar(255) NOT NULL,
  `video_seconds` float(6,2) DEFAULT NULL,
  `video_width` int(6) DEFAULT NULL,
  `video_height` int(6) DEFAULT NULL,
  `cover_path` varchar(255) NOT NULL,
  `like_counts` bigint(20) NOT NULL,
  `status` int(1) NOT NULL,
  `create_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
