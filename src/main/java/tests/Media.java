package tests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Ivan Gordeev 06.06.2023
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Media implements Serializable {
    private Long id;
    private String name;
    private String type;
}
