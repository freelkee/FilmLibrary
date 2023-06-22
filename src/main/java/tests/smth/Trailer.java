package tests.smth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Gordeev 07.06.2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trailer {
    private String url;
    private String name;
    private String site;
    private String type;
}
