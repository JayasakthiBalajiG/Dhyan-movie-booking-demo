package com.dhyanmoviebooking.controller;

import com.dhyanmoviebooking.model.Movie;
import com.dhyanmoviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("api/movie")
@RestController
public class MovieController {

    //dependency injection
     @Autowired
     MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("{name}")
    public ResponseEntity <List<Movie>> getMoviesByName(@PathVariable("name") String moviename){
        System.out.println(moviename);
        return ResponseEntity.ok(movieRepository.findByMoviename(moviename));
    }
//conflicts here so user ?(see)
//    @GetMapping("{genre}")
//    public ResponseEntity <List<Movie>> getMoviesByGenre(@PathVariable("genre")String genre){
//        return ResponseEntity.ok(movieRepository.findByGenre(genre));
//    }

    record NewMovieRequest(
            Integer movieid,
            String moviename,
            String moviedirector,
            String genre,
            LocalDate releasedate
    ){}

    @PostMapping
    public void AddMovie(@RequestBody NewMovieRequest request){
        Movie movie = new Movie();
        movie.setMovieid(request.movieid());
        movie.setMoviename(request.moviename());
        movie.setMoviedirector(request.moviedirector());
        movie.setGenre(request.genre());
        movie.setReleasedate(request.releasedate());
        movieRepository.save(movie);
//        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{movie_id}")
    public void DeleteMovie(@PathVariable("movie_id") Integer movie_id){
        movieRepository.deleteById(movie_id);
    }

}
