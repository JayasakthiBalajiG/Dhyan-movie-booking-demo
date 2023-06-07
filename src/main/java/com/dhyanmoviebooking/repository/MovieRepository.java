package com.dhyanmoviebooking.repository;

import com.dhyanmoviebooking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByMoviename(String moviename);

    //conflicts
    // List<Movie> findByGenre(String genre);

}
