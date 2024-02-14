package lucafavaretto.U5W2D1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthdayDate;
    private String avatar;


    public Author(String name, String surname, String email, LocalDate birthdayDate, String avatar) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdayDate = birthdayDate;
        this.avatar = avatar;
    }
}
