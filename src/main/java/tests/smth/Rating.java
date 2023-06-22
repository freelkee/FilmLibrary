package tests.smth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Gordeev 06.06.2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private double kp;
    private double imdb;
    private double filmCritics;
}
