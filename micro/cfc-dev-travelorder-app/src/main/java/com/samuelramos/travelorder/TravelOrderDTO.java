package com.samuelramos.travelorder;

public class TravelOrderDTO {

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

    private String fromAirport;
    private String toAirport;
    private Integer nights;

    private TravelOrderDTO(String fromAirport , String toAirport, Integer nights) {
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

        return new TravelOrderDTO(flight.getFromAirport(), flight.getToAirport(), hotel.getNights());
    }

    public static TravelOrderDTO of(String fromAirport, String toAirport, Integer nights) {
        return new TravelOrderDTO(fromAirport, toAirport, nights);
    }
    
}