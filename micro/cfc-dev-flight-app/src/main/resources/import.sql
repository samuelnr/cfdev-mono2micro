create sequence flight_sequence start with 1 increment by 1;
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),1,'REC','RJ');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),2,'REC','JUV');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),3,'SIP','ALG');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),4,'REC','GALEAO-RJ');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),5,'PEC','GALEAO-RJ');