package lucafavaretto.U5W2D1.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AuthorTDO(
        @NotEmpty(message = "Name is obligatory")
        @Size(min = 3, max = 20, message = "The length of title id between 3 and 20 char")
        String name,
        @NotEmpty(message = "Surname is obligatory")
        @Size(min = 3, max = 20, message = "The length of title id between 3 and 20 char")
        String surname,
        @Email(message = "email is obligatory")
        String email,
        @NotNull(message = "Date is obligatory")
        LocalDate birthdayDate

) {
}
