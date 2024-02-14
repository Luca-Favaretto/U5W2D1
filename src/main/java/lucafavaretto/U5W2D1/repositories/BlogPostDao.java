package lucafavaretto.U5W2D1.repositories;

import lucafavaretto.U5W2D1.entities.Author;
import lucafavaretto.U5W2D1.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface BlogPostDao extends JpaRepository<BlogPost, UUID> {
}
