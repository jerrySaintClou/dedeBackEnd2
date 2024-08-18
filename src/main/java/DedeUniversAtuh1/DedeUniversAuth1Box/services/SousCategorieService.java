package DedeUniversAtuh1.DedeUniversAuth1Box.services;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Categorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.SousCategorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.CategorieRepository;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.SousCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousCategorieService {

    @Autowired
    private SousCategorieRepository sousCategorieRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    public List<SousCategorie> recupereTousLesSousCategories() {
        return sousCategorieRepository.findAll();
    }

    public List<SousCategorie> trouverLesSousCategorieDUneCategorie(Categorie categorie){
        return sousCategorieRepository.findByCategorieOrderByIdAsc(categorie);
    }


    public SousCategorie trouveLaSousCategorieAvecSonId(Integer id) {
        return sousCategorieRepository.findById(id).get();
    }

    public SousCategorie metLaSousCategorie(SousCategorie sousCategorie) {
        return sousCategorieRepository.save(sousCategorie);
    }

    public void suppressionDeLaSousCategorie(Integer id) {
        // Supprimez le produit avec l'ID spécifié (utilisez votre propre logique ici)
        sousCategorieRepository.deleteById(id);
    }
}
