package lucafavaretto.U5W2D1.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.Random;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class Author {
    private long id;
    private String name;
    private String surname;
    private String mail;
    private LocalDate birthdayDate;
    private String avatar;

    public Author(String name, String surname, String mail, LocalDate birthdayDate) {
        Random rndm = new Random();
        this.id = rndm.nextInt(0, 10000);
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.birthdayDate = birthdayDate;
        this.avatar = "https://ui-avatars.com/api/?name=" + name + "+" + surname;
    }
}
