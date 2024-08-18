package DedeUniversAtuh1.DedeUniversAuth1Box.controllers;


import DedeUniversAtuh1.DedeUniversAuth1Box.entites.ImageProduit;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Produit;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.ImageProduitService;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/imageProduit")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class ImageProduitController {
    @Autowired
    ImageProduitService imageProduitService;

    @Autowired
    ProduitService produitService;

    @GetMapping("/all")
    public ResponseEntity<List<ImageProduit>> getAllImageProduits( ) {

        try {
            List<ImageProduit> imageProduits = new ArrayList<>();
            imageProduitService.recupereTousLesImageProduits().forEach(imageProduits::add);

            if (imageProduits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

//            for(ImageProduit imageProduit:imageProduits){
//                imageProduit.getProduit().setImageProduits(null);
//            }
            return new ResponseEntity<>(imageProduits, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//
//    @GetMapping("/trouverLesImagesDuDernierProduit/{produitId}")
//    public ResponseEntity<List<ImageProduit>> allImagesForProduct(@PathVariable Integer produitId){
//        try {
//            Produit produit = produitService.findById(produitId);
//            List<ImageProduit> imageProduits =imageProduitService.trouverLesImageDunProduit(produit);
////            for(ImageProduit imageProduit: imageProduits){
////                imageProduit.getProduit().setImageProduits(null);
////            }
//            return new ResponseEntity<>(imageProduits, HttpStatus.OK);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/ajout/{produitId}")
//    public ResponseEntity<ImageProduit> addImageProduit(@RequestBody ImageProduit imageProduit, @PathVariable Integer produitId) {
//
//        try {
//            if (imageProduit == null || imageProduit.getCheminImageProduit() == null || imageProduit.getCheminImageProduit().trim().isEmpty())
//            {
//
//                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//            }
//            Produit produit = produitService.findById(produitId);
//            imageProduit.setProduit(produit);
//            ImageProduit _imageProduit = imageProduitService.metLeImageProduit(imageProduit);
////            for(ImageProduit imageProduit2: _imageProduit.getProduit().getImageProduits()){
////                imageProduit2.setProduit(null);
////            }
//            if (_imageProduit != null) {
//                return new ResponseEntity<>(_imageProduit, HttpStatus.CREATED);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//
//    @PutMapping("/modif")
//    public ResponseEntity<ImageProduit>updateImageProduit(@RequestBody ImageProduit imageProduit){
//        try{
//            if (imageProduit == null
//                    || imageProduit.getCheminImageProduit() == null || imageProduit.getCheminImageProduit().trim().isEmpty()
//            ) {
//
//                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//            }
//            ImageProduit _imageProduit = imageProduitService.metLeImageProduit(imageProduit);
////            for(ImageProduit imageProduit2: _imageProduit.getProduit().getImageProduits()){
////                imageProduit2.setProduit(null);
////            }
//            if (_imageProduit != null) {
//                return new ResponseEntity<>(_imageProduit, HttpStatus.CREATED);
//            }
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @DeleteMapping("/suppressions/{id}")
    public ResponseEntity<String> removeImageProduit(@PathVariable("id") Integer id) {

        try {
            if (id <= 0) {
                return new ResponseEntity<String>("Erreur : L'id du ImageProduit à supprimer doit être > 0 !",
                        HttpStatus.BAD_REQUEST);
            }
            imageProduitService.suppressionDeLImageDuProduit(id);
            return new ResponseEntity<String>("Suppression du ImageProduit avec id = '" + id + "' effectuée avec succès.",
                    HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
