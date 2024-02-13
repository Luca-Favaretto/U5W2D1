package lucafavaretto.U5W2D1.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.Random;

@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
public class Author {
    private long id;
    private String name;
    private String surname;
    private String mail;
    private LocalDate birthdayDate;
    private String avatar;
    
}
