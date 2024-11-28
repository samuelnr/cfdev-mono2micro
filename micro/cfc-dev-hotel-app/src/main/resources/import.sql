create sequence hotel_sequence start with 1 increment by 1;
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 1,5);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 2,2);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 3,1);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 4,3);
INSERT INTO HOTEL(ID, travelOrderId, nights) values (nextval('hotel_sequence'), 5,4);
