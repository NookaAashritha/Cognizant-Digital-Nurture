SET SERVEROUTPUT ON;

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    IsVIP CHAR(1) DEFAULT 'N',
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER REFERENCES Customers(CustomerID),
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER REFERENCES Accounts(AccountID),
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER REFERENCES Customers(CustomerID),
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

INSERT INTO Customers VALUES (1, 'John Doe', DATE '1955-05-15', 12000, 'N', SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', DATE '1990-07-20', 1500, 'N', SYSDATE);
INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);
INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, SYSDATE + 20);
INSERT INTO Loans VALUES (2, 2, 8000, 6, SYSDATE, SYSDATE + 60);
INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', DATE '2015-06-15');
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', DATE '2017-03-20');
COMMIT;
