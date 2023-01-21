CREATE TABLE benutzer (
	bid SMALLINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
  	email VARCHAR(50) NOT NULL UNIQUE,
  	PRIMARY KEY (bid)
);

CREATE TABLE fahrerlaubnis (
  	fahrer SMALLINT NOT NULL,
  	nummer SMALLINT NOT NULL AUTO_INCREMENT,
  	ablaufdatum timestamp NOT NULL,
  	PRIMARY KEY (nummer),
  	FOREIGN KEY (fahrer) REFERENCES benutzer(bid)
);

CREATE TABLE transportmittel (
  	tid SMALLINT NOT NULL AUTO_INCREMENT,
  	name VARCHAR(50) NOT NULL,
  	icon VARCHAR(50) NOT NULL,
  	PRIMARY KEY (tid)
);

CREATE TABLE bewertung (
  	beid SMALLINT NOT NULL AUTO_INCREMENT,
  	textnachricht TEXT NOT NULL,
  	erstellungsdatum timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  	rating SMALLINT NOT NULL CHECK (rating BETWEEN 1 AND 5),
  	PRIMARY KEY (beid)
);

CREATE TABLE fahrt (
  	fid SMALLINT NOT NULL AUTO_INCREMENT,
  	startort VARCHAR(100) NOT NULL,
  	zielort VARCHAR(100) NOT NULL,
  	fahrtdatumzeit timestamp NOT NULL,
	maxPlaetze SMALLINT NOT NULL CHECK (maxPlaetze BETWEEN 1 AND 10),
	fahrtkosten DECIMAL(10,2) NOT NULL,
	status VARCHAR(11) NOT NULL CHECK (status IN ('offen', 'geschlossen')) DEFAULT 'offen',
  	anbieter SMALLINT NOT NULL,
  	transportmittel SMALLINT NOT NULL,
  	beschreibung TEXT,
  	PRIMARY KEY (fid),
  	FOREIGN KEY (anbieter) REFERENCES benutzer(bid),
  	FOREIGN KEY (transportmittel) REFERENCES transportmittel(tid)
);

CREATE TABLE reservieren (
  	kunde SMALLINT NOT NULL,
  	fahrt SMALLINT NOT NULL,
  	anzPlaetze SMALLINT NOT NULL CHECK (anzPlaetze BETWEEN 1 AND 2),
  	PRIMARY KEY (kunde, fahrt),
  	FOREIGN KEY (kunde) REFERENCES benutzer(bid),
  	FOREIGN KEY (fahrt) REFERENCES fahrt(fid)
);

CREATE TABLE schreiben (
  	benutzer SMALLINT NOT NULL,
  	fahrt SMALLINT NOT NULL,
  	bewertung SMALLINT NOT NULL,
  	PRIMARY KEY (benutzer, fahrt),
  	FOREIGN KEY (benutzer) REFERENCES benutzer(bid),
  	FOREIGN KEY (fahrt) REFERENCES fahrt(fid),
  	FOREIGN KEY (bewertung) REFERENCES bewertung(beid)
);