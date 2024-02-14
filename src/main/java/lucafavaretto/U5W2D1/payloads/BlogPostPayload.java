package lucafavaretto.U5W2D1.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lucafavaretto.U5W2D1.Genre;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BlogPostPayload {
    private Genre genre;
    private String title;
    private String details;
    private int timeOfLecture;
    private UUID authorId;
}
