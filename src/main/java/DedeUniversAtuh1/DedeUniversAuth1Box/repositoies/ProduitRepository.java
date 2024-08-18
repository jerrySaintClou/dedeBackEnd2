package DedeUniversAtuh1.DedeUniversAuth1Box.repositoies;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Produit;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
    List<Produit> findByNomProduitContaining(String nomProduit);

    List<Produit> findBySousCategorieOrderBySousCategorie_IdAsc(SousCategorie sousCategorie);


    @Query("SELECT COUNT(p) FROM Produit p WHERE p.sousCategorie.id = :sousCategorieId")
    Integer countBySousCategorieId(Integer sousCategorieId);

    List<Produit> findByNomProduitOrderByIdAsc(String nomProduit);

    List<Produit> findByPrixOrderByIdAsc(float prix);

    List<Produit> findByNomProduitOrderByIdDesc(String nomProduit);

    List<Produit> findByPrixOrderByIdDesc(float prix);

    Produit findByNomProduit(String nomProduit);
}

