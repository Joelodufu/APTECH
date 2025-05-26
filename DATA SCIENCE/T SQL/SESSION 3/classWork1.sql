/* tsqllint-disable error select-star */
/* tsqllint-disable error schema-qualify */
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
SET NOCOUNT ON;

CREATE TABLE EmeraldEmployee (
    EmployeeID INT NOT NULL PRIMARY KEY,
    FirstName NVARCHAR(50) NOT NULL,
    LastName NVARCHAR(50) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Phone NVARCHAR(15) NULL,
    HireDate DATETIME NOT NULL DEFAULT GETDATE(),
    Salary DECIMAL(18, 2) NOT NULL CHECK (Salary > 0)
);

CREATE TABLE EmeraldDepartment (
    DepartmentID INT NOT NULL PRIMARY KEY,
    DepartmentName NVARCHAR(100) NOT NULL UNIQUE,
    Location NVARCHAR(100) NULL
);

CREATE TABLE EmeraldProject (
    ProjectID INT NOT NULL PRIMARY KEY,
    ProjectName NVARCHAR(100) NOT NULL UNIQUE,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME NULL,
    Budget DECIMAL(18, 2) NOT NULL CHECK (Budget >= 0)
);

CREATE TABLE EmeraldEmployeeProject (
    EmployeeID INT NOT NULL,
    ProjectID INT NOT NULL,
    Role NVARCHAR(50) NOT NULL,
    PRIMARY KEY (EmployeeID, ProjectID),
    FOREIGN KEY (EmployeeID) REFERENCES EmeraldEmployee(EmployeeID),
    FOREIGN KEY (ProjectID) REFERENCES EmeraldProject(ProjectID)
);