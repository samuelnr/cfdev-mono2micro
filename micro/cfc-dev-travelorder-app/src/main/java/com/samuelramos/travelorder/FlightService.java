package com.samuelramos.travelorder;

import java.time.temporal.ChronoUnit;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8081/flight")
public interface FlightService {

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public FlightDTO findById(@QueryParam("id") long id);

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(unit = ChronoUnit.SECONDS , value = 2)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
        requestVolumeThreshold =  4 ,
        failureRatio = 0.5 ,
        delay = 5000 ,
        successThreshold = 2
    )
    public FlightDTO findByTravelOrderId(@QueryParam("travelOrderId") long travelOrderId);

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public FlightDTO newFlight(FlightDTO flight);

    default FlightDTO fallback(long travelOrderId) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFromAirport("");
        flightDTO.setToAirport("");
        flightDTO.setTravelOrderId(travelOrderId);
        return flightDTO;
    }
}
