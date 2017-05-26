CREATE TABLE IF NOT exists work_flow.team (
  id BIGINT(25) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  office VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT exists work_flow.user(
  id BIGINT(25) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL ,
  passcode VARCHAR(45),
  rating INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT exists work_flow.apparea (
  id BIGINT(25) NOT NULL,
  name VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  teamId BIGINT(25) NULL,
  PRIMARY KEY (id),
  INDEX teamId_idx (teamId ASC),
  CONSTRAINT teamId
  FOREIGN KEY (teamId) REFERENCES work_flow.team (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


CREATE TABLE IF NOT exists work_flow.user_apparea (
  user_id BIGINT(25) NOT NULL,
  apparea_id BIGINT(25) NULL,
  PRIMARY KEY (user_id),
  INDEX fk_appareaId_idx (apparea_id ASC),
  CONSTRAINT fk_userId
  FOREIGN KEY (user_id)
  REFERENCES work_flow.user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_appareaId
  FOREIGN KEY (apparea_id)
  REFERENCES work_flow.apparea (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT exists work_flow.post (
  post_id BIGINT(25) NOT NULL,
  answer_id BIGINT(25) NOT NULL,
  user_id BIGINT(25) NOT NULL,
  date_time DATETIME NOT NULL,
  title VARCHAR(45) NOT NULL,
  content VARCHAR(1000) NOT NULL,
  apparea_id BIGINT(25) NOT NULL,
  is_correct BIT(2) NULL,
  INDEX fk_userId_idx (user_id ASC),
  INDEX fk_appareaId_idx (apparea_id ASC),
  PRIMARY KEY (post_id, answer_id),
  CONSTRAINT fk_userId_post
  FOREIGN KEY (user_id)
  REFERENCES work_flow.user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_appareaId_post
  FOREIGN KEY (apparea_id)
  REFERENCES work_flow.apparea (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT exists work_flow.comment (
  id BIGINT(25) NOT NULL AUTO_INCREMENT,
  user_id BIGINT(25) NULL,
  post_id BIGINT(25) NULL,
  content VARCHAR(500) NULL,
  date_time DATETIME NULL,
  PRIMARY KEY (id),
  INDEX fk_userid_comment_idx (user_id ASC),
  INDEX fk_postid_comment_idx (post_id ASC),
  CONSTRAINT fk_userid_comment
  FOREIGN KEY (user_id)
  REFERENCES work_flow.user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_postid_comment
  FOREIGN KEY (post_id)
  REFERENCES work_flow.post (post_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


