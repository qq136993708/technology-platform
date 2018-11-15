/*
三个特殊的视图，为了数据审批流使用的
本来这三个表是activiti默认的表，改成视图和系统的权限表关联上

Date: 2018-07-26 13:27:06
*/

CREATE VIEW ACT_ID_GROUP AS 
SELECT 
	sys_role.role_flag AS ID_, 1 AS REV_,sys_role.role_flag AS NAME_, NULL AS TYPE_  
FROM 
	sys_role
UNION ALL
 
SELECT 
	sys_unit.unit_code AS ID_, 1 AS REV_,sys_unit.unit_code AS NAME_, NULL AS TYPE_  
FROM 
	sys_unit
WHERE 
	(
		sys_unit.unit_delflag = 0
	)
UNION ALL
 
SELECT 
	sys_post.post_code AS ID_, 1 AS REV_,sys_post.post_code AS NAME_, NULL AS TYPE_  
FROM 
	sys_post;

SELECT 
	sys_post.post_code AS post_code, 1 AS REV_,sys_post.post_code AS post_code, NULL AS TYPE_  
FROM 
	sys_post 
WHERE 
	(
		sys_post.post_delflag = 0
	);


CREATE VIEW ACT_ID_MEMBERSHIP AS 
SELECT
	sys_user_role.user_id AS USER_ID_,
	sys_role.role_flag AS GROUP_ID_
FROM
		sys_user_role,sys_role
WHERE
	(
		sys_user_role.role_id = sys_role.role_id
	)
UNION ALL

SELECT
		sys_user_unit.user_id AS user_id,
		sys_unit.unit_code AS unit_code
	FROM
			sys_user_unit,sys_unit
	WHERE
	sys_user_unit.unit_id = sys_unit.unit_id
  AND sys_unit.unit_delflag = 0
UNION ALL

SELECT
			sys_user_post.user_id AS user_id,
			sys_post.post_code AS post_code
		FROM
				sys_user_post,sys_post
		WHERE
		sys_user_post.post_id = sys_post.post_id
		AND sys_post.post_delflag = 0;
		
CREATE VIEW ACT_ID_USER AS 
SELECT
	sys_user.user_id AS ID_,
	1 AS REV_,
	sys_user.user_name AS FIRST_,
	NULL AS LAST_,
	NULL AS EMAIL_,
	NULL AS PWD_,
	NULL AS PICTURE_ID_
FROM
	sys_user;
			
			