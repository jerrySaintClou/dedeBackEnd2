package DedeUniversAtuh1.DedeUniversAuth1Box.services;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Utilisateur;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Validation;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;
@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class ValidationService {

    private ValidationRepository validationRepository;
    private NotificationService notificationService;

    public void enregistrer(Utilisateur utilisateur) {
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRepository.save(validation);
        //this.notificationService.envoyer(validation);
    }

    public Validation lireEnFonctionDuCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void nettoyerTable() {
        final Instant now = Instant.now();
        log.info("Suppression des token à {}", now);
        this.validationRepository.deleteAllByExpirationBefore(now);
    }

}
