DROP TABLE IF EXISTS movie
CREATE TABLE movie
(
 id varchar(11) NOT NULL ,
 name varchar(100) NOT NULL,
 description varchar(250) DEFAULT NULL,
 image varchar(100) DEFAULT NULL,
 PRIMARY KEY (id)
);