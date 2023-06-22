package tests.smth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Gordeev 29.05.2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poster {
    private String url;
    private String previewUrl;
}
