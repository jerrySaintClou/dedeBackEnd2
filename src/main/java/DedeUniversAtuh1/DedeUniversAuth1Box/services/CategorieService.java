package DedeUniversAtuh1.DedeUniversAuth1Box.services;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Categorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public List<Categorie> recupereTousLesCategories() {
        return categorieRepository.findAll();
    }


    public Categorie trouveLaCategorieAvecSonId(Integer id) {
        return categorieRepository.findById(id).get();
    }


    public List<Categorie> getByNomCategorie(String nomCategorie){
        return categorieRepository.findByNomCategorieContaining(nomCategorie);
    }

    public void suppressionDeLaCategorie(Integer id) {
        // Supprimez le produit avec l'ID spécifié (utilisez votre propre logique ici)
        categorieRepository.deleteById(id);
    }
}
