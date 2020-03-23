/*
Navicat MySQL Data Transfer

Source Server         : local_machine
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : metadatacdm

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-03-20 10:53:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2299 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '11', '#', 'menuItem', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'admin', '2020-01-02 21:27:46', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '12', '#', 'menuItem', 'M', '0', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', 'admin', '2020-01-02 21:28:00', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '13', '#', 'menuItem', 'M', '0', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00', 'admin', '2020-01-02 21:28:12', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', '/system/user', '', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', '/system/role', '', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', '/system/menu', '', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', '/system/dept', '', 'C', '0', 'system:dept:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', '/system/post', '', 'C', '0', 'system:post:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', '/system/dict', '', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', '/system/config', '', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', '/system/notice', '', 'C', '0', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', '#', '', 'M', '0', '', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', '/monitor/online', '', 'C', '0', 'monitor:online:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', '/monitor/job', '', 'C', '0', 'monitor:job:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', '/monitor/data', '', 'C', '0', 'monitor:data:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('112', '服务监控', '2', '3', '/monitor/server', '', 'C', '0', 'monitor:server:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu` VALUES ('113', '表单构建', '3', '1', '/tool/build', '', 'C', '0', 'tool:build:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('114', '代码生成', '3', '2', '/tool/gen', '', 'C', '0', 'tool:gen:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('115', '系统接口', '3', '3', '/tool/swagger', '', 'C', '0', 'tool:swagger:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', '/monitor/operlog', '', 'C', '0', 'monitor:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', '/monitor/logininfor', '', 'C', '0', 'monitor:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('1000', '用户查询', '100', '1', '#', '', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1001', '用户新增', '100', '2', '#', '', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1002', '用户修改', '100', '3', '#', '', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1003', '用户删除', '100', '4', '#', '', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1004', '用户导出', '100', '5', '#', '', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导入', '100', '6', '#', '', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1006', '重置密码', '100', '7', '#', '', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1007', '角色查询', '101', '1', '#', '', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1008', '角色新增', '101', '2', '#', '', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1009', '角色修改', '101', '3', '#', '', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1010', '角色删除', '101', '4', '#', '', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1011', '角色导出', '101', '5', '#', '', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1012', '菜单查询', '102', '1', '#', '', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单新增', '102', '2', '#', '', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单修改', '102', '3', '#', '', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1015', '菜单删除', '102', '4', '#', '', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1016', '部门查询', '103', '1', '#', '', 'F', '0', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1017', '部门新增', '103', '2', '#', '', 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1018', '部门修改', '103', '3', '#', '', 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1019', '部门删除', '103', '4', '#', '', 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1020', '岗位查询', '104', '1', '#', '', 'F', '0', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1021', '岗位新增', '104', '2', '#', '', 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1022', '岗位修改', '104', '3', '#', '', 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1023', '岗位删除', '104', '4', '#', '', 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1024', '岗位导出', '104', '5', '#', '', 'F', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1025', '字典查询', '105', '1', '#', '', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1026', '字典新增', '105', '2', '#', '', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1027', '字典修改', '105', '3', '#', '', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1028', '字典删除', '105', '4', '#', '', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1029', '字典导出', '105', '5', '#', '', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1030', '参数查询', '106', '1', '#', '', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1031', '参数新增', '106', '2', '#', '', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1032', '参数修改', '106', '3', '#', '', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1033', '参数删除', '106', '4', '#', '', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1034', '参数导出', '106', '5', '#', '', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1035', '公告查询', '107', '1', '#', '', 'F', '0', 'system:notice:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1036', '公告新增', '107', '2', '#', '', 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1037', '公告修改', '107', '3', '#', '', 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1038', '公告删除', '107', '4', '#', '', 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1039', '操作查询', '500', '1', '#', '', 'F', '0', 'monitor:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1040', '操作删除', '500', '2', '#', '', 'F', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1041', '详细信息', '500', '3', '#', '', 'F', '0', 'monitor:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1042', '日志导出', '500', '4', '#', '', 'F', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1043', '登录查询', '501', '1', '#', '', 'F', '0', 'monitor:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1044', '登录删除', '501', '2', '#', '', 'F', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1045', '日志导出', '501', '3', '#', '', 'F', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1046', '账户解锁', '501', '4', '#', '', 'F', '0', 'monitor:logininfor:unlock', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1047', '在线查询', '109', '1', '#', '', 'F', '0', 'monitor:online:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1048', '批量强退', '109', '2', '#', '', 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1049', '单条强退', '109', '3', '#', '', 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1050', '任务查询', '110', '1', '#', '', 'F', '0', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1051', '任务新增', '110', '2', '#', '', 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1052', '任务修改', '110', '3', '#', '', 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1053', '任务删除', '110', '4', '#', '', 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1054', '状态修改', '110', '5', '#', '', 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1055', '任务详细', '110', '6', '#', '', 'F', '0', 'monitor:job:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1056', '任务导出', '110', '7', '#', '', 'F', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1057', '生成查询', '114', '1', '#', '', 'F', '0', 'tool:gen:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1058', '生成修改', '114', '2', '#', '', 'F', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1059', '生成删除', '114', '3', '#', '', 'F', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1060', '预览代码', '114', '4', '#', '', 'F', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1061', '生成代码', '114', '5', '#', '', 'F', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('2000', '元数据管理', '0', '2', '#', 'menuItem', 'M', '0', '', 'fa fa-cubes', 'admin', '2020-01-01 19:23:43', 'admin', '2020-02-18 17:23:55', '元数据管理菜单');
INSERT INTO `sys_menu` VALUES ('2002', 'JSODS表&字段', '2019', '1', '/metadata/dictionary', 'menuItem', 'C', '0', 'metadata:dictionary:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-02 12:00:10', '江苏农信ODS数据字典菜单');
INSERT INTO `sys_menu` VALUES ('2003', '江苏农信ODS数据字典查询', '2002', '1', '#', '', 'F', '0', 'metadata:dictionary:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2004', '江苏农信ODS数据字典新增', '2002', '2', '#', '', 'F', '0', 'metadata:dictionary:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2005', '江苏农信ODS数据字典修改', '2002', '3', '#', '', 'F', '0', 'metadata:dictionary:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2006', '江苏农信ODS数据字典删除', '2002', '4', '#', '', 'F', '0', 'metadata:dictionary:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2007', 'JSODS下发表', '2019', '1', '/metadata/tablelist', 'menuItem', 'C', '0', 'metadata:tablelist:view', 'fa fa-cube', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-02 12:00:22', '江苏农信省联社给各法人下发的数据库菜单');
INSERT INTO `sys_menu` VALUES ('2008', 'ODS下发表查询', '2007', '1', '#', '', 'F', '0', 'metadata:tablelist:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2009', 'ODS下发表新增', '2007', '2', '#', '', 'F', '0', 'metadata:tablelist:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2010', 'ODS下发表修改', '2007', '3', '#', '', 'F', '0', 'metadata:tablelist:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2011', 'ODS下发表删除', '2007', '4', '#', '', 'F', '0', 'metadata:tablelist:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2012', 'ODS下发表导出', '2007', '5', '#', '', 'F', '0', 'metadata:tablelist:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2013', 'ODS表清单', '2019', '1', '/metadata/tableall', 'menuItem', 'C', '0', 'metadata:tableall:view', 'fa fa-cube', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-02 12:01:28', 'ODS列菜单');
INSERT INTO `sys_menu` VALUES ('2014', 'ODS列查询', '2013', '1', '#', '', 'F', '0', 'metadata:tableall:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2015', 'ODS列新增', '2013', '2', '#', '', 'F', '0', 'metadata:tableall:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2016', 'ODS列修改', '2013', '3', '#', '', 'F', '0', 'metadata:tableall:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2017', 'ODS列删除', '2013', '4', '#', '', 'F', '0', 'metadata:tableall:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2018', 'ODS列导出', '2013', '5', '#', '', 'F', '0', 'metadata:tableall:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2019', '省联社ODS案例一', '2000', '1', '#', 'menuItem', 'M', '0', '', 'fa fa-clone', 'admin', '2020-01-02 11:59:26', 'admin', '2020-02-12 14:21:09', '');
INSERT INTO `sys_menu` VALUES ('2032', '人行报送报来源分析', '2019', '1', '/metadata/pbocsrctbl', 'menuItem', 'C', '0', 'metadata:pbocsrctbl:view', 'fa fa-cube', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-02 20:57:10', '人行报送报来源分析菜单');
INSERT INTO `sys_menu` VALUES ('2033', '人行报送报来源分析查询', '2032', '1', '#', '', 'F', '0', 'metadata:pbocsrctbl:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2034', '人行报送报来源分析新增', '2032', '2', '#', '', 'F', '0', 'metadata:pbocsrctbl:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2035', '人行报送报来源分析修改', '2032', '3', '#', '', 'F', '0', 'metadata:pbocsrctbl:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2036', '人行报送报来源分析删除', '2032', '4', '#', '', 'F', '0', 'metadata:pbocsrctbl:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2037', '人行报送报来源分析导出', '2032', '5', '#', '', 'F', '0', 'metadata:pbocsrctbl:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2038', '银监报送报来源分析', '2019', '1', '/metadata/cbrcsrctbl', 'menuItem', 'C', '0', 'metadata:cbrcsrctbl:view', 'fa fa-cube', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-02 20:57:40', '银监报送报来源分析菜单');
INSERT INTO `sys_menu` VALUES ('2039', '银监报送报来源分析查询', '2038', '1', '#', '', 'F', '0', 'metadata:cbrcsrctbl:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2040', '银监报送报来源分析新增', '2038', '2', '#', '', 'F', '0', 'metadata:cbrcsrctbl:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2041', '银监报送报来源分析修改', '2038', '3', '#', '', 'F', '0', 'metadata:cbrcsrctbl:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2042', '银监报送报来源分析删除', '2038', '4', '#', '', 'F', '0', 'metadata:cbrcsrctbl:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2043', '银监报送报来源分析导出', '2038', '5', '#', '', 'F', '0', 'metadata:cbrcsrctbl:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2044', '数据标准', '0', '3', '#', 'menuItem', 'M', '0', '', 'fa fa-balance-scale', 'admin', '2020-01-02 21:27:24', 'admin', '2020-02-18 17:24:01', '');
INSERT INTO `sys_menu` VALUES ('2051', '商业银行案例一', '2044', '1', '#', 'menuItem', 'M', '0', '', 'fa fa-folder-o', 'admin', '2020-01-02 22:38:05', 'admin', '2020-02-11 20:46:58', '');
INSERT INTO `sys_menu` VALUES ('2064', '数据标准总览', '2051', '91', '/metadata/bhnsallsubject', 'menuItem', 'C', '0', 'metadata:bhnsallsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-12 14:20:06', '滨海农商行数据标准_所有主题菜单');
INSERT INTO `sys_menu` VALUES ('2065', '滨海农商行数据标准_所有主题查询', '2064', '1', '#', '', 'F', '0', 'metadata:bhnsallsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2066', '滨海农商行数据标准_所有主题新增', '2064', '2', '#', '', 'F', '0', 'metadata:bhnsallsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2067', '滨海农商行数据标准_所有主题修改', '2064', '3', '#', '', 'F', '0', 'metadata:bhnsallsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2068', '滨海农商行数据标准_所有主题删除', '2064', '4', '#', '', 'F', '0', 'metadata:bhnsallsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2069', '滨海农商行数据标准_所有主题导出', '2064', '5', '#', '', 'F', '0', 'metadata:bhnsallsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2070', '客户主题', '2051', '3', '/metadata/bhnscusubject', 'menuItem', 'C', '0', 'metadata:bhnscusubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-08 19:12:44', 'VIEW菜单');
INSERT INTO `sys_menu` VALUES ('2071', '客户主题查询', '2070', '1', '#', '', 'F', '0', 'metadata:bhnscusubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2072', '客户主题新增', '2070', '2', '#', '', 'F', '0', 'metadata:bhnscusubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2073', '客户主题修改', '2070', '3', '#', '', 'F', '0', 'metadata:bhnscusubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2074', '客户主题删除', '2070', '4', '#', '', 'F', '0', 'metadata:bhnscusubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2075', '客户主题导出', '2070', '5', '#', '', 'F', '0', 'metadata:bhnscusubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2076', '事件主题', '2051', '4', '/metadata/bhnstrsubject', 'menuItem', 'C', '0', 'metadata:bhnstrsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-03 04:32:26', '事件主题菜单');
INSERT INTO `sys_menu` VALUES ('2077', '事件主题查询', '2076', '1', '#', '', 'F', '0', 'metadata:bhnstrsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2078', '事件主题新增', '2076', '2', '#', '', 'F', '0', 'metadata:bhnstrsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2079', '事件主题修改', '2076', '3', '#', '', 'F', '0', 'metadata:bhnstrsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2080', '事件主题删除', '2076', '4', '#', '', 'F', '0', 'metadata:bhnstrsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2081', '事件主题导出', '2076', '5', '#', '', 'F', '0', 'metadata:bhnstrsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2082', '产品主题', '2051', '5', '/metadata/bhnspdsubject', 'menuItem', 'C', '0', 'metadata:bhnspdsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-03 04:32:48', '产品主题菜单');
INSERT INTO `sys_menu` VALUES ('2083', '产品主题查询', '2082', '1', '#', '', 'F', '0', 'metadata:bhnspdsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2084', '产品主题新增', '2082', '2', '#', '', 'F', '0', 'metadata:bhnspdsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2085', '产品主题修改', '2082', '3', '#', '', 'F', '0', 'metadata:bhnspdsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2086', '产品主题删除', '2082', '4', '#', '', 'F', '0', 'metadata:bhnspdsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2087', '产品主题导出', '2082', '5', '#', '', 'F', '0', 'metadata:bhnspdsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2088', '渠道主题', '2051', '6', '/metadata/bhnschsubject', 'menuItem', 'C', '0', 'metadata:bhnschsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-03 04:33:03', '渠道主题菜单');
INSERT INTO `sys_menu` VALUES ('2089', '渠道主题查询', '2088', '1', '#', '', 'F', '0', 'metadata:bhnschsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2090', '渠道主题新增', '2088', '2', '#', '', 'F', '0', 'metadata:bhnschsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2091', '渠道主题修改', '2088', '3', '#', '', 'F', '0', 'metadata:bhnschsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2092', '渠道主题删除', '2088', '4', '#', '', 'F', '0', 'metadata:bhnschsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2093', '渠道主题导出', '2088', '5', '#', '', 'F', '0', 'metadata:bhnschsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2094', '机构主题', '2051', '7', '/metadata/bhnsbhsubject', 'menuItem', 'C', '0', 'metadata:bhnsbhsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-03 04:33:17', '机构主题菜单');
INSERT INTO `sys_menu` VALUES ('2095', '机构主题查询', '2094', '1', '#', '', 'F', '0', 'metadata:bhnsbhsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2096', '机构主题新增', '2094', '2', '#', '', 'F', '0', 'metadata:bhnsbhsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2097', '机构主题修改', '2094', '3', '#', '', 'F', '0', 'metadata:bhnsbhsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2098', '机构主题删除', '2094', '4', '#', '', 'F', '0', 'metadata:bhnsbhsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2099', '机构主题导出', '2094', '5', '#', '', 'F', '0', 'metadata:bhnsbhsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2100', '资产主题', '2051', '9', '/metadata/bhnsassubject', 'menuItem', 'C', '0', 'metadata:bhnsassubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-03 04:33:35', '资产主题菜单');
INSERT INTO `sys_menu` VALUES ('2101', '资产主题查询', '2100', '1', '#', '', 'F', '0', 'metadata:bhnsassubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2102', '资产主题新增', '2100', '2', '#', '', 'F', '0', 'metadata:bhnsassubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2103', '资产主题修改', '2100', '3', '#', '', 'F', '0', 'metadata:bhnsassubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2104', '资产主题删除', '2100', '4', '#', '', 'F', '0', 'metadata:bhnsassubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2105', '资产主题导出', '2100', '5', '#', '', 'F', '0', 'metadata:bhnsassubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2106', '协议主题', '2051', '10', '/metadata/bhnsagsubject', 'menuItem', 'C', '0', 'metadata:bhnsagsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-01-03 04:33:51', '协议主题菜单');
INSERT INTO `sys_menu` VALUES ('2107', '协议主题查询', '2106', '1', '#', '', 'F', '0', 'metadata:bhnsagsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2108', '协议主题新增', '2106', '2', '#', '', 'F', '0', 'metadata:bhnsagsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2109', '协议主题修改', '2106', '3', '#', '', 'F', '0', 'metadata:bhnsagsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2110', '协议主题删除', '2106', '4', '#', '', 'F', '0', 'metadata:bhnsagsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2111', '协议主题导出', '2106', '5', '#', '', 'F', '0', 'metadata:bhnsagsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2118', '标准代码总览', '2051', '92', '/metadata/bhnscoderef', 'menuItem', 'C', '0', 'metadata:bhnscoderef:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-12 14:48:55', '各主题代码参数表菜单');
INSERT INTO `sys_menu` VALUES ('2119', '各主题代码参数表查询', '2118', '1', '#', '', 'F', '0', 'metadata:bhnscoderef:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2120', '各主题代码参数表新增', '2118', '2', '#', '', 'F', '0', 'metadata:bhnscoderef:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2121', '各主题代码参数表修改', '2118', '3', '#', '', 'F', '0', 'metadata:bhnscoderef:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2122', '各主题代码参数表删除', '2118', '4', '#', '', 'F', '0', 'metadata:bhnscoderef:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2123', '各主题代码参数表导出', '2118', '5', '#', '', 'F', '0', 'metadata:bhnscoderef:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2124', '数据标准总览', '2130', '91', '/metadata/zsyhallsubject', 'menuItem', 'C', '0', 'metadata:zsyhallsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:26:03', '案例二数据标准菜单');
INSERT INTO `sys_menu` VALUES ('2125', '案例二数据标准查询', '2124', '1', '#', '', 'F', '0', 'metadata:zsyhallsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2126', '案例二数据标准新增', '2124', '2', '#', '', 'F', '0', 'metadata:zsyhallsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2127', '案例二数据标准修改', '2124', '3', '#', '', 'F', '0', 'metadata:zsyhallsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2128', '案例二数据标准删除', '2124', '4', '#', '', 'F', '0', 'metadata:zsyhallsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2129', '案例二数据标准导出', '2124', '5', '#', '', 'F', '0', 'metadata:zsyhallsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2130', '商业银行案例二', '2044', '2', '#', 'menuItem', 'M', '0', '', 'fa fa-folder-o', 'admin', '2020-02-12 16:00:38', 'admin', '2020-02-13 12:27:08', '');
INSERT INTO `sys_menu` VALUES ('2131', '数据标准码值总览', '2225', '1', '/metadata/allsubjectcoderef', 'menuItem', 'C', '0', 'metadata:allsubjectcoderef:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-18 17:27:13', '数据标准所有主题码值对照菜单');
INSERT INTO `sys_menu` VALUES ('2132', '数据标准所有主题码值对照查询', '2131', '1', '#', '', 'F', '0', 'metadata:allsubjectcoderef:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2133', '数据标准所有主题码值对照新增', '2131', '2', '#', '', 'F', '0', 'metadata:allsubjectcoderef:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2134', '数据标准所有主题码值对照修改', '2131', '3', '#', '', 'F', '0', 'metadata:allsubjectcoderef:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2135', '数据标准所有主题码值对照删除', '2131', '4', '#', '', 'F', '0', 'metadata:allsubjectcoderef:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2136', '数据标准所有主题码值对照导出', '2131', '5', '#', '', 'F', '0', 'metadata:allsubjectcoderef:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2137', '代码参数总览', '2130', '92', '/metadata/zsyhcoderef', 'menuItem', 'C', '0', 'metadata:zsyhcoderef:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:26:17', 'VIEW菜单');
INSERT INTO `sys_menu` VALUES ('2138', '商业银行案例二代码参数查询', '2137', '1', '#', '', 'F', '0', 'metadata:zsyhcoderef:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2139', '商业银行案例二代码参数新增', '2137', '2', '#', '', 'F', '0', 'metadata:zsyhcoderef:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2140', '商业银行案例二代码参数修改', '2137', '3', '#', '', 'F', '0', 'metadata:zsyhcoderef:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2141', '商业银行案例二代码参数删除', '2137', '4', '#', '', 'F', '0', 'metadata:zsyhcoderef:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2142', '商业银行案例二代码参数导出', '2137', '5', '#', '', 'F', '0', 'metadata:zsyhcoderef:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2143', '事件主题', '2130', '1', '/metadata/zsyhsubjecttr', 'menuItem', 'C', '0', 'metadata:zsyhsubjecttr:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:22:52', '数据标准事件主题菜单');
INSERT INTO `sys_menu` VALUES ('2144', '数据标准事件主题查询', '2143', '1', '#', '', 'F', '0', 'metadata:zsyhsubjecttr:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2145', '数据标准事件主题新增', '2143', '2', '#', '', 'F', '0', 'metadata:zsyhsubjecttr:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2146', '数据标准事件主题修改', '2143', '3', '#', '', 'F', '0', 'metadata:zsyhsubjecttr:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2147', '数据标准事件主题删除', '2143', '4', '#', '', 'F', '0', 'metadata:zsyhsubjecttr:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2148', '数据标准事件主题导出', '2143', '5', '#', '', 'F', '0', 'metadata:zsyhsubjecttr:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2149', '产品主题', '2130', '2', '/metadata/zsyhsubjectpd', 'menuItem', 'C', '0', 'metadata:zsyhsubjectpd:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:23:24', '数据标准产品主题菜单');
INSERT INTO `sys_menu` VALUES ('2150', '数据标准产品主题查询', '2149', '1', '#', '', 'F', '0', 'metadata:zsyhsubjectpd:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2151', '数据标准产品主题新增', '2149', '2', '#', '', 'F', '0', 'metadata:zsyhsubjectpd:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2152', '数据标准产品主题修改', '2149', '3', '#', '', 'F', '0', 'metadata:zsyhsubjectpd:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2153', '数据标准产品主题删除', '2149', '4', '#', '', 'F', '0', 'metadata:zsyhsubjectpd:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2154', '数据标准产品主题导出', '2149', '5', '#', '', 'F', '0', 'metadata:zsyhsubjectpd:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2155', '客户主题', '2130', '3', '/metadata/zsyhsubjectcu', 'menuItem', 'C', '0', 'metadata:zsyhsubjectcu:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:25:48', '数据标准客户主题菜单');
INSERT INTO `sys_menu` VALUES ('2156', '数据标准客户主题查询', '2155', '1', '#', '', 'F', '0', 'metadata:zsyhsubjectcu:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2157', '数据标准客户主题新增', '2155', '2', '#', '', 'F', '0', 'metadata:zsyhsubjectcu:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2158', '数据标准客户主题修改', '2155', '3', '#', '', 'F', '0', 'metadata:zsyhsubjectcu:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2159', '数据标准客户主题删除', '2155', '4', '#', '', 'F', '0', 'metadata:zsyhsubjectcu:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2160', '数据标准客户主题导出', '2155', '5', '#', '', 'F', '0', 'metadata:zsyhsubjectcu:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2161', '渠道主题', '2130', '5', '/metadata/zsyhsubjectch', 'menuItem', 'C', '0', 'metadata:zsyhsubjectch:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:24:11', '数据标准渠道主题菜单');
INSERT INTO `sys_menu` VALUES ('2162', '数据标准渠道主题查询', '2161', '1', '#', '', 'F', '0', 'metadata:zsyhsubjectch:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2163', '数据标准渠道主题新增', '2161', '2', '#', '', 'F', '0', 'metadata:zsyhsubjectch:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2164', '数据标准渠道主题修改', '2161', '3', '#', '', 'F', '0', 'metadata:zsyhsubjectch:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2165', '数据标准渠道主题删除', '2161', '4', '#', '', 'F', '0', 'metadata:zsyhsubjectch:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2166', '数据标准渠道主题导出', '2161', '5', '#', '', 'F', '0', 'metadata:zsyhsubjectch:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2167', '机构主题', '2130', '6', '/metadata/zsyhsubjectbh', 'menuItem', 'C', '0', 'metadata:zsyhsubjectbh:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:24:30', '数据标准机构主题菜单');
INSERT INTO `sys_menu` VALUES ('2168', '数据标准机构主题查询', '2167', '1', '#', '', 'F', '0', 'metadata:zsyhsubjectbh:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2169', '数据标准机构主题新增', '2167', '2', '#', '', 'F', '0', 'metadata:zsyhsubjectbh:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2170', '数据标准机构主题修改', '2167', '3', '#', '', 'F', '0', 'metadata:zsyhsubjectbh:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2171', '数据标准机构主题删除', '2167', '4', '#', '', 'F', '0', 'metadata:zsyhsubjectbh:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2172', '数据标准机构主题导出', '2167', '5', '#', '', 'F', '0', 'metadata:zsyhsubjectbh:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2173', '资产主题', '2130', '7', '/metadata/zsyhsubjectas', 'menuItem', 'C', '0', 'metadata:zsyhsubjectas:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:24:48', '数据标准资产主题菜单');
INSERT INTO `sys_menu` VALUES ('2174', '数据标准资产主题查询', '2173', '1', '#', '', 'F', '0', 'metadata:zsyhsubjectas:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2175', '数据标准资产主题新增', '2173', '2', '#', '', 'F', '0', 'metadata:zsyhsubjectas:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2176', '数据标准资产主题修改', '2173', '3', '#', '', 'F', '0', 'metadata:zsyhsubjectas:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2177', '数据标准资产主题删除', '2173', '4', '#', '', 'F', '0', 'metadata:zsyhsubjectas:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2178', '数据标准资产主题导出', '2173', '5', '#', '', 'F', '0', 'metadata:zsyhsubjectas:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2179', '协议主题', '2130', '4', '/metadata/zsyhsubjectag', 'menuItem', 'C', '0', 'metadata:zsyhsubjectag:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-13 12:25:27', '数据标准协议主题菜单');
INSERT INTO `sys_menu` VALUES ('2180', '数据标准协议主题查询', '2179', '1', '#', '', 'F', '0', 'metadata:zsyhsubjectag:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2181', '数据标准协议主题新增', '2179', '2', '#', '', 'F', '0', 'metadata:zsyhsubjectag:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2182', '数据标准协议主题修改', '2179', '3', '#', '', 'F', '0', 'metadata:zsyhsubjectag:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2183', '数据标准协议主题删除', '2179', '4', '#', '', 'F', '0', 'metadata:zsyhsubjectag:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2184', '数据标准协议主题导出', '2179', '5', '#', '', 'F', '0', 'metadata:zsyhsubjectag:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2185', '商业银行案例三', '2044', '3', '#', 'menuItem', 'M', '0', '', 'fa fa-folder-o', 'admin', '2020-02-16 19:19:34', 'admin', '2020-02-18 17:24:58', '');
INSERT INTO `sys_menu` VALUES ('2186', '商业银行案例四', '2044', '4', '#', 'menuItem', 'M', '0', '', 'fa fa-folder-o', 'admin', '2020-02-16 19:19:55', 'admin', '2020-02-18 17:25:09', '');
INSERT INTO `sys_menu` VALUES ('2188', '数据标准总览', '2186', '91', '/metadata/shyhallsubject', 'menuItem', 'C', '0', 'metadata:shyhallsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-16 21:15:47', '商业银行案例四菜单');
INSERT INTO `sys_menu` VALUES ('2189', '商业银行案例四查询', '2188', '1', '#', '', 'F', '0', 'metadata:shyhallsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2190', '商业银行案例四新增', '2188', '2', '#', '', 'F', '0', 'metadata:shyhallsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2191', '商业银行案例四修改', '2188', '3', '#', '', 'F', '0', 'metadata:shyhallsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2192', '商业银行案例四删除', '2188', '4', '#', '', 'F', '0', 'metadata:shyhallsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2193', '商业银行案例四导出', '2188', '5', '#', '', 'F', '0', 'metadata:shyhallsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2194', '数据标准总览', '2185', '91', '/metadata/hdyhallsubject', 'menuItem', 'C', '0', 'metadata:hdyhallsubject:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-16 20:49:38', '商业银行案例三菜单');
INSERT INTO `sys_menu` VALUES ('2195', '商业银行案例三查询', '2194', '1', '#', '', 'F', '0', 'metadata:hdyhallsubject:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2196', '商业银行案例三新增', '2194', '2', '#', '', 'F', '0', 'metadata:hdyhallsubject:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2197', '商业银行案例三修改', '2194', '3', '#', '', 'F', '0', 'metadata:hdyhallsubject:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2198', '商业银行案例三删除', '2194', '4', '#', '', 'F', '0', 'metadata:hdyhallsubject:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2199', '商业银行案例三导出', '2194', '5', '#', '', 'F', '0', 'metadata:hdyhallsubject:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2200', '客户主题', '2185', '1', '/metadata/hdyhallsubject/listbysubject/客户', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 20:50:44', '', null, '');
INSERT INTO `sys_menu` VALUES ('2201', '客户主题', '2186', '1', '/metadata/shyhallsubject/listbysubject/客户', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:16:49', '', null, '');
INSERT INTO `sys_menu` VALUES ('2202', '产品主题', '2185', '2', '/metadata/hdyhallsubject/listbysubject/产品主题', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:33:21', '', null, '');
INSERT INTO `sys_menu` VALUES ('2203', '交易主题', '2185', '3', '/metadata/hdyhallsubject/listbysubject/交易', 'menuItem', 'C', '0', '', '#', 'admin', '2020-02-16 21:37:58', 'admin', '2020-02-16 21:38:14', '');
INSERT INTO `sys_menu` VALUES ('2204', '地址主题', '2185', '4', '/metadata/hdyhallsubject/listbysubject/地址 								/metadata/hdyhallsubject/listbysubject/营销', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:39:21', '', null, '');
INSERT INTO `sys_menu` VALUES ('2205', '组织主题', '2185', '5', '/metadata/hdyhallsubject/listbysubject/组织', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:40:12', '', null, '');
INSERT INTO `sys_menu` VALUES ('2206', '财务主题', '2185', '6', '/metadata/hdyhallsubject/listbysubject/财务', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:40:58', '', null, '');
INSERT INTO `sys_menu` VALUES ('2207', '协议主题', '2185', '7', '/metadata/hdyhallsubject/listbysubject/协议', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:41:52', '', null, '');
INSERT INTO `sys_menu` VALUES ('2208', '资产主题', '2185', '8', '/metadata/hdyhallsubject/listbysubject/资产', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:42:38', '', null, '');
INSERT INTO `sys_menu` VALUES ('2209', '营销主题', '2185', '9', '/metadata/hdyhallsubject/listbysubject/营销', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:43:34', '', null, '');
INSERT INTO `sys_menu` VALUES ('2210', '产品主题', '2186', '2', '/metadata/shyhallsubject/listbysubject/产品', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:48:09', '', null, '');
INSERT INTO `sys_menu` VALUES ('2211', '协议主题', '2186', '3', '/metadata/shyhallsubject/listbysubject/协议', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:49:40', '', null, '');
INSERT INTO `sys_menu` VALUES ('2212', '交易主题', '2186', '4', '/metadata/shyhallsubject/listbysubject/交易', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:50:13', '', null, '');
INSERT INTO `sys_menu` VALUES ('2213', '财务主题', '2186', '5', '/metadata/shyhallsubject/listbysubject/财务', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:50:47', '', null, '');
INSERT INTO `sys_menu` VALUES ('2214', '资产主题', '2186', '6', '/metadata/shyhallsubject/listbysubject/资产', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:51:25', '', null, '');
INSERT INTO `sys_menu` VALUES ('2215', '营销主题', '2186', '7', '/metadata/shyhallsubject/listbysubject/营销', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:52:05', '', null, '');
INSERT INTO `sys_menu` VALUES ('2216', '渠道主题', '2186', '8', '/metadata/shyhallsubject/listbysubject/渠道', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:52:50', '', null, '');
INSERT INTO `sys_menu` VALUES ('2217', '地址主题', '2186', '9', '/metadata/shyhallsubject/listbysubject/地址', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:53:23', '', null, '');
INSERT INTO `sys_menu` VALUES ('2218', '组织主题', '2186', '10', '/metadata/shyhallsubject/listbysubject/组织', 'menuItem', 'C', '0', null, '#', 'admin', '2020-02-16 21:54:04', '', null, '');
INSERT INTO `sys_menu` VALUES ('2219', '银行束语定义集', '2225', '1', '/metadata/bussdefine', 'menuItem', 'C', '0', 'metadata:bussdefine:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-02-18 17:24:30', '银行束语定义集菜单');
INSERT INTO `sys_menu` VALUES ('2220', '银行束语定义集查询', '2219', '1', '#', '', 'F', '0', 'metadata:bussdefine:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2221', '银行束语定义集新增', '2219', '2', '#', '', 'F', '0', 'metadata:bussdefine:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2222', '银行束语定义集修改', '2219', '3', '#', '', 'F', '0', 'metadata:bussdefine:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2223', '银行束语定义集删除', '2219', '4', '#', '', 'F', '0', 'metadata:bussdefine:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2224', '银行束语定义集导出', '2219', '5', '#', '', 'F', '0', 'metadata:bussdefine:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2225', '银行业务知识库', '0', '1', '#', 'menuItem', 'M', '0', null, 'fa fa-graduation-cap', 'admin', '2020-02-18 17:23:45', '', null, '');
INSERT INTO `sys_menu` VALUES ('2226', '消息通知分组', '2244', '3', '/qywx/group', 'menuItem', 'C', '0', 'qywx:group:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-11 14:32:10', '微信用户分组信息菜单');
INSERT INTO `sys_menu` VALUES ('2227', '微信用户分组信息查询', '2226', '1', '#', '', 'F', '0', 'qywx:group:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2228', '微信用户分组信息新增', '2226', '2', '#', '', 'F', '0', 'qywx:group:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2229', '微信用户分组信息修改', '2226', '3', '#', '', 'F', '0', 'qywx:group:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2230', '微信用户分组信息删除', '2226', '4', '#', '', 'F', '0', 'qywx:group:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2231', '微信用户分组信息导出', '2226', '5', '#', '', 'F', '0', 'qywx:group:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2232', '企业微信用户', '2244', '4', '/qywx/user', 'menuItem', 'C', '0', 'qywx:user:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-11 14:32:28', '企业微信用户信息菜单');
INSERT INTO `sys_menu` VALUES ('2233', '企业微信用户信息查询', '2232', '1', '#', '', 'F', '0', 'qywx:user:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2234', '企业微信用户信息新增', '2232', '2', '#', '', 'F', '0', 'qywx:user:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2235', '企业微信用户信息修改', '2232', '3', '#', '', 'F', '0', 'qywx:user:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2236', '企业微信用户信息删除', '2232', '4', '#', '', 'F', '0', 'qywx:user:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2237', '企业微信用户信息导出', '2232', '5', '#', '', 'F', '0', 'qywx:user:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2238', '日报明细', '2244', '2', '/qywx/work', 'menuItem', 'C', '0', 'qywx:work:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-11 14:31:40', '当天工作记录信息菜单');
INSERT INTO `sys_menu` VALUES ('2239', '当天工作记录信息查询', '2238', '1', '#', '', 'F', '0', 'qywx:work:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2240', '当天工作记录信息新增', '2238', '2', '#', '', 'F', '0', 'qywx:work:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2241', '当天工作记录信息修改', '2238', '3', '#', '', 'F', '0', 'qywx:work:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2242', '当天工作记录信息删除', '2238', '4', '#', '', 'F', '0', 'qywx:work:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2243', '当天工作记录信息导出', '2238', '5', '#', '', 'F', '0', 'qywx:work:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2244', '日报管理', '0', '7', '#', 'menuItem', 'M', '0', '', 'fa fa-envelope-open', 'admin', '2020-02-26 16:15:33', 'admin', '2020-03-03 16:03:18', '');
INSERT INTO `sys_menu` VALUES ('2245', '用户分组关系', '2244', '5', '/qywx/relation', 'menuItem', 'C', '0', 'qywx:relation:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-11 14:32:46', '分组信息与用户对应关系菜单');
INSERT INTO `sys_menu` VALUES ('2246', '分组信息与用户对应关系查询', '2245', '1', '#', '', 'F', '0', 'qywx:relation:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2247', '分组信息与用户对应关系新增', '2245', '2', '#', '', 'F', '0', 'qywx:relation:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2248', '分组信息与用户对应关系修改', '2245', '3', '#', '', 'F', '0', 'qywx:relation:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2249', '分组信息与用户对应关系删除', '2245', '4', '#', '', 'F', '0', 'qywx:relation:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2250', '分组信息与用户对应关系导出', '2245', '5', '#', '', 'F', '0', 'qywx:relation:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2269', '日报提交浏览', '2244', '1', '/qywx/operatelog', 'menuItem', 'C', '0', 'qywx:operatelog:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-11 14:33:29', '保留用户每次提交的消息内容菜单');
INSERT INTO `sys_menu` VALUES ('2270', '保留用户每次提交的消息内容查询', '2269', '1', '#', '', 'F', '0', 'qywx:operatelog:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2271', '保留用户每次提交的消息内容新增', '2269', '2', '#', '', 'F', '0', 'qywx:operatelog:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2272', '保留用户每次提交的消息内容修改', '2269', '3', '#', '', 'F', '0', 'qywx:operatelog:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2273', '保留用户每次提交的消息内容删除', '2269', '4', '#', '', 'F', '0', 'qywx:operatelog:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2274', '保留用户每次提交的消息内容导出', '2269', '5', '#', '', 'F', '0', 'qywx:operatelog:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2275', '数据质量检核配置', '3', '1', '/metadata/dataqualify', '', 'C', '0', 'metadata:dataqualify:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '数据质量检核配置菜单');
INSERT INTO `sys_menu` VALUES ('2276', '数据质量检核配置查询', '2275', '1', '#', '', 'F', '0', 'metadata:dataqualify:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2277', '数据质量检核配置新增', '2275', '2', '#', '', 'F', '0', 'metadata:dataqualify:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2278', '数据质量检核配置修改', '2275', '3', '#', '', 'F', '0', 'metadata:dataqualify:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2279', '数据质量检核配置删除', '2275', '4', '#', '', 'F', '0', 'metadata:dataqualify:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2280', '数据质量检核配置导出', '2275', '5', '#', '', 'F', '0', 'metadata:dataqualify:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2287', '文件信息', '3', '1', '/etlsqlparase/info', '', 'C', '0', 'etlsqlparase:info:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '文件信息菜单');
INSERT INTO `sys_menu` VALUES ('2288', '文件信息查询', '2287', '1', '#', '', 'F', '0', 'etlsqlparase:info:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2289', '文件信息新增', '2287', '2', '#', '', 'F', '0', 'etlsqlparase:info:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2290', '文件信息修改', '2287', '3', '#', '', 'F', '0', 'etlsqlparase:info:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2291', '文件信息删除', '2287', '4', '#', '', 'F', '0', 'etlsqlparase:info:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2292', '文件信息导出', '2287', '5', '#', '', 'F', '0', 'etlsqlparase:info:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2293', '解析ETL', '3', '1', '/etlsqlparase/etlsql', '', 'C', '0', 'etlsqlparase:etlsql:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '解析ETL菜单');
INSERT INTO `sys_menu` VALUES ('2294', '解析ETL查询', '2293', '1', '#', '', 'F', '0', 'etlsqlparase:etlsql:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2295', '解析ETL新增', '2293', '2', '#', '', 'F', '0', 'etlsqlparase:etlsql:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2296', '解析ETL修改', '2293', '3', '#', '', 'F', '0', 'etlsqlparase:etlsql:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2297', '解析ETL删除', '2293', '4', '#', '', 'F', '0', 'etlsqlparase:etlsql:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('2298', '解析ETL导出', '2293', '5', '#', '', 'F', '0', 'etlsqlparase:etlsql:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
