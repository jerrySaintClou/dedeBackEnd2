package DedeUniversAtuh1.DedeUniversAuth1Box.controllers;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Categorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.SousCategorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.CategorieService;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/sousCategorie")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class SousCategorieController {
    @Autowired
    SousCategorieService sousCategorieService;

    @Autowired
    CategorieService categorieService;

    @GetMapping("/all")
    public ResponseEntity<List<SousCategorie>> getAllSousCategories( ) {

        try {
            List<SousCategorie> sousCategories = new ArrayList<>();
            sousCategorieService.recupereTousLesSousCategories().forEach(sousCategories::add);

            if (sousCategories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

//            for(ImageProduit imageProduit:imageProduits){
//                imageProduit.getProduit().setImageProduits(null);
//            }
            return new ResponseEntity<>(sousCategories, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/trouverLesSousCategorieDunCategorie/{categorieId}")
    public ResponseEntity<List<SousCategorie>> allImagesForProduct(@PathVariable Integer categorieId){
        try {
            Categorie categorie = categorieService.trouveLaCategorieAvecSonId(categorieId);
            List<SousCategorie> imageProduits =sousCategorieService.trouverLesSousCategorieDUneCategorie(categorie);
//            for(ImageProduit imageProduit: imageProduits){
//                imageProduit.getProduit().setImageProduits(null);
//            }
            return new ResponseEntity<>(imageProduits, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/ajout/{categorieId}")
    public ResponseEntity<SousCategorie> addSousCategorie(@RequestBody SousCategorie sousCategorie, @PathVariable Integer categorieId) {

        try {
            if (sousCategorie == null || sousCategorie.getNomSousCategorie() == null || sousCategorie.getNomSousCategorie().trim().isEmpty())
            {

                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            Categorie categorie = categorieService.trouveLaCategorieAvecSonId(categorieId);
            sousCategorie.setCategorie(categorie);
            SousCategorie _sousCategorie = sousCategorieService.metLaSousCategorie(sousCategorie);
//            for(ImageProduit imageProduit2: _imageProduit.getProduit().getImageProduits()){
//                imageProduit2.setProduit(null);
//            }
            if (_sousCategorie != null) {
                return new ResponseEntity<>(_sousCategorie, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping("/modif")
    public ResponseEntity<SousCategorie>updateSousCategorie(@RequestBody SousCategorie sousCategorie) {
        try {
            if (sousCategorie == null || sousCategorie.getNomSousCategorie() == null || sousCategorie.getNomSousCategorie().trim().isEmpty())
            {

                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            SousCategorie _sousCategorie = sousCategorieService.metLaSousCategorie(sousCategorie);
//            for(ImageProduit imageProduit2: _imageProduit.getProduit().getImageProduits()){
//                imageProduit2.setProduit(null);
//            }
            if (_sousCategorie != null) {
                return new ResponseEntity<>(_sousCategorie, HttpStatus.CREATED);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/suppressions/{id}")
    public ResponseEntity<String> removeSousCategorie(@PathVariable("id") Integer id) {

        try {
            if (id <= 0) {
                return new ResponseEntity<String>("Erreur : L'id de la SousCategorie à supprimer doit être > 0 !",
                        HttpStatus.BAD_REQUEST);
            }
            sousCategorieService.suppressionDeLaSousCategorie(id);
            return new ResponseEntity<String>("Suppression de la SousCategorie avec id = '" + id + "' effectuée avec succès.",
                    HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
