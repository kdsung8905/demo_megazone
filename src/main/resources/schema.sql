

CREATE TABLE mgz_role (
                          id bigint AUTO_INCREMENT  PRIMARY KEY,
                          role_name VARCHAR(20) NOT NULL, /*역할명*/
                          del_yn VARCHAR(1) DEFAULT 'N' NOT NULL /*삭제여부*/
);

CREATE TABLE mgz_rights (
                                  id bigint AUTO_INCREMENT  PRIMARY KEY,
                                  "role" bigint NOT NULL, /*역할*/
                                  rights_name VARCHAR(20) NOT NULL, /*권한명*/
                                  uri VARCHAR(30) NOT NULL, /*uri*/
                                  del_yn VARCHAR(1) DEFAULT 'N' NOT NULL /*삭제여부*/
);

ALTER TABLE mgz_rights ADD FOREIGN KEY ("role") REFERENCES mgz_role(id);



CREATE TABLE mgz_user (
                          id bigint AUTO_INCREMENT  PRIMARY KEY,
                          "role" bigint NULL, /*역할*/
                          user_id VARCHAR(50) NOT NULL, /*로그인 아이디*/
                          password VARCHAR(100) NOT NULL, /*비밀번호*/
                          user_name VARCHAR(10) NOT NULL, /*회원명*/
                          del_yn VARCHAR(1) DEFAULT 'N' NOT NULL /*삭제여부*/
);

ALTER TABLE mgz_user ADD FOREIGN KEY ("role") REFERENCES mgz_role(id);