package com.samuelramos.travelorder;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("travelorder")
public class TravelOrderController {
    
    @Inject
    @RestClient
    FlightService flightService;

    @Inject
    @RestClient
    HotelService hotelService;


    @GET
    @Path("findbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder findById(@QueryParam("id") long id) {
        return TravelOrder.findById(id);
    }


    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder createTravelOrder(TravelOrderDTO travelOrderDTO) {

        TravelOrder travelOrder = new TravelOrder();
        travelOrder.id = null;
        travelOrder.persist();

        FlightDTO flight = new FlightDTO();
        flight.setFromAirport(travelOrderDTO.getFromAirport());
        flight.setToAirport( travelOrderDTO.getToAirport());
        flight.setTravelOrderId( travelOrder.id);
        flightService.newFlight(flight);

        HotelDTO hotel = new HotelDTO();
        hotel.setNights(travelOrderDTO.getNights());
        hotel.setTravelOrderId(travelOrder.id);
        hotelService.createHotel(hotel);

        return travelOrder;
    }

    
}
