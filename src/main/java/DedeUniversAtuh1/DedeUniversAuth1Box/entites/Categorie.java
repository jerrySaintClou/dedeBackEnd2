package DedeUniversAtuh1.DedeUniversAuth1Box.entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "nom_categorie", length = 80, nullable = false)
    private String nomCategorie;
//
//    @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
//    private List<SousCategorie> sousCategorie;

    public Categorie() {
    }

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
//
//    public List<SousCategorie> getSousCategorie() {
//        return sousCategorie;
//    }
//
//    public void setSousCategorie(List<SousCategorie> sousCategorie) {
//        this.sousCategorie = sousCategorie;
//    }

}
