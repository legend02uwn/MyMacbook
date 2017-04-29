-- 1、删除数据表
DROP TABLE member_role PURGE ;
DROP TABLE action PURGE ;
DROP TABLE role PURGE ;
DROP TABLE member_logs PURGE ;
DROP TABLE member PURGE ;
-- 2、删除序列对象信息
DROP SEQUENCE role_seq ;
DROP SEQUENCE action_seq ;
DROP SEQUENCE mlog_seq ;
-- 3、创建序列
CREATE SEQUENCE role_seq ;
CREATE SEQUENCE action_seq ;
CREATE SEQUENCE mlog_seq ;
-- 4、创建数据表
CREATE TABLE member  (
   mid                varchar2(50)         not null,
   name               varchar2(30),
   password           varchar2(32),
   lastdate           date,
   locked             number,
   constraint pk_mid primary key (mid)
);
CREATE TABLE role (
   rid                NUMBER               not null,
   title              varchar2(50),
   flag               varchar2(50),
   constraint pk_rid primary key (rid)
);
CREATE TABLE action (
   actid              number               not null,
   rid                number,
   title              varchar2(50),
   flag               varchar2(50),
   constraint pk_actid primary key (actid) ,
   CONSTRAINT fk_rid FOREIGN KEY(rid) REFERENCES role(rid)
);
CREATE TABLE member_role (
   mid                varchar2(50),
   rid                NUMBER ,
   CONSTRAINT fk_mid FOREIGN KEY(mid) REFERENCES member(mid) ,
   CONSTRAINT fk_rid2 FOREIGN KEY(rid) REFERENCES role(rid) 
);
CREATE TABLE member_logs (
   mlid               number               not null,
   mid                varchar2(50),
   logindate          date,
   constraint PK_MEMBER_LOGS primary key (mlid) ,
   CONSTRAINT fk_mid3 FOREIGN KEY(mid) REFERENCES member(mid)
);

-- 5、创建测试数据
-- 增加用户：admin/hello
INSERT INTO member(mid,name,password,lastdate,locked) VALUES ('admin','管理员','2E866BF58289E01583AD418F486A69DF',SYSDATE,0) ;
-- 增加用户：mldn/java
INSERT INTO member(mid,name,password,lastdate,locked) VALUES ('mldn','用户','D944055CE013ED9BBC9B010102374EB0',SYSDATE,0) ;
-- 增加角色信息
INSERT INTO role(rid,title,flag) VALUES (role_seq.nextval,'用户管理','member') ;
INSERT INTO role(rid,title,flag) VALUES (role_seq.nextval,'部门管理','dept') ;
INSERT INTO role(rid,title,flag) VALUES (role_seq.nextval,'办公用品管理','goods') ;
-- 增加权限信息
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'创建用户','member:add',2) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'编辑用户','member:edit',2) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'删除用户','member:delete',2) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'查看用户','member:list',2) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'创建部门','dept:add',3) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'编辑部门','dept:edit',3) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'删除部门','dept:delete',3) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'查看部门','dept:list',3) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'商品分类','goods:item',4) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'商品列表','goods:list',4) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'商品添加','goods:add',4) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'商品修改','goods:edit',4) ;
INSERT INTO action(actid,title,flag,rid) VALUES (action_seq.nextval,'商品删除','goods:delete',4) ;

-- 设置用户与角色的对应关系
INSERT INTO member_role(mid,rid) VALUES ('admin',2) ;
INSERT INTO member_role(mid,rid) VALUES ('admin',3) ;
INSERT INTO member_role(mid,rid) VALUES ('admin',4) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',3) ;
INSERT INTO member_role(mid,rid) VALUES ('mldn',4) ;
COMMIT ;