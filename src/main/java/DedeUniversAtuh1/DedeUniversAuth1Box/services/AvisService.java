package DedeUniversAtuh1.DedeUniversAuth1Box.services;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Avis;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Utilisateur;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AvisService {

    private final AvisRepository avisRepository;

    public void creer(Avis avis){
        Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        avis.setUtilisateur(utilisateur);
        this.avisRepository.save(avis);
    }


    public List<Avis> liste() {
        return this.avisRepository.findAll();
    }
}
