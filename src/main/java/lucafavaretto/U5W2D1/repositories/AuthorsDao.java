package lucafavaretto.U5W2D1.repositories;

import lucafavaretto.U5W2D1.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorsDao extends JpaRepository<Author, UUID> {
    boolean existsByEmail(String email);
}
