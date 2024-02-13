package lucafavaretto.U5W2D1.entities;

import lombok.*;
import lucafavaretto.U5W2D1.Genre;

import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class BlogPost {
    private long id;
    private Genre genre;
    private String title;
    private String cover;
    private String details;
    private int timeOfLecture;

}
