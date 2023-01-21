INSERT INTO benutzer (name, email) VALUES
	('DummyUser', 'dummy@dummy.com'),
	('Alan Turing', 'alan@turing.com'),
	('DonaldEKnuth', 'donald@eKnuth.com'),
	('Tim Berners Lee', 'tim@bernersLee.com'),
	('Edsger Dijkstra', 'edsger@dijkstra.com'),
	('Whitifield Delfi', 'whitifield@delfi.com'),
	('Martin Hellman', 'martin@hellman.com'),
	('Geoffrey Hinton', 'geoffrey@hinton.com')
;

INSERT INTO fahrerlaubnis (fahrer, ablaufdatum) VALUES
	(1,'2035-06-30-23.59.59.000000'),
	(3, '2035-06-30-23.59.59.000000'),
	(5, '2036-09-30-23.59.59.000000'),
	(7, '2036-09-30-23.59.59.000000')
;

INSERT INTO transportmittel (name, icon) VALUES
	('Auto', 'pfad/icons/auto.png'),
	('Bus', 'pfad/icons/bus.png'),
	('Kleintransporter', 'pfad/icons/kleintransporter.png')
;

INSERT INTO fahrt (startort, zielort, fahrtdatumzeit, maxPlaetze, fahrtkosten, anbieter, transportmittel, beschreibung)  VALUES
	('Duisburg', 'Hamburg', '2022-02-10-10.00.00.000000', 6, 20, 1, 1, NULL),
	('Berlin Hauptbahnhof', 'Essen', '2022-02-02-08.00.00.000000', 2, 25, 1, 1, NULL),
	('Berlin Flughafen', 'München', '2022-02-12-15.00.00.000000', 5, 30, 3, 2, NULL),
	('Berliner Dom', 'Stuttgart', '2022-02-12-11.30.00.000000', 10, 35, 1, 3, 'Busfahrt vom Berliner Dom nach Stuttgart.'),
	('Duisburg-Neudorf', 'Essen-Miite', '2022-02-18-12.30.00.000000', 4, 5, 3, 1, 'Kurzfahrt von DU nach E über A40')
;

INSERT INTO bewertung (textnachricht, erstellungsdatum, rating) VALUES
	('Sehr gute Fahrt', '2022-02-12-14.00.00.000000', 5),
	('fuhr sehr angenehm', '2022-02-12-16.00.00.000000', 5),
	('Langweilig aber ok', '2022-02-12-18.00.00.000000', 3),
	('war toll', '2022-02-20-14.00.00.000000', 5),
	('Ok', '2022-02-12-20.00.00.000000', 3),
	('Gut!', '2022-02-20-18.00.00.000000', 4),
	('Mies', '2022-02-15-18.00.00.000000', 2),
	('Wurden von Polizei angehalten, weil zu schnell', '2022-02-16-19.00.00.000000', 1),
	('Fahrer kam viel zu spät', '2022-02-22-11.00.00.000000', 1)
;

INSERT INTO reservieren (kunde, fahrt, anzPlaetze) VALUES
	(2, 1, 2),
	(3, 1, 1),
	(4, 1, 2),
	(5, 4, 1),
	(6, 4, 1),
	(7, 4, 1),
	(1, 3, 1),
	(2, 3, 1),
	(6, 5, 1)
;

INSERT INTO schreiben (benutzer, fahrt, bewertung) VALUES
	(2, 1, 1),
	(3, 1, 2),
	(4, 1, 3),
	(5, 4, 4),
	(6, 4, 5),
	(7, 4, 6),
	(1, 3, 7),
	(2, 3, 8),
	(6, 5, 9)
;