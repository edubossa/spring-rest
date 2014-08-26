CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

INSERT INTO users(username,password,enabled) VALUES ('admin','e380f106-764d-41e5-9d8c-4138c440080b', true);
INSERT INTO users(username,password,enabled)VALUES ('ntk','f547c0e6-3f1d-4b7a-ba93-c3e0b41fc793', true);

INSERT INTO user_roles (username, role) VALUES ('admin', 'DESENV');
INSERT INTO user_roles (username, role)VALUES ('ntk', 'DESENV');