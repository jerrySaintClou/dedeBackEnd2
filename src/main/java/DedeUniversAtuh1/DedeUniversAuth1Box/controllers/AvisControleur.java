package DedeUniversAtuh1.DedeUniversAuth1Box.controllers;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Avis;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.AvisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("avis")
@RestController
public class AvisControleur {
    private final AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody Avis avis) {
        this.avisService.creer(avis);
    }
    @GetMapping
    public List<Avis> liste() {
        return this.avisService.liste();
    }
}
