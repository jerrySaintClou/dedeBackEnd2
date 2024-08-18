package DedeUniversAtuh1.DedeUniversAuth1Box.controllers;


import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Categorie;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/categorie")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("/tousLesCategories")
    public ResponseEntity<List<Categorie>> getAllCategories(@RequestParam(required = false) String nomCategorie) {

        try {
            List<Categorie> categories = new ArrayList<>();
            if (nomCategorie == null || nomCategorie.trim().isEmpty()) {
                categorieService.recupereTousLesCategories().forEach(categories::add);
            } else {
                categorieService.getByNomCategorie(nomCategorie).forEach(categories::add);
            }
            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
//            for(Categorie categorie: categories){
//                categorie.getSousCategorie().forEach(p->p.setCategorie(null));
//            }
            return new ResponseEntity<>(categories, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id) {
        try{
            if (id <= 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                Categorie categorie = categorieService.trouveLaCategorieAvecSonId(id);
//                produit.getImageProduits().forEach(p->p.setProduit(null));
                return new ResponseEntity<>(categorie, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/ajout")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie){
        try {
            if (categorie == null
                    || categorie.getNomCategorie() == null || categorie.getNomCategorie().trim().isEmpty()
            ) {

                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            Categorie _categorie = categorieService.save(categorie);
            if (_categorie != null) {
                return new ResponseEntity<>(_categorie, HttpStatus.CREATED);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }




    @PutMapping("/modif")
    public ResponseEntity<String>updateProduit(@RequestBody Categorie categorie){
        try {
            if (categorie == null
                    || categorie.getNomCategorie() == null || categorie.getNomCategorie().trim().isEmpty()
            ) {

                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            Categorie _categorie = categorieService.save(categorie);
            if (_categorie != null) {
                return new ResponseEntity<String>("Le produit a pu etre modifier!", HttpStatus.CREATED);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @DeleteMapping("/suppressions/{id}")
    public ResponseEntity<String> removeBook(@PathVariable("id") Integer id) {

        try {
            if (id <= 0) {
                return new ResponseEntity<String>("Erreur : L'id du book à supprimer doit être > 0 !",
                        HttpStatus.BAD_REQUEST);
            }
            categorieService.suppressionDeLaCategorie(id);
            return new ResponseEntity<String>("Suppression du book avec id = '" + id + "' effectuée avec succès.",
                    HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
