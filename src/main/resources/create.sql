CREATE DATABASE freeForum;

USE freeForum;

CREATE TABLE users (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  firstName VARCHAR (30) NOT NULL,
  lastName VARCHAR (30) NOT NULL,
  email VARCHAR (50) NOT NULL,
  age INTEGER NOT NULL,
  rating BIGINT(255),
  birthDate DATE ,
  registrationDate DATE DEFAULT(CURRENT_DATE()),
  nikName VARCHAR(30) NOT NULL ,
  gender ENUM('man','woman'),
  rankk ENUM('noob', 'userr', 'pro', 'master', 'legend', 'moderator', 'admin'),
  ava BLOB,
  PRIMARY KEY (id));

CREATE TABLE category (
  id INTEGER (255) NOT NULL  AUTO_INCREMENT,
  name VARCHAR (50) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE forums (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  name VARCHAR (50) NOT NULL,
  ownerCategory INTEGER (255),
  ownerForum INTEGER (255),
  PRIMARY KEY (id),
  FOREIGN KEY (ownerCategory) REFERENCES category(id),
  FOREIGN KEY (ownerForum) REFERENCES forums(id));

CREATE TABLE topics (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  name VARCHAR (50) NOT NULL,
  data LONGTEXT,
  author INTEGER (255) NOT NULL,
  postDate DATE DEFAULT (CURRENT_DATE()),
  lastChangeDate DATE DEFAULT  (CURRENT_DATE()),
  views INTEGER (255),
  rating INTEGER (255),
  ownerForum INTEGER (255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(ownerForum) REFERENCES forums(id),
  FOREIGN KEY(author) REFERENCES  users(id));

CREATE TABLE comments (
  id INTEGER (255) NOT NULL AUTO_INCREMENT,
  authorID INTEGER (255) NOT NULL,
  ownerTopic INTEGER (255),
  ownerComment INTEGER (255),
  rating INTEGER (255),
  data LONGTEXT,
  postDate DATE DEFAULT (CURRENT_DATE()),
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