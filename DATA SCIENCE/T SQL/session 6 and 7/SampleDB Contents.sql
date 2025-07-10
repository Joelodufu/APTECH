USE SampleDB;
go
--CREATE SCHEMA Training;

--CREATE TABLE Training.Facilitators(
--	FacilitatorID INT PRIMARY KEY,
--	FacilitatorName NVARCHAR(200),
--	FacilitatorDepartment NVARCHAR (300)
--);

/*
TRAINING SUBJECT MATTER EXPERTS
Just to come and train and go
*/

--CREATE TABLE Training.Experts(
--	ExpertID INT PRIMARY KEY,
--	ExpertName NVARCHAR(200),
--	Institution NVARCHAR (200),
--	SubjectMatter NVARCHAR (200)
--);

--INSERT INTO Training.Facilitators
--VALUES
--(1, 'Samuel Dagogo', 'Agriculture'),
--(2, 'Asterix Oberix', 'French Language'),
--(3, 'Apate John', 'Mathematics');

--INSERTING INTO THE EXPERTS TABLE

INSERT INTO Training.Experts
VALUES
(1, 'Samuel Dagogo', 'University of Cambridge', 'Eradication of Erosion' ),
(2, 'Asterix Oberix', 'Abuja Open Universtiy', 'Embracing Foreign Culture'),
(3, 'Chike Obi', 'UNN Unsika', 'Modeling Consumption rate as it affects inflation');
 
