package security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import security.domain.Certificate;

public interface CertificateRepo extends  JpaRepository<Certificate, Long> {

}
