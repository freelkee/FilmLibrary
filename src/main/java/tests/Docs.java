package tests;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ivan Gordeev 22/06/2023
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Docs implements Serializable {
    @SerializedName("docs")
    private List<Media> media;
}
