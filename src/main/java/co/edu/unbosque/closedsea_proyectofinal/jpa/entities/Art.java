package co.edu.unbosque.closedsea_proyectofinal.jpa.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Art")
public class Art {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "forSale")
    private boolean forSale;

    @ManyToOne
    @JoinColumn(name = "collection")
    private Collection collection;

    @OneToMany(mappedBy = "Art", fetch = FetchType.EAGER)
    private Set<Like> like = new HashSet<>();

    @OneToMany(mappedBy = "Art", fetch = FetchType.EAGER)
    private Set<Ownership> ownership = new HashSet<>();

    public Art() {

    }

    public Art(String name, float price, String imagePath, boolean forSale, Collection collection){
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.forSale = forSale;
        this.collection = collection;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isForSale() {
        return forSale;
    }

    public Collection getCollection() {
        return collection;
    }

    public Set<Like> getLike() {
        return like;
    }

    public Set<Ownership> getOwnership() {
        return ownership;
    }
}
