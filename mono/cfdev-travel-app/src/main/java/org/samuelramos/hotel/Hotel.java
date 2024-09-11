package org.samuelramos.hotel;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Hotel extends PanacheEntity {

    public long travelOrderId;
    public Integer nights;


}
