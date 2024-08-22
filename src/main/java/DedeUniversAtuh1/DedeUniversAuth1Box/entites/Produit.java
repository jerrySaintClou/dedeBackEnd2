package DedeUniversAtuh1.DedeUniversAuth1Box.entites;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_produit", length = 20, nullable = false)
    private String nomProduit;


    @Column(name = "description", length = 255, nullable = true,columnDefinition = "TEXT")
    private String description;

    @Column(name = "prix", nullable = true)
    private float prix;


    @Column(name = "stock", nullable = true)
    private int stock;

    @Column(name = "date_de_mise_en_ligne", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateMiseEnLigne;


//    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ImageProduit> imageProduits;
//
//    @OneToMany
//    private List<ImageProduit> imageProduits;

    @ManyToOne
    private SousCategorie sousCategorie;

    @ManyToOne
    private Avis avis;
//
//    public SousCategorie getSousCategorie() {
//        return sousCategorie;
//    }
//
//    public void setSousCategorie(SousCategorie sousCategorie) {
//        this.sousCategorie = sousCategorie;
//    }


    public Produit() {
    }

    public Produit(String nomProduit, String description, float prix, int stock, Date dateMiseEnLigne) {
        this.nomProduit = nomProduit;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
        this.dateMiseEnLigne = dateMiseEnLigne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getDateMiseEnLigne() {
        return dateMiseEnLigne;
    }

    public void setDateMiseEnLigne(Date dateMiseEnLigne) {
        this.dateMiseEnLigne = dateMiseEnLigne;
    }

    public SousCategorie getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(SousCategorie sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

//
//    public List<ImageProduit> getImageProduits() {
//        return imageProduits;
//    }
//
//    public void setImageProduits(List<ImageProduit> imageProduits) {
//        this.imageProduits = imageProduits;
//    }

    public Avis getAvis() {
        return avis;
    }

    public void setAvis(Avis avis) {
        this.avis = avis;
    }
}
