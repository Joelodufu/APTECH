USE AdventureWorks2022;
--IF AND ELSE IF
DECLARE @Score INT;
SET @Score = 25;
IF @Score>=70
	SELECT 'A' AS Grade;
ELSE IF @Score >= 60
	SELECT 'B' AS Grade;
ELSE IF @Score >= 50
	SELECT 'C' AS Grade;
ELSE IF @Score >= 40
	SELECT 'D' AS Grade;
ELSE IF @Score >= 30
	SELECT 'E' AS Grade;
ELSE
	SELECT 'F' AS Grade;


