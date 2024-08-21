package DedeUniversAtuh1.DedeUniversAuth1Box.controllers;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Avis;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Produit;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.AvisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/avis")
@RestController
public class AvisControleur {
    private final AvisService avisService;

//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/ajouter")
    public void creer(@RequestBody Avis avis) {
        this.avisService.creer(avis);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Avis>>  liste() {
        try{
            List<Avis> avis = avisService.liste();
            return new ResponseEntity<>(avis, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
