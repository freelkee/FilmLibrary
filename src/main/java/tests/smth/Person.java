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
public class Person {
    private String photo;
    private String name;
    private String enName;
    private String description;
    private String profession;
    private String enProfession;
}
