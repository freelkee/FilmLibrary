package com.filmlibrary.entity;

import com.filmlibrary.entity.mediafile.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ivan Gordeev 06.06.2023
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film implements Serializable {
    @Id
    private Long id;
    private int movieLength;
    private String type;
    private String name;
    private int year;
    private int ageRating;

    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;

    @OneToOne(cascade = CascadeType.ALL)
    private Poster poster;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "media_genres",
//            joinColumns = @JoinColumn(name = "media_id"),
//            inverseJoinColumns = @JoinColumn(name = "genre_id")
//    )
//    private List<Genre> genres;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "media_person",
//            joinColumns = @JoinColumn(name = "media_id"),
//            inverseJoinColumns = @JoinColumn(name = "person_id")
//    )
//    private List<Person> persons;
}
