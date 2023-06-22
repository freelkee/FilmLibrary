package tests.smth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ivan Gordeev 07.06.2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private List<Trailer> trailers;
}