SET SERVEROUTPUT ON;

BEGIN
  FOR rec IN (
    SELECT l.LoanID, l.InterestRate
    FROM Loans l JOIN Customers c ON c.CustomerID = l.CustomerID
    WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
  ) LOOP
    UPDATE Loans SET InterestRate = InterestRate - 1 WHERE LoanID = rec.LoanID;
    DBMS_OUTPUT.PUT_LINE('Discount applied to loan ' || rec.LoanID);
  END LOOP;
END;
/

BEGIN
  FOR rec IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
    UPDATE Customers SET IsVIP = 'Y', LastModified = SYSDATE WHERE CustomerID = rec.CustomerID;
    DBMS_OUTPUT.PUT_LINE('Customer ' || rec.CustomerID || ' promoted to VIP');
  END LOOP;
END;
/

BEGIN
  FOR rec IN (
    SELECT c.Name, l.LoanID, l.EndDate
    FROM Loans l JOIN Customers c ON c.CustomerID = l.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.Name || ', loan ' || rec.LoanID || ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
  END LOOP;
END;
/
