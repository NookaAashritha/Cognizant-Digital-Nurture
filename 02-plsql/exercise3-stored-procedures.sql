CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE Accounts
  SET Balance = Balance * 1.01, LastModified = SYSDATE
  WHERE AccountType = 'Savings';
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_department IN VARCHAR2, p_bonus_percent IN NUMBER) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_percent / 100)
  WHERE Department = p_department;
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(p_from_account IN NUMBER, p_to_account IN NUMBER, p_amount IN NUMBER) AS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;
  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
  END IF;
  UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_from_account;
  UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_to_account;
  INSERT INTO Transactions VALUES ((SELECT NVL(MAX(TransactionID), 0) + 1 FROM Transactions), p_from_account, SYSDATE, p_amount, 'Withdrawal');
  INSERT INTO Transactions VALUES ((SELECT NVL(MAX(TransactionID), 0) + 1 FROM Transactions), p_to_account, SYSDATE, p_amount, 'Deposit');
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END;
/
