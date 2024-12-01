package com.samuelramos.travelorder;

public class HotelDTO {

    private long travelOrderId;
    private Integer nights;

    public long getTravelOrderId() {
        return travelOrderId;
    }
    public void setTravelOrderId(long travelOrderId) {
        this.travelOrderId = travelOrderId;
    }
    public Integer getNights() {
        return nights;
    }
    public void setNights(Integer nights) {
        this.nights = nights;
    }
 }