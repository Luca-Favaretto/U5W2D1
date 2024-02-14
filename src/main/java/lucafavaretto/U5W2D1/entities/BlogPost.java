package lucafavaretto.U5W2D1.entities;

import jakarta.persistence.*;
import lombok.*;
import lucafavaretto.U5W2D1.Genre;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;
    private Genre genre;
    private String title;
    private String cover;
    private String details;
    @Column(name = "time_of_lecture")
    private int timeOfLecture;


}
