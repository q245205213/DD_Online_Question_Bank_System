/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : problem_base

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-10-07 15:45:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `adminAccount` varchar(25) DEFAULT NULL,
  `adminPassword` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `colID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `queID` int(11) DEFAULT NULL,
  PRIMARY KEY (`colID`),
  KEY `FK_collection_question` (`queID`) USING BTREE,
  KEY `FK_collection_user_1` (`userID`),
  CONSTRAINT `FK_collection_question_1` FOREIGN KEY (`queID`) REFERENCES `question` (`queID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_collection_user_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('43', '460', '86');
INSERT INTO `collection` VALUES ('44', '460', '100');
INSERT INTO `collection` VALUES ('45', '460', '99');
INSERT INTO `collection` VALUES ('46', '462', '97');
INSERT INTO `collection` VALUES ('48', '462', '99');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `queID` int(11) DEFAULT NULL,
  `comContent` varchar(255) DEFAULT NULL,
  `comScore` int(1) DEFAULT NULL,
  PRIMARY KEY (`comID`),
  KEY `FK_comment_question` (`queID`) USING BTREE,
  KEY `FK_comment_user_1` (`userID`),
  CONSTRAINT `FK_comment_question_1` FOREIGN KEY (`queID`) REFERENCES `question` (`queID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_comment_user_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('16', '460', '86', 'f ', '4');
INSERT INTO `comment` VALUES ('17', '460', '97', '这题还不错，自顶', '5');
INSERT INTO `comment` VALUES ('18', '462', '97', '看来还可以', '5');
INSERT INTO `comment` VALUES ('19', '462', '100', '漂亮的题目', '5');
INSERT INTO `comment` VALUES ('20', '462', '99', '这题目还可以呀', '5');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `groupID` int(11) NOT NULL AUTO_INCREMENT,
  `group1` varchar(10) DEFAULT NULL,
  `group2` varchar(20) DEFAULT NULL,
  `group3` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`groupID`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('1', '小学', '一年级', '语文');
INSERT INTO `group` VALUES ('3', '小学', '一年级', '英语');
INSERT INTO `group` VALUES ('4', '小学', '一年级', '数学');
INSERT INTO `group` VALUES ('5', '小学', '一年级', '思想品德');
INSERT INTO `group` VALUES ('6', '小学', '二年级', '语文');
INSERT INTO `group` VALUES ('7', '小学', '二年级', '数学');
INSERT INTO `group` VALUES ('8', '小学', '二年级', '英语');
INSERT INTO `group` VALUES ('9', '小学', '二年级', '思想品德');
INSERT INTO `group` VALUES ('10', '小学', '三年级', '语文');
INSERT INTO `group` VALUES ('11', '小学', '三年级', '数学');
INSERT INTO `group` VALUES ('12', '小学', '三年级', '英语');
INSERT INTO `group` VALUES ('13', '小学', '三年级', '思想品德');
INSERT INTO `group` VALUES ('14', '小学', '四年级', '语文');
INSERT INTO `group` VALUES ('15', '小学', '四年级', '数学');
INSERT INTO `group` VALUES ('16', '小学', '四年级', '英语');
INSERT INTO `group` VALUES ('17', '小学', '四年级', '思想品德');
INSERT INTO `group` VALUES ('18', '小学', '五年级', '语文');
INSERT INTO `group` VALUES ('19', '小学', '五年级', '数学');
INSERT INTO `group` VALUES ('20', '小学', '五年级', '英语');
INSERT INTO `group` VALUES ('21', '小学', '五年级', '思想品德');
INSERT INTO `group` VALUES ('22', '小学', '六年级', '语文');
INSERT INTO `group` VALUES ('23', '小学', '六年级', '数学');
INSERT INTO `group` VALUES ('24', '小学', '六年级', '英语');
INSERT INTO `group` VALUES ('25', '小学', '六年级', '思想品德');
INSERT INTO `group` VALUES ('26', '中学', '初一', '语文');
INSERT INTO `group` VALUES ('27', '中学', '初一', '数学');
INSERT INTO `group` VALUES ('28', '中学', '初一', '英语');
INSERT INTO `group` VALUES ('29', '中学', '初一', '物理');
INSERT INTO `group` VALUES ('30', '中学', '初一', '化学');
INSERT INTO `group` VALUES ('31', '中学', '初一', '生物');
INSERT INTO `group` VALUES ('32', '中学', '初一', '政治');
INSERT INTO `group` VALUES ('33', '中学', '初一', '历史');
INSERT INTO `group` VALUES ('34', '中学', '初一', '地理');
INSERT INTO `group` VALUES ('35', '中学', '初二', '语文');
INSERT INTO `group` VALUES ('36', '中学', '初二', '数学');
INSERT INTO `group` VALUES ('37', '中学', '初二', '英语');
INSERT INTO `group` VALUES ('38', '中学', '初二', '物理');
INSERT INTO `group` VALUES ('39', '中学', '初二', '化学');
INSERT INTO `group` VALUES ('40', '中学', '初二', '生物');
INSERT INTO `group` VALUES ('41', '中学', '初二', '政治');
INSERT INTO `group` VALUES ('42', '中学', '初二', '历史');
INSERT INTO `group` VALUES ('43', '中学', '初二', '地理');
INSERT INTO `group` VALUES ('44', '中学', '初三', '语文');
INSERT INTO `group` VALUES ('45', '中学', '初三', '数学');
INSERT INTO `group` VALUES ('46', '中学', '初三', '英语');
INSERT INTO `group` VALUES ('47', '中学', '初三', '物理');
INSERT INTO `group` VALUES ('48', '中学', '初三', '化学');
INSERT INTO `group` VALUES ('49', '中学', '初三', '生物');
INSERT INTO `group` VALUES ('50', '中学', '初三', '政治');
INSERT INTO `group` VALUES ('51', '中学', '初三', '历史');
INSERT INTO `group` VALUES ('52', '中学', '初三', '地理');
INSERT INTO `group` VALUES ('53', '中学', '高一', '语文');
INSERT INTO `group` VALUES ('54', '中学', '高一', '数学');
INSERT INTO `group` VALUES ('55', '中学', '高一', '英语');
INSERT INTO `group` VALUES ('56', '中学', '高一', '物理');
INSERT INTO `group` VALUES ('57', '中学', '高一', '化学');
INSERT INTO `group` VALUES ('58', '中学', '高一', '生物');
INSERT INTO `group` VALUES ('59', '中学', '高一', '政治');
INSERT INTO `group` VALUES ('60', '中学', '高一', '历史');
INSERT INTO `group` VALUES ('61', '中学', '高一', '地理');
INSERT INTO `group` VALUES ('62', '中学', '高二', '语文');
INSERT INTO `group` VALUES ('63', '中学', '高二', '数学');
INSERT INTO `group` VALUES ('64', '中学', '高二', '英语');
INSERT INTO `group` VALUES ('65', '中学', '高二', '物理');
INSERT INTO `group` VALUES ('66', '中学', '高二', '化学');
INSERT INTO `group` VALUES ('67', '中学', '高二', '生物');
INSERT INTO `group` VALUES ('68', '中学', '高二', '政治');
INSERT INTO `group` VALUES ('69', '中学', '高二', '历史');
INSERT INTO `group` VALUES ('70', '中学', '高二', '地理');
INSERT INTO `group` VALUES ('71', '中学', '高三', '语文');
INSERT INTO `group` VALUES ('72', '中学', '高三', '数学');
INSERT INTO `group` VALUES ('73', '中学', '高三', '英语');
INSERT INTO `group` VALUES ('74', '中学', '高三', '物理');
INSERT INTO `group` VALUES ('75', '中学', '高三', '化学');
INSERT INTO `group` VALUES ('76', '中学', '高三', '生物');
INSERT INTO `group` VALUES ('77', '中学', '高三', '政治');
INSERT INTO `group` VALUES ('78', '中学', '高三', '历史');
INSERT INTO `group` VALUES ('79', '中学', '高三', '地理');
INSERT INTO `group` VALUES ('80', '大学', '大学必修课', '军事理论');
INSERT INTO `group` VALUES ('81', '大学', '大学必修课', '中国近现代史纲要');
INSERT INTO `group` VALUES ('82', '大学', '大学必修课', '思想道德修养与法律基础');
INSERT INTO `group` VALUES ('83', '大学', '大学必修课', '高等数学');
INSERT INTO `group` VALUES ('84', '大学', '大学必修课', '大学英语');
INSERT INTO `group` VALUES ('85', '大学', '大学必修课', '计算机文化基础');
INSERT INTO `group` VALUES ('86', '大学', '大学必修课', '马克思主义基本原理');
INSERT INTO `group` VALUES ('87', '大学', '大学必修课', '力学与热学');
INSERT INTO `group` VALUES ('88', '大学', '大学必修课', '大学物理－基础实验');
INSERT INTO `group` VALUES ('89', '大学', '大学必修课', '毛泽东思想概论');
INSERT INTO `group` VALUES ('90', '大学', '信息科学与工程学院', 'C语言');
INSERT INTO `group` VALUES ('91', '大学', '信息科学与工程学院', 'C++');
INSERT INTO `group` VALUES ('92', '大学', '信息科学与工程学院', 'Java');
INSERT INTO `group` VALUES ('93', '大学', '信息科学与工程学院', '高等数学');
INSERT INTO `group` VALUES ('94', '大学', '信息科学与工程学院', '线性代数');
INSERT INTO `group` VALUES ('95', '大学', '信息科学与工程学院', '离散数学');
INSERT INTO `group` VALUES ('96', '大学', '信息科学与工程学院', '概率统计');
INSERT INTO `group` VALUES ('97', '大学', '信息科学与工程学院', '数据库系统');
INSERT INTO `group` VALUES ('98', '大学', '信息科学与工程学院', '计算机组成原理');
INSERT INTO `group` VALUES ('99', '大学', '信息科学与工程学院', '计算机网络');
INSERT INTO `group` VALUES ('100', '大学', '信息科学与工程学院', '面向对象程序设计');
INSERT INTO `group` VALUES ('101', '大学', '信息科学与工程学院', '软件工程');
INSERT INTO `group` VALUES ('102', '大学', '经济管理学院', '政治经济学');
INSERT INTO `group` VALUES ('103', '大学', '经济管理学院', '微观经济学');
INSERT INTO `group` VALUES ('104', '大学', '经济管理学院', '宏观经济学');
INSERT INTO `group` VALUES ('105', '大学', '经济管理学院', '统计学');
INSERT INTO `group` VALUES ('106', '大学', '经济管理学院', '会计学');
INSERT INTO `group` VALUES ('107', '大学', '经济管理学院', '市场营销学');
INSERT INTO `group` VALUES ('108', '大学', '经济管理学院', '商品学');
INSERT INTO `group` VALUES ('109', '大学', '经济管理学院', '生产管理');
INSERT INTO `group` VALUES ('110', '大学', '经济管理学院', '质量管理');
INSERT INTO `group` VALUES ('111', '大学', '经济管理学院', '企业财务管理');
INSERT INTO `group` VALUES ('112', '大学', '经济管理学院', '涉外企业管理');
INSERT INTO `group` VALUES ('113', '大学', '经济管理学院', '管理会计');
INSERT INTO `group` VALUES ('114', '大学', '生命科学学院', '无机化学');
INSERT INTO `group` VALUES ('115', '大学', '生命科学学院', '有机化学');
INSERT INTO `group` VALUES ('116', '大学', '生命科学学院', '计算机应用');
INSERT INTO `group` VALUES ('117', '大学', '生命科学学院', '植物学');
INSERT INTO `group` VALUES ('118', '大学', '生命科学学院', '动物学');
INSERT INTO `group` VALUES ('119', '大学', '生命科学学院', '生物化学');
INSERT INTO `group` VALUES ('120', '大学', '生命科学学院', '植物生理学');
INSERT INTO `group` VALUES ('121', '大学', '生命科学学院', '遗传学');
INSERT INTO `group` VALUES ('122', '大学', '生命科学学院', '微生物学');
INSERT INTO `group` VALUES ('123', '大学', '生命科学学院', '细胞生物学');
INSERT INTO `group` VALUES ('124', '大学', '生命科学学院', '基因工程');
INSERT INTO `group` VALUES ('125', '大学', '工程学院 ', '工程图学');
INSERT INTO `group` VALUES ('126', '大学', '工程学院 ', '工程力学');
INSERT INTO `group` VALUES ('127', '大学', '工程学院 ', '机械设计');
INSERT INTO `group` VALUES ('128', '大学', '工程学院 ', '电工及电子技术');
INSERT INTO `group` VALUES ('129', '大学', '工程学院 ', '计算机应用及程序设计');
INSERT INTO `group` VALUES ('130', '大学', '工程学院 ', '汽车构造及理论');
INSERT INTO `group` VALUES ('131', '大学', '工程学院 ', '汽车运用工程');
INSERT INTO `group` VALUES ('132', '大学', '工程学院 ', '现代汽车新技术');
INSERT INTO `group` VALUES ('133', '大学', '工程学院 ', '交通运输企业经营管理');
INSERT INTO `group` VALUES ('134', '大学', '工程学院 ', '交通服务工程');
INSERT INTO `group` VALUES ('135', '大学', '工程学院 ', '交通运输学');
INSERT INTO `group` VALUES ('136', '大学', '工程学院 ', '交通运输规划');
INSERT INTO `group` VALUES ('137', '大学', '人文与法学学院', '法学基础理论');
INSERT INTO `group` VALUES ('138', '大学', '人文与法学学院', '中国法律史');
INSERT INTO `group` VALUES ('139', '大学', '人文与法学学院', '中国宪法');
INSERT INTO `group` VALUES ('140', '大学', '人文与法学学院', '行政法');
INSERT INTO `group` VALUES ('141', '大学', '人文与法学学院', '民法');
INSERT INTO `group` VALUES ('142', '大学', '人文与法学学院', '刑法');
INSERT INTO `group` VALUES ('143', '大学', '人文与法学学院', '合同法');
INSERT INTO `group` VALUES ('144', '大学', '人文与法学学院', '国际法');
INSERT INTO `group` VALUES ('145', '大学', '人文与法学学院', '经济法');
INSERT INTO `group` VALUES ('146', '大学', '人文与法学学院', '知识产权法');
INSERT INTO `group` VALUES ('147', '大学', '人文与法学学院', '行政诉讼法');
INSERT INTO `group` VALUES ('148', '大学', '人文与法学学院', '民事诉讼法');
INSERT INTO `group` VALUES ('149', '大学', '艺术学院', '素描');
INSERT INTO `group` VALUES ('150', '大学', '艺术学院', '色彩');
INSERT INTO `group` VALUES ('151', '大学', '艺术学院', '装饰与设计基础');
INSERT INTO `group` VALUES ('152', '大学', '艺术学院', '效果图表现');
INSERT INTO `group` VALUES ('153', '大学', '艺术学院', '形体训练');
INSERT INTO `group` VALUES ('154', '大学', '艺术学院', '舞蹈基础');
INSERT INTO `group` VALUES ('155', '大学', '艺术学院', '人体工学');
INSERT INTO `group` VALUES ('156', '大学', '艺术学院', '社交礼仪');
INSERT INTO `group` VALUES ('157', '大学', '艺术学院', '雕塑');
INSERT INTO `group` VALUES ('158', '大学', '艺术学院', '造型基础');
INSERT INTO `group` VALUES ('159', '大学', '艺术学院', '设计基础');
INSERT INTO `group` VALUES ('160', '大学', '艺术学院', '声乐');
INSERT INTO `group` VALUES ('161', '社会职业', '计算机等级考试', '');
INSERT INTO `group` VALUES ('162', '社会职业', '会计师', '');
INSERT INTO `group` VALUES ('163', '社会职业', '理财规划师', '');
INSERT INTO `group` VALUES ('164', '社会职业', '心理咨询师', '');
INSERT INTO `group` VALUES ('165', '社会职业', '秘书', '');
INSERT INTO `group` VALUES ('166', '社会职业', '公共营养师', '');
INSERT INTO `group` VALUES ('167', '社会职业', '电子商务师', '');
INSERT INTO `group` VALUES ('168', '社会职业', '物业管理师', '');
INSERT INTO `group` VALUES ('169', '社会职业', '物流师', '');
INSERT INTO `group` VALUES ('170', '社会职业', '企业人力资源管理师', '');
INSERT INTO `group` VALUES ('171', '社会职业', '项目管理师', '');
INSERT INTO `group` VALUES ('172', '社会职业', '企业培养师', '');
INSERT INTO `group` VALUES ('173', '社会职业', '计算机等级考试', '');
INSERT INTO `group` VALUES ('175', '大学', '生命科学学院', '分子生物学');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `queID` int(11) NOT NULL AUTO_INCREMENT,
  `adminID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `groupID` int(11) DEFAULT NULL,
  `queType` varchar(50) DEFAULT NULL,
  `queTitle` varchar(100) DEFAULT NULL,
  `queContent` varchar(255) DEFAULT NULL,
  `queAnswer` varchar(255) DEFAULT NULL,
  `queAnalysis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`queID`),
  KEY `FK_question_group_1` (`groupID`),
  KEY `FK_question_user_1` (`userID`),
  KEY `FK_question_admin_1` (`adminID`),
  CONSTRAINT `FK_question_admin_1` FOREIGN KEY (`adminID`) REFERENCES `admin` (`adminID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_question_group_1` FOREIGN KEY (`groupID`) REFERENCES `group` (`groupID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_question_user_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('86', null, '462', '1', '选择题', '都是', '<p>阿迪</p>', '<p>阿斯顿</p>', '<p>按规定</p>');
INSERT INTO `question` VALUES ('87', null, '460', '4', '填空题', '啊睡的头疼', '<p>的公司</p>', '<p>速度</p>', '<p>速度</p>');
INSERT INTO `question` VALUES ('88', null, '460', '5', '选择题', '附件一', '<p>梵蒂冈</p>', '<p>飞得</p>', '<p>额头</p>');
INSERT INTO `question` VALUES ('89', null, '462', '80', '解答题', '大学军事理论期末考试题及答案', '<p>简述国际战略格局的基本特点。</p>', '<p>国际战略格局的时代性，国际战略格局的适应性，国际战略格局的关联性。<br />&nbsp;</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('90', null, '462', '80', '解答题', '大学军事理论期末考试题及答案', '<p>国防的职能包括哪些?</p>', '<p>&nbsp;答：保卫国家主权、保卫国家领土完整、保卫国家的统一、维护国家安全、保障国家发展、巩固国家的地位。</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('91', null, '462', '80', '解答题', '大学军事理论期末考试题及答案', '<p>国防的基本概念是什么？ &nbsp;</p>', '<p>答：国家为防备和抵抗侵略，制止武装颠覆，保卫国家的主权、统一、领土完整和安全所进行的军事活动，以及与军事有关的政治、经济、外交、科技、教育等方面的活动。</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('92', null, '461', '80', '填空题', '大学军事理论期末考试题及答案', '<p>毛泽东所强调的&ldquo;二十一字方针&rdquo;是：（）；（）；（）；（）；（）。</p>', '<p>积极防御、诱敌深入、打人民战争、打运动战、打歼灭战</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('93', null, '461', '80', '填空题', '大学军事理论期末考试题及答案', '<p>（）年（）月（）日（）时，第一颗原子弱试验成功，中国从此有了自己的核威慑力量。</p>', '<p>1964、10、16、15</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('94', null, '461', '80', '填空题', '大学军事理论期末考试题及答案', '<p>中国国防的历史包括（）、（）、（）等三个阶段。</p>', '<p>中国古代国防、中国近代国防、新中国的国防</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('95', null, '460', '80', '选择题', '大学军事理论期末考试题及答案', '<p>1989年江泽民同志出任中央军委主席，提出坚持走（）的国防建设之路。</p><p>A 大打</p><p>B 精兵</p><p>C 利器</p><p>D 合成</p><p>E 高效</p>', '<p>BCDE</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('96', null, '460', '80', '选择题', '大学军事理论期末考试题及答案', '<p>现代国防的基本类型是（ABC）</p><p>A 侵略扩张型；</p><p>B 自卫防御型；</p><p>C 互相联盟型；</p><p>D 不独不统型；</p>', '<p>ABC</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('97', null, '460', '80', '选择题', '大学军事理论期末考试题及答案', '<p>国防的基本要素是()。</p><p>A 政治要素</p><p>B 经济要素</p><p>C 科技要素</p><p>D 自然要素</p><p>E 军事要素</p>', '<p>ABCDE</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('98', '1', null, '92', '选择题', ' 大学《JAVA语言程序设计》期末考试试题及答案', '<p>已知如下定义：String s = &quot;story&quot;; 下面哪个语句不是合法的( )</p><p>A、s += &quot;books&quot;; &nbsp; &nbsp;</p><p>B、s = s + 100;</p><p>C、int len = s.length; &nbsp; &nbsp; &nbsp;</p><p>D、String t = s + &ldquo;abc&rdquo;;&nbsp;</p>', '<p>C</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('99', '1', null, '92', '填空题', ' 大学《JAVA语言程序设计》期末考试试题及答案', '<p>Java中布尔类型的常量有两种，它们是（）和（）</p>', '<p>true、false</p>', '<p>无</p>');
INSERT INTO `question` VALUES ('100', '1', null, '92', '解答题', ' 大学《JAVA语言程序设计》期末考试试题及答案', '<p><br />简述Java中异常处理的机制？ &nbsp;</p>', '<p>答：首先Java的异常是面向对象的。一个Java的Exception是一个描述异常情况的对象.当出现异常情况时，一个Exception对象就产生了,并放到异常的成员函数里。 &nbsp;<br />Java的异常处理是通过5个关键词来实现的：try,catch,throw,throws和finally。 &nbsp;<br />&nbsp;</p>', '<p>异常处理：在Java语言的错误处理结构由try，catch，finally三个块组成。其中try块存放将可能发生异常的Java语言，并管理相关的异常指针；catch块紧跟在try块后面，用来激发被捕获的异常；finally块包含清除程序没有释放的资源，句柄等。不管try块中的代码如何退出，都将执行 finally块。&nbsp;</p>');
INSERT INTO `question` VALUES ('101', null, '460', '90', '选择题', '大学C语言期末考试练习题(带详解答案)', '<p>下列C语言用户标识符中合法的是（）。 &nbsp; &nbsp; &nbsp;</p><p>A)3ax &nbsp;</p><p>B)x &nbsp;</p><p>C)case &nbsp;</p><p>D)-e2 &nbsp; &nbsp;</p><p>E)union &nbsp;</p>', '<p>B</p>', '<p>选项A中的标识符以数字开头不满足（2）；选项C，E均为为关键字，不满足（3）；选项D中的&ldquo;-&rdquo;不满足（1）；</p>');
INSERT INTO `question` VALUES ('102', null, '462', '92', '选择题', '大学《JAVA语言程序设计》期末考试试题及答案', '<p>如下哪个是Java中的标识符（） &nbsp;</p><p>A、public &nbsp; &nbsp;<br />B、super &nbsp;<br />C、3number &nbsp;&nbsp;<br />D、width &nbsp;</p>', '<p>D<br />&nbsp;</p>', '<p>无</p>');

-- ----------------------------
-- Table structure for upload
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `uplID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `groupID` int(11) DEFAULT NULL,
  `uplStatus` varchar(10) DEFAULT NULL,
  `uplType` varchar(50) DEFAULT NULL,
  `uplTitle` varchar(100) DEFAULT NULL,
  `uplContent` varchar(255) DEFAULT NULL,
  `uplAnswer` varchar(255) DEFAULT NULL,
  `uplAnalysis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uplID`),
  KEY `FK_upload_user_1` (`userID`),
  KEY `FK_upload_group_1` (`groupID`),
  CONSTRAINT `FK_upload_group_1` FOREIGN KEY (`groupID`) REFERENCES `group` (`groupID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_upload_user_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload
-- ----------------------------
INSERT INTO `upload` VALUES ('81', '462', '1', '通过审核', '选择题', '都是', '<p>阿迪</p>', '<p>阿斯顿</p>', '<p>按规定</p>');
INSERT INTO `upload` VALUES ('88', '460', '80', '通过审核', '选择题', '大学军事理论期末考试题及答案', '<p>国防的基本要素是()。</p><p>A 政治要素</p><p>B 经济要素</p><p>C 科技要素</p><p>D 自然要素</p><p>E 军事要素</p>', '<p>ABCDE</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('89', '460', '80', '通过审核', '选择题', '大学军事理论期末考试题及答案', '<p>现代国防的基本类型是（ABC）</p><p>A 侵略扩张型；</p><p>B 自卫防御型；</p><p>C 互相联盟型；</p><p>D 不独不统型；</p>', '<p>ABC</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('90', '460', '80', '通过审核', '选择题', '大学军事理论期末考试题及答案', '<p>1989年江泽民同志出任中央军委主席，提出坚持走（）的国防建设之路。</p><p>A 大打</p><p>B 精兵</p><p>C 利器</p><p>D 合成</p><p>E 高效</p>', '<p>BCDE</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('91', '461', '80', '通过审核', '填空题', '大学军事理论期末考试题及答案', '<p>中国国防的历史包括（）、（）、（）等三个阶段。</p>', '<p>中国古代国防、中国近代国防、新中国的国防</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('92', '461', '80', '通过审核', '填空题', '大学军事理论期末考试题及答案', '<p>（）年（）月（）日（）时，第一颗原子弱试验成功，中国从此有了自己的核威慑力量。</p>', '<p>1964、10、16、15</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('93', '461', '80', '通过审核', '填空题', '大学军事理论期末考试题及答案', '<p>毛泽东所强调的&ldquo;二十一字方针&rdquo;是：（）；（）；（）；（）；（）。</p>', '<p>积极防御、诱敌深入、打人民战争、打运动战、打歼灭战</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('94', '462', '80', '通过审核', '解答题', '大学军事理论期末考试题及答案', '<p>国防的基本概念是什么？ &nbsp;</p>', '<p>答：国家为防备和抵抗侵略，制止武装颠覆，保卫国家的主权、统一、领土完整和安全所进行的军事活动，以及与军事有关的政治、经济、外交、科技、教育等方面的活动。</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('95', '462', '80', '通过审核', '解答题', '大学军事理论期末考试题及答案', '<p>国防的职能包括哪些?</p>', '<p>&nbsp;答：保卫国家主权、保卫国家领土完整、保卫国家的统一、维护国家安全、保障国家发展、巩固国家的地位。</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('97', '460', '90', '审核中', '选择题', '大学C语言期末考试练习题(带详解答案)', '<p><br />（ ）是构成C语言程序的基本单位。 &nbsp;</p><p>A、函数 &nbsp; &nbsp; &nbsp;</p><p>&nbsp;B、过程 &nbsp; &nbsp; &nbsp;</p><p>C、子程序 &nbsp; &nbsp;</p><p>D、子例程</p>', '<p>A&nbsp;</p>', '<p>无</p>');
INSERT INTO `upload` VALUES ('98', '460', '90', '通过审核', '选择题', '大学C语言期末考试练习题(带详解答案)', '<p>下列C语言用户标识符中合法的是（）。 &nbsp; &nbsp; &nbsp;</p><p>A)3ax &nbsp;</p><p>B)x &nbsp;</p><p>C)case &nbsp;</p><p>D)-e2 &nbsp; &nbsp;</p><p>E)union &nbsp;</p>', '<p>B</p>', '<p>选项A中的标识符以数字开头不满足（2）；选项C，E均为为关键字，不满足（3）；选项D中的&ldquo;-&rdquo;不满足（1）；</p>');
INSERT INTO `upload` VALUES ('99', '462', '92', '通过审核', '选择题', '大学《JAVA语言程序设计》期末考试试题及答案', '<p>如下哪个是Java中的标识符（） &nbsp;</p><p>A、public &nbsp; &nbsp;<br />B、super &nbsp;<br />C、3number &nbsp;&nbsp;<br />D、width &nbsp;</p>', '<p>D<br />&nbsp;</p>', '<p>无</p>');

-- ----------------------------
-- Table structure for upload_admin
-- ----------------------------
DROP TABLE IF EXISTS `upload_admin`;
CREATE TABLE `upload_admin` (
  `uplID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `groupID` int(11) DEFAULT NULL,
  `uplStatus` varchar(10) DEFAULT NULL,
  `uplType` varchar(50) DEFAULT NULL,
  `uplTitle` varchar(100) DEFAULT NULL,
  `uplContent` varchar(255) DEFAULT NULL,
  `uplAnswer` varchar(255) DEFAULT NULL,
  `uplAnalysis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uplID`),
  KEY `FK_upload_user_1` (`userID`),
  KEY `FK_upload_group_1` (`groupID`),
  CONSTRAINT `upload_admin_ibfk_1` FOREIGN KEY (`groupID`) REFERENCES `group` (`groupID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `upload_admin_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload_admin
-- ----------------------------
INSERT INTO `upload_admin` VALUES ('97', '460', '90', '审核中', '选择题', '大学C语言期末考试练习题(带详解答案)', '<p><br />（ ）是构成C语言程序的基本单位。 &nbsp;</p><p>A、函数 &nbsp; &nbsp; &nbsp;</p><p>&nbsp;B、过程 &nbsp; &nbsp; &nbsp;</p><p>C、子程序 &nbsp; &nbsp;</p><p>D、子例程</p>', '<p>A&nbsp;</p>', '<p>无</p>');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(25) NOT NULL,
  `userPassword` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `IDX_user_userAccount` (`userAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=463 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('460', '111', '111');
INSERT INTO `user` VALUES ('461', '222', '222');
INSERT INTO `user` VALUES ('462', '333', '333');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `infoID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `userAge` int(3) DEFAULT NULL,
  `userSex` varchar(2) DEFAULT NULL,
  `userIdentity` varchar(20) DEFAULT NULL,
  `userMobile` char(11) DEFAULT NULL,
  `userAddress` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`infoID`),
  KEY `FK_userinfo_user_1` (`userID`),
  CONSTRAINT `FK_userinfo_user_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('3', '460', '业务额', '22', '男', '学生', '13580123359', '广东');
INSERT INTO `userinfo` VALUES ('4', '461', '美铝', '22', '女', '工程师', '15854658964', '广东深圳');
INSERT INTO `userinfo` VALUES ('5', '462', '小辉', '23', '男', '大学生', '13584456689', '湖南长沙');
