create sequence travelorder_sequence start with 1 increment by 1;
insert into travelOrder(id) values (nextval('travelorder_sequence'));
insert into travelOrder(id) values (nextval('travelorder_sequence'));
insert into travelOrder(id) values (nextval('travelorder_sequence'));
insert into travelOrder(id) values (nextval('travelorder_sequence'));
insert into travelOrder(id) values (nextval('travelorder_sequence'));

create sequence flight_sequence start with 1 increment by 1;
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),1,'REC','RJ');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),2,'REC','JUV');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),3,'SIP','ALG');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),4,'REC','GALEAO-RJ');
INSERT INTO flight (id, travelOrderId , fromAirport, toAirport) values (nextval('flight_sequence'),5,'PEC','GALEAO-RJ');

create sequence hotel_sequence start with 1 increment by 1;
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 1,5);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 2,2);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 3,1);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 4,3);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 5,4);
