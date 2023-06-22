package com.filmlibrary.entity.mediafile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Gordeev 07.06.2023
 */

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String name;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "media_genres",
//            joinColumns = @JoinColumn(name = "genre_id"),
//            inverseJoinColumns = @JoinColumn(name = "media_id")
//    )
//    @JsonIgnore
//    private List<Film> media;
}
