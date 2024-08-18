package DedeUniversAtuh1.DedeUniversAuth1Box.services;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Produit;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.SousCategorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit findById(Integer id) {
        return produitRepository.findById(id).get();
    }

    public List<Produit> recupereTousLesProduits() {
        return produitRepository.findAll();
    }

    public List<Produit> getByNomProduit(String nomProduit){
        return produitRepository.findByNomProduitContaining(nomProduit);
    }

    public List<Produit> recupereLesProduitDepuisUneSousCategorie(SousCategorie sousCategorie){
        return produitRepository.findBySousCategorieOrderBySousCategorie_IdAsc(sousCategorie);
    }


    public Produit recupereLeProduitParRapportALeurNom(String nomProduit){
        return produitRepository.findByNomProduit(nomProduit);
    }


    public List<Produit> recupereLesProduitParRapportALeurNomEtOrdonner(String nomProduit){
        return produitRepository.findByNomProduitOrderByIdAsc(nomProduit);
    }


    public List<Produit> recupereLesProduitParRapportALeurNomEtDesordonner(String nomProduit){
        return produitRepository.findByNomProduitOrderByIdDesc(nomProduit);
    }

    public List<Produit> recupereLesProduitParRapportALeurPrixEtOrdonner(Float prix){
        return produitRepository.findByPrixOrderByIdAsc(prix);
    }


    public List<Produit> recupereLesProduitParRapportALeurPrixEtDesordonner(Float prix){
        return produitRepository.findByPrixOrderByIdDesc(prix);
    }


    public void suppressionDuProduit(Integer id) {
        // Supprimez le produit avec l'ID spécifié (utilisez votre propre logique ici)
        produitRepository.deleteById(id);
    }

    public Integer donneLeNombreDuProduitDepuisUneSousCategorie(Integer sousCategorieId){
        return produitRepository.countBySousCategorieId(sousCategorieId);
    }
}

