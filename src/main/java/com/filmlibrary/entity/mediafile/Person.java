package com.filmlibrary.entity.mediafile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Ivan Gordeev 07.06.2023
 */

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private Long id;
    private String photo;
    private String name;
    private String enName;
    private String description;
    private String profession;
    private String enProfession;
}
