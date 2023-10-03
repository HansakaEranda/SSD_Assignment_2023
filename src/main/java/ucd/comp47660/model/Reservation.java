package ucd.comp47660.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String email;

    @NotNull
    private Long flight_reference;

    @NotNull
    private boolean cancelled;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    private Guest guest;


    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    private User user;


    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Flight flight;


    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private CreditCard credit_card;


    @ToString.Exclude
    @OneToMany(mappedBy = "reservation")
    @JsonIgnore
    private List<Passenger> passengers = new ArrayList<>();

    public Reservation() {
        super();
    }

    public Reservation(Long id, String email, Long flight_reference) {
        this.id = id;
        this.email = email;
        this.flight_reference = flight_reference;
        this.cancelled = false;
    }

    // Change the return type to provide a defensive copy or an unmodifiable list.
    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    // Add a method to add passengers to the list.
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // Add a method to remove passengers from the list.
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
}
