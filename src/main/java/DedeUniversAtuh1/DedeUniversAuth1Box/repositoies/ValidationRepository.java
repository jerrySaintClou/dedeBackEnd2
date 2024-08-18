package DedeUniversAtuh1.DedeUniversAuth1Box.repositoies;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Validation;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.Optional;

public interface ValidationRepository extends CrudRepository<Validation, Integer> {

    Optional<Validation> findByCode(String code);
    void deleteAllByExpirationBefore(Instant now);
}
