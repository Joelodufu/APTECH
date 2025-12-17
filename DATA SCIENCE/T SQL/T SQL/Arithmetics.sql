
-- COMPARISON OPERATORS
SELECT OrganizationLevel, BusinessEntityID, NationalIDNumber FROM HumanResources.Employee
WHERE  NationalIDNumber=245797967  OR OrganizationLevel=3 AND BusinessEntityID=1;