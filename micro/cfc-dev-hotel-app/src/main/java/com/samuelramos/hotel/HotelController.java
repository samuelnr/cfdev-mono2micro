package com.samuelramos.hotel;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("hotel")
public class HotelController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> hotels() {
        return Hotel.listAll();
    }

    @GET
    @Path("findbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findById(@QueryParam("id") long id) {
        return Hotel.findById(id);
    }


    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findByTravelOrderId(@QueryParam("travelOrderId") long travelOrderId) {
        return Hotel.findByTravelOrderId(travelOrderId);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel createHotel(Hotel hotel) {
        hotel.id = null;
        hotel.persist();
        return hotel;
    }
    
}
