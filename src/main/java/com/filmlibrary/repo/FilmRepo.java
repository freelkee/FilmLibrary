package com.filmlibrary.repo;

import com.filmlibrary.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Long> {
    Film findFilmById(Long id);
    List<Film> findAllByNameContainingIgnoreCase(String name);
}
