package DedeUniversAtuh1.DedeUniversAuth1Box.repositoies;

import java.util.List;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer>{
    List<Categorie> findByNomCategorieContaining(String nomCategorie);
}
