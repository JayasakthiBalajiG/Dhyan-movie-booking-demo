package com.dhyanmoviebooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_id_sequence",
            sequenceName = "movie_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_id_sequence"
    )
    private Integer movieid;
    private String moviename;
    private String moviedirector;
    private String genre;
    private LocalDate releasedate;
}
