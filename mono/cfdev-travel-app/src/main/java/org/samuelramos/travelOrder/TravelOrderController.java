package org.samuelramos.travelOrder;

import java.util.List;
import java.util.stream.Collectors;

import org.samuelramos.flight.Flight;
import org.samuelramos.flight.FlightController;
import org.samuelramos.hotel.Hotel;
import org.samuelramos.hotel.HotelController;

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
    FlightController flightController;

    @Inject
    HotelController hotelController;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders() {
 
        return TravelOrder.<TravelOrder>listAll().stream()
            .map(travelOrder -> TravelOrderDTO.of(
                                    travelOrder , 
                                    flightController.findByTravelOrderId(travelOrder.id) ,
                                    hotelController.findByTravelOrderId(travelOrder.id) )
            ).collect(Collectors.toList());

    }

    @GET
    @Path("findbyId")
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
        Flight flight = new Flight();
        flight.fromAirport = travelOrderDTO.getFromAirport();
        flight.toAirport = travelOrderDTO.getToAirport();
        flight.travelOrderId = travelOrder.id;
        flightController.createFlight(flight);

        Hotel hotel = new Hotel();
        hotel.nights = travelOrderDTO.getNights();
        hotel.travelOrderId = travelOrder.id;
        hotelController.createHotel(hotel);

        return travelOrder;
    }
    
}
