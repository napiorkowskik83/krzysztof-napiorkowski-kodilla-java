ALTER TABLE BOOKS ADD BESTSELLER BOOLEAN;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
	DECLARE RENTS_NO, DAYS, B_ID INT;
    DECLARE RENTSPERMONTH DECIMAL(5,2);
    DECLARE FINISHED INT DEFAULT 0;
	DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED=1;
    OPEN ALL_BOOKS;
    WHILE (FINISHED = 0) DO
	FETCH ALL_BOOKS INTO B_ID;
        IF (FINISHED = 0) THEN
			SELECT COUNT(*) FROM RENTS
				WHERE BOOK_ID = B_ID
					INTO RENTS_NO;
			SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS
				WHERE BOOK_ID = B_ID
					INTO DAYS;
			SET RENTSPERMONTH = RENTS_NO / DAYS * 30;
            IF (RENTSPERMONTH > 2) THEN
				UPDATE BOOKS SET BESTSELLER = TRUE
				WHERE BOOK_ID = B_ID;
				COMMIT;
			ELSE
				UPDATE BOOKS SET BESTSELLER = FALSE
				WHERE BOOK_ID = B_ID;
				COMMIT;
			END IF;
		END IF;
	END WHILE;
	CLOSE ALL_BOOKS;    
END $$

DELIMITER ;
