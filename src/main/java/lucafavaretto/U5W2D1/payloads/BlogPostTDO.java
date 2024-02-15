package lucafavaretto.U5W2D1.payloads;

import jakarta.validation.constraints.*;
import lucafavaretto.U5W2D1.Genre;

public record BlogPostTDO(


        Genre genre,
        @NotEmpty(message = "Title is obligatory")
        @Size(min = 3, max = 20, message = "The length of title id between 3 and 20 char")
        String title,
        @NotEmpty(message = "Details is obligatory")
        @Size(min = 3, max = 255, message = "The length of title id between 3 and 255 char")
        String details,

        @Max(value = 10000, message = "Max time of lecture is 10000 minutes")
        @Min(value = 10, message = "Min time of lecture is 10 minutes")
        int timeOfLecture,

        @NotEmpty(message = "authorId is obligatory")
        @Size(min = 36, max = 36, message = "The length of authorId is 36")
        @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")
        String authorId

) {
}
