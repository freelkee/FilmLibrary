package com.filmlibrary.controller;

import com.filmlibrary.entity.Docs;
import com.filmlibrary.entity.Film;
import com.filmlibrary.repo.FilmRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Ivan Gordeev 06.06.2023
 */


@RestController
@RequestMapping("/api")
public class MainController {
    private final FilmRepo filmRepo;

    public MainController(FilmRepo mediaRepo) {
        this.filmRepo = mediaRepo;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Welcome to the Film library");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) throws IOException {
        Film film = filmRepo.findFilmById(id);
        if (film == null) {
            String params = "id=" + id;
            Docs docs = new Util().getFilmByParams(params);
            film = docs.getFilm().get(0);
            filmRepo.save(film);
        }
        return ResponseEntity.ok(film);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Film>> getFilmsByName(@PathVariable String name) throws IOException {
        List<Film> films = filmRepo.findAllByNameContainingIgnoreCase(name);
        if (films.isEmpty()) {
            String params = "name=" + URLEncoder.encode(name, StandardCharsets.UTF_8);
            Docs docs = new Util().getFilmByParams(params);
            films = filmRepo.saveAll(docs.getFilm());
        }
        return ResponseEntity.ok(films);
    }
}
