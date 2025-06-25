USE AdventureWorks2022;
DECLARE @EmployeeID INT =2;
DECLARE @IsSalaried BIT;

SELECT @IsSalaried = SalariedFlag FROM HumanResources.Employee
WHERE BusinessEntityID= @EmployeeID;

IF @IsSalaried =1
	SELECT 'The Employee Is Paid Monthly' AS PaymentPlan;
ELSE IF @IsSalaried =0
	SELECT 'The Emplee is paid Hourly' AS PaymentPlan;