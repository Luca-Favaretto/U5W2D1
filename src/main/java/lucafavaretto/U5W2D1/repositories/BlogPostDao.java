package lucafavaretto.U5W2D1.repositories;

import lucafavaretto.U5W2D1.entities.Author;
import lucafavaretto.U5W2D1.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogPostDao extends JpaRepository<BlogPost, UUID> {
}
