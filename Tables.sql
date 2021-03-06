DROP DATABASE IF EXISTS HOTEL;
CREATE DATABASE HOTEL;
USE HOTEL;

CREATE TABLE LOGIN
 (
   USERID SMALLINT PRIMARY KEY,
   USERNAME VARCHAR(20), 
   PASSWORD VARCHAR(20) NOT NULL  
 );

INSERT INTO LOGIN VALUES (1,'PRAKHAR','P123');
INSERT INTO LOGIN VALUES (2,'SOUMITRA','S123');
INSERT INTO LOGIN VALUES (3,'VIJAY','V123');
INSERT INTO LOGIN VALUES (4,'ABHI','A123');


CREATE TABLE ROOMDETAIL
   (
     ROOMNO INT PRIMARY KEY,
     AC_NONAC VARCHAR(6),
     ROOMTYPE VARCHAR(30),
     RATE INT,
     STATUS VARCHAR(10)
   );

INSERT INTO ROOMDETAIL VALUES (101,'AC', 'DELUXE',1500,'');
INSERT INTO ROOMDETAIL VALUES (102,'AC', 'EXECUTIVE',2500,'');
INSERT INTO ROOMDETAIL VALUES (103,'NON-AC', 'SUPERIOR',1800,'');
INSERT INTO ROOMDETAIL VALUES (104,'AC', 'DELUXE',1500,'');
INSERT INTO ROOMDETAIL VALUES (105,'NON-AC','SUPERIOR',1800,'');
INSERT INTO ROOMDETAIL VALUES (106,'AC','PRESIDENTIAL SUITE',5000,'');
INSERT INTO ROOMDETAIL VALUES (107,'NON-AC','DELUXE',1150,'');
INSERT INTO ROOMDETAIL VALUES (108,'AC','EXECUTIVE',2500,'');
INSERT INTO ROOMDETAIL VALUES (109,'AC','SUPERIOR',2100,'');
INSERT INTO ROOMDETAIL VALUES (110,'NON-AC','DELUXE',1150,'');


CREATE TABLE BOOKING
(
  BOOK_ID INT PRIMARY KEY,
  ROOM_NO  INT DEFAULT NULL,
  CHECK_IN  DATE DEFAULT NULL,
  CHECK_OUT DATE DEFAULT NULL,
  NO_OF_DAYS SMALLINT DEFAULT NULL,
  TOTALBILL NUMERIC(8,2) DEFAULT NULL,
  CONSTRAINT FK_ROOM FOREIGN KEY(ROOM_NO) REFERENCES ROOMDETAIL(ROOMNO) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE CUSTDETAIL 
  (
    NAME VARCHAR(25) DEFAULT NULL,
    ADDRESS VARCHAR(40) DEFAULT NULL,
    PHONE_NO VARCHAR(10) DEFAULT NULL,
    ROOM_NO INT DEFAULT NULL,
    BOOK_ID INT DEFAULT NULL,
    CONSTRAINT FK_ROOM_C FOREIGN KEY(ROOM_NO) REFERENCES ROOMDETAIL(ROOMNO) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_BOOK FOREIGN KEY(BOOK_ID) REFERENCES BOOKING(BOOK_ID) ON UPDATE CASCADE ON DELETE CASCADE
 ); 

CREATE TABLE CHECK_OUT
   (
     BOOKID INT UNIQUE,
     NAME VARCHAR(25) DEFAULT NULL,
     ROOMNO INT DEFAULT NULL,
     CHECK_IN  DATE DEFAULT NULL,
     CHECK_OUT DATE DEFAULT NULL,
     NO_OF_DAYS INT DEFAULT NULL,
     TOTALBILL NUMERIC(8,2) DEFAULT NULL,
     CONSTRAINT FK_ROOM_COUT FOREIGN KEY(ROOMNO) REFERENCES ROOMDETAIL(ROOMNO) ON UPDATE CASCADE ON DELETE CASCADE,
     CONSTRAINT FK_BOOK_OUT FOREIGN KEY(BOOKID) REFERENCES BOOKING(BOOK_ID) ON UPDATE CASCADE ON DELETE CASCADE
   );



