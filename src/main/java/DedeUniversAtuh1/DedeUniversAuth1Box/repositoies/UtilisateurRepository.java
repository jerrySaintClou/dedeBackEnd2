package DedeUniversAtuh1.DedeUniversAuth1Box.repositoies;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);

    Utilisateur findByNom(String nom);
}
