package DedeUniversAtuh1.DedeUniversAuth1Box.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "imageProduits")
public class ImageProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "chemin_image_produit", length = 255, nullable = false)
    private String cheminImageProduit;
//
//    @ManyToOne
//    @JoinColumn(name = "produit_id")
//    private Produit produit;

    @ManyToOne
    private Produit produit;


//    @ManyToOne
//    @JoinColumn(name = "produit_id")
//    private Produit produit;

    public ImageProduit() {
    }

    public ImageProduit(String cheminImageProduit) {
        this.cheminImageProduit = cheminImageProduit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheminImageProduit() {
        return cheminImageProduit;
    }

    public void setCheminImageProduit(String cheminImageProduit) {
        this.cheminImageProduit = cheminImageProduit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
