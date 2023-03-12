
/* role */
insert into mgz_role (role_name, del_yn) values ('SystemAdmin', 'N');
insert into mgz_role (role_name, del_yn) values ('NormalUser', 'N');
insert into mgz_role (role_name, del_yn) values ('Limited', 'N');
insert into mgz_role (role_name, del_yn) values ('Student', 'N');
insert into mgz_role (role_name, del_yn) values ('Empty', 'N');

/* rights */
insert into mgz_rights ("role", rights_name, uri, del_yn) values (1, 'edit System files', '/mgz/system-files', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (1, 'Access Network', '/mgz/network', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (1, 'edit user files', '/mgz/user-files', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (1, 'read/foo/bar files', '/mgz/read-files', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (1, 'my info', '/mgz/find-me', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (1, 'change user role', '/mgz/role/', 'N');

insert into mgz_rights ("role", rights_name, uri, del_yn) values (2, 'Access Network', '/mgz/network', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (2, 'edit user files', '/mgz/user-files', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (2, 'my info', '/mgz/find-me', 'N');

insert into mgz_rights ("role", rights_name, uri, del_yn) values (3, 'edit user files', '/mgz/user-files', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (3, 'my info', '/mgz/find-me', 'N');

insert into mgz_rights ("role", rights_name, uri, del_yn) values (4, 'Access Network', '/mgz/network', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (4, 'read/foo/bar files', '/mgz/read-files', 'N');
insert into mgz_rights ("role", rights_name, uri, del_yn) values (4, 'my info', '/mgz/find-me', 'N');

insert into mgz_rights ("role", rights_name, uri, del_yn) values (5, 'my info', '/mgz/find-me', 'N');




/* systemAdmin */
insert into mgz_user (user_id, password, user_name, del_yn, "role") values ('systemAdmin', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '홍길동', 'N', 1);
insert into mgz_user (user_id, password, user_name, del_yn, "role") values ('normalUser', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '김길동', 'N', 2);
insert into mgz_user (user_id, password, user_name, del_yn, "role") values ('limited', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '박길동', 'N', 3);
insert into mgz_user (user_id, password, user_name, del_yn, "role") values ('student', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '최길동', 'N', 4);