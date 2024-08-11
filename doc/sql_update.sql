-- 2024-08-11 用户表增加企业编码、企业名称、社会信用代码字段（每个用户只能属于一个企业和t_bas_enterprise关联）
ALTER TABLE `sys_user` ADD COLUMN `ent_code` varchar(40) NULL  comment '企业编码';
ALTER TABLE `sys_user` ADD COLUMN `ent_name` varchar(200) NULL  comment '企业名称';
ALTER TABLE `sys_user` ADD COLUMN `social_credit_code` varchar(50) NULL  comment '社会信用代码';