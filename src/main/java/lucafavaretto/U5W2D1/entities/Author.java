package lucafavaretto.U5W2D1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Random;
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
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthdayDate;
    private String avatar;

}
