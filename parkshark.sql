CREATE USER PARKSHARK IDENTIFIED BY SYSTEM;
GRANT CREATE SESSION TO PARKSHARK;
GRANT CREATE TABLE TO PARKSHARK;
GRANT CREATE SEQUENCE TO PARKSHARK;
ALTER DATABASE DEFAULT TABLESPACE users;
GRANT UNLIMITED TABLESPACE TO PARKSHARK;


CREATE TABLE PHONENUMBERS
(
CONTACT_PERSON_ID NUMBER(6,0) NOT NULL,
PHONE_NUMBER VARCHAR2(50),
CONSTRAINT contact_person_pk PRIMARY KEY (contact_person_id)
);

CREATE TABLE CONTACT_PERSONS
(
CONTACT_PERSON_ID NUMBER (6,0) NOT NULL,
EMAIL VARCHAR2(50) NOT NULL,
CONSTRAINT contact_persons_pk PRIMARY KEY (contact_person_id)
);

CREATE TABLE BUILDING_TYPES
(
BUILDING_TYPE_ID NUMBER (6,0) NOT NULL,
BUILDING_TYPE VARCHAR2 (50),
CONSTRAINT building_types_pk PRIMARY KEY (building_type_id)
);

CREATE TABLE DIVISIONS
(
  DIVISION_ID     NUMBER(6, 0) NOT NULL,
  DIVISION_NAME VARCHAR2(50) NOT NULL,
  ORIGINAL_NAME VARCHAR2(50) NOT NULL,
  DIRECTOR VARCHAR2(50) NOT NULL,
  PARENT_DIVISION_ID NUMBER(6,0),
  CONSTRAINT division_pk PRIMARY KEY (division_ID),
  CONSTRAINT parent_division_fk FOREIGN KEY (parent_division_id) REFERENCES divisions (division_id)
);

CREATE TABLE PARKING_LOTS
( PARKING_LOT_ID NUMBER(6,0) NOT NULL,
PARKING_LOT_NAME VARCHAR(50) NOT NULL,
FK_DIVISION_ID NUMBER(6,0) NOT NULL,
BUILDING_TYPE_ID NUMBER(6,0) NOT NULL,
PARKING_CAPACITY NUMBER(6,0) NOT NULL,
FK_CONTACT_PERSON_ID NUMBER (6,0) NOT NULL,
ADDRESS VARCHAR(50),
FK_ZIPCODE VARCHAR(50),
PRICE_PER_HOUR NUMBER (6,2) NOT NULL,
CONSTRAINT parking_lots_pk PRIMARY KEY (parking_lot_id),
CONSTRAINT parking_lots_divisions_fk FOREIGN KEY (fk_division_id) REFERENCES divisions (division_id),
CONSTRAINT parking_lots_zipcodes_fk FOREIGN KEY (fk_zipcode) REFERENCES zipcodes (zipcode)
);

CREATE TABLE MEMBERS
(
FIRSTNAME VARCHAR2(50),
LASTNAME VARCHAR2(50),
STREET VARCHAR2(50),
HOUSENUMBER VARCHAR(50),
ZIPCODE VARCHAR(50) NOT NULL,
CITY VARCHAR2(50),
MEMBER_ID NUMBER(6,0) NOT NULL,
PHONE_NUMBER VARCHAR2(50) NOT NULL,
EMAIL VARCHAR2(50) NOT NULL,
REGISTRATION_DATE DATE,
CONSTRAINT member_pk PRIMARY KEY (member_id)
);

CREATE TABLE LICENSE_PLATES
(
LICENSE_PLATE VARCHAR2(50),
ISSUING_COUNTRY VARCHAR2(50),
FK_MEMBER_ID NUMBER(6,0),
CONSTRAINT license_plates_pk PRIMARY KEY (license_plate),
CONSTRAINT  members_pk FOREIGN KEY (fk_member_id) REFERENCES members (member_id)
);

CREATE SEQUENCE division_id_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE parking_lot_id_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE contact_person_id_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE member_id_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE building_type_seq
START WITH 1
INCREMENT BY 1;


drop table zipcodes;
drop table phonenumbers;
drop table contact_persons;
drop table building_types;
drop table parking_lots;
drop table divisions;
drop table license_plates;
drop table members;
















