package DedeUniversAtuh1.DedeUniversAuth1Box.controllers;

import DedeUniversAtuh1.DedeUniversAuth1Box.dto.AuthentificationDTO;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Utilisateur;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Validation;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.UtilisateurRepository;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.ValidationRepository;
import DedeUniversAtuh1.DedeUniversAuth1Box.securites.JwtService;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.UtilisateurService;
import DedeUniversAtuh1.DedeUniversAuth1Box.services.ValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UtilisateurControleur {

    private AuthenticationManager authenticationManager;
    private UtilisateurService utilisateurService;
    private JwtService jwtService;
    @Autowired
    ValidationRepository validationRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @PostMapping(path = "inscription")
    public void inscription(@RequestBody Utilisateur utilisateur) {
        log.info("Inscription");
        this.utilisateurService.inscription(utilisateur);
    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.utilisateurService.activation(activation);
    }

    @PostMapping(path = "refresh-token")
    public @ResponseBody Map<String, String> refreshToken(@RequestBody Map<String, String> refreshTokenRequest) {
        return this.jwtService.refreshToken(refreshTokenRequest);
    }

    @PostMapping(path = "deconnexion")
    public void deconnexion() {
        this.jwtService.deconnexion();
    }

    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );

        if(authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.username());
        }
        return null;
    }


    @PostMapping(path = "modifier-mot-de-passe")
    public Validation modifierMotDePasse(@RequestBody Map<String, String> activation) {
        //this.utilisateurService.modifierMotDePasse(activation);
        //Optional<Utilisateur> user = utilisateurRepository.findByEmail(activation.get("email"));
        Utilisateur user2 = utilisateurRepository.findByNom(activation.get("email"));
        //validationService.enregistrer(user2);

        Validation validation = new Validation();
        validation.setUtilisateur(user2);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);
//
        validation.setCode(code);
        Validation v = validationRepository.save(validation);
        return v;
    }

    @PostMapping(path = "nouveau-mot-de-passe")
    public void nouveauMotDePasse(@RequestBody Map<String, String> activation) {
        this.utilisateurService.nouveauMotDePasse(activation);
    }

//    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR_READ', 'MANAGER_READ')")
//    @GetMapping
//    public List<Utilisateur> liste() {
//        return this.utilisateurService.liste();
//    }

}