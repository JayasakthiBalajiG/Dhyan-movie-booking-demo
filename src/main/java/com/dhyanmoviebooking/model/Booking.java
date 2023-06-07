package com.dhyanmoviebooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @SequenceGenerator(
            name = "booking_id_sequence",
            sequenceName = "booking_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_id_sequence"
    )
    private int bookingid;
    private int movieid;
    private int userid;

}
