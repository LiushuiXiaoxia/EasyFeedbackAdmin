-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('意见反馈', '3', '1', '/fb/feedback', 'C', '0', 'fb:feedback:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '意见反馈菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('意见反馈查询', @parentId, '1',  '#',  'F', '0', 'fb:feedback:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('意见反馈新增', @parentId, '2',  '#',  'F', '0', 'fb:feedback:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('意见反馈修改', @parentId, '3',  '#',  'F', '0', 'fb:feedback:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('意见反馈删除', @parentId, '4',  '#',  'F', '0', 'fb:feedback:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('意见反馈导出', @parentId, '5',  '#',  'F', '0', 'fb:feedback:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');