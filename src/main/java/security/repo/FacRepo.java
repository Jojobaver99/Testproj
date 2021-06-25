package security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import security.domain.Fac;

public interface FacRepo extends  JpaRepository<Fac, Long> {
	Fac findByName(String name);
}
