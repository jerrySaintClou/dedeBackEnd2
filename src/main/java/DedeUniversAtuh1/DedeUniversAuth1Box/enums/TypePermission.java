package DedeUniversAtuh1.DedeUniversAuth1Box.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypePermission {

    ADMINISTRATEUR_CREATE,
    ADMINISTRATEUR_READ,
    ADMINISTRATEUR_UPDATE,
    ADMINISTRATEUR_DELETE,

    MANAGER_CREATE,
    MANAGER_READ,
    MANAGER_UPDATE,
    MANAGER_DELETE_AVIS,

    UTILISATEUR_CREATE_AVIS;

    @Getter
    private String libelle;


}