DELIMITER //
CREATE TRIGGER statusupdate AFTER INSERT ON reservieren
FOR EACH ROW
BEGIN
	DECLARE maxPlaetze SMALLINT;
	DECLARE bisherReserviertePlaetze SMALLINT;
	SET maxPlaetze = (select maxPlaetze from fahrt f where f.fid = NEW.fahrt);
	SET bisherReserviertePlaetze = (select sum(anzPlaetze) from reservieren r where r.fahrt = NEW.fahrt);
	IF bisherReserviertePlaetze = maxPlaetze THEN
		UPDATE fahrt SET status = 'geschlossen' where fid = NEW.fahrt;
	END IF;
END; 
//