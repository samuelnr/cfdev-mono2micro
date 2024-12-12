package com.samuelramos.travelorder;

public class TravelOrderDTO {

    private String fromAirport;
    private String toAirport;
    private Integer nights;
    private long id;

    

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }



    private TravelOrderDTO(long travelOrderId , String fromAirport , String toAirport, Integer nights) {
        this.id = travelOrderId;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.nights = nights;
    }

    public TravelOrderDTO() {

    }

    public static TravelOrderDTO of(TravelOrder order, FlightDTO flight, HotelDTO hotel) {

        if (flight == null) {
            flight = new FlightDTO();
        }

        if (hotel == null) {
            hotel = new HotelDTO();
        }

        return new TravelOrderDTO(order.id , flight.getFromAirport(), flight.getToAirport(), hotel.getNights());
    }

    public static TravelOrderDTO of(long travelOrderId , String fromAirport, String toAirport, Integer nights) {
        return new TravelOrderDTO(travelOrderId , fromAirport, toAirport, nights);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}