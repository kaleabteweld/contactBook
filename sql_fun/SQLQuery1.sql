CREATE DATABASE ContactBook
use ContactBook;
-- drop  DATABASE ContactBook

CREATE TABLE Contact(
    ContactId int PRIMARY KEY IDENTITY,

	First_name VARCHAR(25) NOT NULL,
	last_name   VARCHAR(25) NOT NULL,
    telephone_number VARCHAR(25) NOT NULL,
    email VARCHAR(30) NOT NULL,

	region VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
	sub_city VARCHAR(30) NOT NULL,
    werda VARCHAR(30) NOT NULL,
    houseNo VARCHAR(30) NOT NULL,
)
select * from Contact

CREATE TABLE Accouts(
	AccoutId int PRIMARY KEY IDENTITY,

    email VARCHAR(30) NOT NULL,
	_password VARCHAR(30) NOT NULL,

)
select * from Accouts

CREATE TABLE Accouts_to_Contact(

	AccoutId int,
	ContactId int,

)
--ALTER TABLE Accouts_to_Contact
--    add CONSTRAINT AccoutId
--        FOREIGN KEY(AccoutId) REFERENCES Accouts(AccoutId)

-- ALTER TABLE Accouts_to_Contact
--    add CONSTRAINT ContactId
--        FOREIGN KEY(ContactId) REFERENCES Contact(ContactId)

-- ALTER TABLE Accouts_to_Contact
-- DROP CONSTRAINT AccoutId;

-- ALTER TABLE Accouts_to_Contact
-- DROP CONSTRAINT ContactId;

select * from Accouts_to_Contact




-- select AccoutId,email,_password from Accouts where email='kolo@gmail.com' and _password='kojihuigi'

-- INSERT INTO Accouts VALUES (default,'kolo@gmail.com','kojihuigi') 
-- INSERT INTO Accouts VALUES ('kaleabteweld3@gmail.com','1010')

-- INSERT INTO Contact VALUES ('kaleab','abay','978678678','kaleabteweld3@gmail.com','lsahbul','addis','09','01','1010')
-- select First_name,last_name,telephone_number,email,region,city,sub_city,werda,houseNo from Contact where ContactId=1

-- INSERT INTO Accouts_to_Contact VALUES (1,1)
-- INSERT INTO Accouts_to_Contact VALUES (1,2)


-- select COUNT(ContactId) AS 'rowcount' from Accouts_to_Contact where AccoutId=1

-- INSERT INTO Contact VALUES ('kolo',' ','0900640160','kaleabteweld3@gmail.com','shit','addis','bo','12','1232');

-- delete from Contact where ContactId=2

-- UPDATE Contact SET First_name = 'kolo',last_name = ' ',telephone_number = '0900640160',email = 'kaleabteweld3@gmail.com',region = 'shit',city = 'addis',sub_city = 'bo',werda = '12',houseNo = '1232' WHERE ContactId = 9
