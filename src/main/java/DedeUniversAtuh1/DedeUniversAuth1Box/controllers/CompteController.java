package DedeUniversAtuh1.DedeUniversAuth1Box.controllers;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Utilisateur;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("utilisateur")
@RestController
public class CompteController {
    UtilisateurService utilisateurService;

    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR_READ', 'MANAGER_READ')")
    @GetMapping
    public List<Utilisateur> liste() {
        return this.utilisateurService.liste();
    }
}
