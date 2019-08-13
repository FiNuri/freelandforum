CREATE database freeForum;
USE freeForum;
CREATE TABLE users (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR (30) NOT NULL,
  lastName VARCHAR (30) NOT NULL,
  email VARCHAR (50) NOT NULL,
  age INT NOT NULL,
  rating BIGINT(255) NOT NULL,
  birthDate DATA NOT NULL ,
  registrationDate DATA NOT NULL,
  sex ENUM(man,woman) NOT NULL,
  rank ENUM(NOOB, USER, PRO, MASTER, LEGEND, MODERATOR, ADMIN) NOT NULL,
  ava BLOB,
  PRIMARY KEY (id));

CREATE TABLE category (
  id INTEGER (255) NOT NULL  AUTO_INCREMENT,
  name VARCHAR (50) NUT NULL,
  PRIMARY KEY (id));

CREATE TABLE forums (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  name VARCHAR (50) NOT NULL,
  ownerCategory VARCHAR (255),
  ownerForum VARCHAR (255),
  PRIMARY KEY (id),
  FOREIGN KEY (ownerCategory) REFERENCES category(id),
  FOREIGN KEY (ownerForum) REFERENCES forums(id));

CREATE TABLE topics (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  name VARCHAR (50) NOT NULL,
  data LONGTEXT,
  author INTEGER (255) NOT NULL,
  postDate DATA DEFAULT CURRENT_DATE(),
  lastChangeDate DATA DEFAULT  CURRENT_DATE(),
  views INTEGER (255),
  rating INTEGER (255),
  ownerForum INTEGER (255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(ownerForum) REFERENCES forums(id));

CREATE TABLE comments (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  authorID INTEGER (255) NOT NULL,
  ownerTopic INTEGER (255),
  ownerComment INTEGER (255),
  rating INTEGER (255),
  PRIMARY KEY (id),
  FOREIGN KEY (ownerComment) REFERENCES comments(id),
  FOREIGN KEY (ownerTopic) REFERENCES topics(id));

CREATE TABLE images (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  image BLOB,
  ownerTopic INTEGER (255),
  ownerComment INTEGER (255),
  PRIMARY KEY (id),
  FOREIGN KEY (ownerTopic) REFERENCES topics(id),
  FOREIGN KEY (ownerComment) REFERENCES comments(id));