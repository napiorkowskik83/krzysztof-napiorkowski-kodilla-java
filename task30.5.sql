CREATE TABLE STATS (
	STAT_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	STAT_DATE DATETIME NOT NULL,
	STAT VARCHAR(20) NOT NULL,
	VALUE INT(11) NOT NULL
);

CREATE VIEW BESTSELLERS_COUNT AS
SELECT COUNT(*) AS BESTSELLERS_NO FROM BOOKS
WHERE BESTSELLER = TRUE;


DELIMITER $$

CREATE EVENT UPDATE_STATS
ON SCHEDULE EVERY 1 DAY
DO
BEGIN
	DECLARE BESTSELLERS_NO INT;
	CALL UpdateBestsellers();
	SELECT * FROM BESTSELLERS_COUNT
	INTO BESTSELLERS_NO;
	INSERT INTO STATS(STAT_DATE, STAT, VALUE)
		VALUES(CURTIME(), "BESTSELLERS", BESTSELLERS_NO);
	COMMIT;
END $$

DELIMITER ;