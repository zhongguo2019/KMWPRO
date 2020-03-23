/*
Navicat MySQL Data Transfer

Source Server         : alifuwuqi
Source Server Version : 50505
Source Host           : 101.200.160.135:3306
Source Database       : metadatacdm

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-03-20 14:05:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `krm_employees`
-- ----------------------------
DROP TABLE IF EXISTS `krm_employees`;
CREATE TABLE `krm_employees` (
  `ID` varchar(63) DEFAULT NULL COMMENT '序号',
  `OA_CODE` varchar(10) DEFAULT NULL COMMENT 'OA编号',
  `EMP_BASE_ADDR` varchar(1000) DEFAULT NULL COMMENT '入职地',
  `NAME` varchar(103) DEFAULT NULL COMMENT '姓名',
  `GENDER` varchar(4) DEFAULT NULL COMMENT '性别',
  `EMP_DATE_` varchar(10) DEFAULT NULL COMMENT '入职时间',
  `POSI_DATE` varchar(10) DEFAULT NULL COMMENT '转正日期',
  `SRV_LENGTH` varchar(10) DEFAULT NULL COMMENT '本司工龄',
  `DEPARTMENT` varchar(108) DEFAULT NULL COMMENT '所属部门',
  `DUTY` varchar(109) DEFAULT NULL COMMENT '本司职务',
  `ID_CODE` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `BIR_DATE` varchar(10) DEFAULT NULL COMMENT '出生年月',
  `AGE` varchar(10) DEFAULT NULL COMMENT '年龄',
  `TEL` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `QQ` varchar(20) DEFAULT NULL COMMENT 'QQ号码',
  `PER_EMAIL` varchar(20) DEFAULT NULL COMMENT '私人邮箱',
  `SALA_CARD` varchar(20) DEFAULT NULL COMMENT '浦发工资卡号',
  `SHB_GJJ_LINE` varchar(10) DEFAULT NULL COMMENT '社保公积金基数',
  `SHB_BASE_LINE` varchar(10) DEFAULT NULL COMMENT '社保基数',
  `GJJ_BASE_LINE` varchar(10) DEFAULT NULL COMMENT '公积金基数',
  `SHB_START_MON` varchar(10) DEFAULT NULL COMMENT '社保起始月',
  `GJJ_START_MON` varchar(10) DEFAULT NULL COMMENT '公积金起始月',
  `JF_TYPE` varchar(10) DEFAULT NULL COMMENT '缴费人员类别',
  `HOME_ADDR` varchar(1000) DEFAULT NULL COMMENT '户口所在地-籍贯',
  `HT_DATE` varchar(124) DEFAULT NULL COMMENT '有效劳动合同期',
  `IS_MARRY` varchar(125) DEFAULT NULL COMMENT '婚否',
  `NATION` varchar(126) DEFAULT NULL COMMENT '民族',
  `GRADUATE` varchar(127) DEFAULT NULL COMMENT '毕业院校',
  `EDUCATION` varchar(128) DEFAULT NULL COMMENT '学历',
  `SPECILIALITION` varchar(129) DEFAULT NULL COMMENT '专业',
  `GRADUATE_TIME` varchar(130) DEFAULT NULL COMMENT '毕业时间',
  `WORK_LEVEL` varchar(131) DEFAULT NULL COMMENT '职称/职业资格',
  `NOW_ADDRESS` varchar(132) DEFAULT NULL COMMENT '现住址',
  `EMR_TEL` varchar(133) DEFAULT NULL COMMENT '紧急联系方式',
  `COM_EMAIL` varchar(134) DEFAULT NULL COMMENT '公司邮箱',
  `RESR_FLD01` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD02` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD03` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD04` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD05` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD06` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD07` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD08` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD09` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD10` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD11` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD12` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD13` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD14` varchar(100) DEFAULT NULL COMMENT '预留',
  `RESR_FLD15` varchar(100) DEFAULT NULL COMMENT '预留'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表KRM';

-- ----------------------------
-- Records of krm_employees
-- ----------------------------
