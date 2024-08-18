package DedeUniversAtuh1.DedeUniversAuth1Box.repositoies;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Categorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface SousCategorieRepository extends JpaRepository<SousCategorie, Integer>{
    List<SousCategorie> findByCategorieOrderByIdAsc(Categorie categorie);
}
