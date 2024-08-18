package DedeUniversAtuh1.DedeUniversAuth1Box;

import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Role;
import DedeUniversAtuh1.DedeUniversAuth1Box.entites.Utilisateur;
import DedeUniversAtuh1.DedeUniversAuth1Box.enums.TypeDeRole;
import DedeUniversAtuh1.DedeUniversAuth1Box.repositoies.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DedeUniversAuth1BoxApplication implements CommandLineRunner {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DedeUniversAuth1BoxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Utilisateur admin = Utilisateur.builder()
				.actif(true)
				.nom("admin")
				.mdp(passwordEncoder.encode("admin"))
				.email("admin@email.com")
				.role(
						Role.builder()
								.libelle(TypeDeRole.ADMINISTRATEUR)
								.build()
				)
				.build();
		admin = this.utilisateurRepository.findByEmail("admin@email.com")
				.orElse(admin);
		this.utilisateurRepository.save(admin);
		Utilisateur manager = Utilisateur.builder()
				.actif(true)
				.nom("manager")
				.mdp(passwordEncoder.encode("manager"))
				.email("manager@email.com")
				.role(
						Role.builder()
								.libelle(TypeDeRole.MANAGER)
								.build()
				)
				.build();
		manager = this.utilisateurRepository.findByEmail("manager@email.com")
				.orElse(manager);
		this.utilisateurRepository.save(manager);
	}
}
