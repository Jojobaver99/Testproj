package security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import security.domain.Rating;

public interface RatingRepo  extends JpaRepository<Rating, Long> {
Rating findById(int Id);
}
