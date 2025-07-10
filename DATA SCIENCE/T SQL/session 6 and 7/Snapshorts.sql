/*
CREATING A SNAPSHOT FOR THE SAMPLE DATABASE
*/


-- T O   B E   C O N T I N U E D
--_______________________________

--CREATE DATABASE SampleDB_Snapshot
--AS SNAPSHOT OF SampleDB;
--GO
--CREATE DATABASE AdventureWorks2022_Snapshot
--AS SNAPSHOT OF AdventureWorks2022;

--ALTER TABLE Training.Experts
--	ADD Qualifications NVARCHAR(300);
--ALTER TABLE Training.Experts
--	ADD DeliveryDate DATE;

ALTER TABLE Training.Experts
	DROP COLUMN DeliveryDate;
SELECT * FROM Training.Experts;
