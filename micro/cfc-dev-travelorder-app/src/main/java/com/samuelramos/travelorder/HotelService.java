package com.samuelramos.travelorder;

import java.time.temporal.ChronoUnit;
import java.util.List;

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

@RegisterRestClient(baseUri = "http://localhost:8082/hotel")
public interface HotelService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HotelDTO> hotels();

    @GET
    @Path("findbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public HotelDTO findById(@QueryParam("id") long id);


    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(unit = ChronoUnit.SECONDS, value = 2)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
        requestVolumeThreshold= 4 , // A cada 4 requisiçoes
        failureRatio = 0.5 , // E se houver 50% das requisicoes , circuito será aberto
        delay = 5000 , // Aguarde 5 s
        successThreshold = 2  // Quando houver 2 tentativas bem sucedidas fecha o circuito voltando a normalidade
    )
    public HotelDTO findByTravelOrderId(@QueryParam("travelOrderId") long travelOrderId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HotelDTO createHotel(HotelDTO hotel);

    default HotelDTO fallback(long travelOrderId) {
        HotelDTO hotel = new HotelDTO();
        hotel.setNights(-1);
        hotel.setTravelOrderId(travelOrderId);
        return hotel;
    }
}
