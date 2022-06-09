package co.edu.unbosque.closedsea_proyectofinal.jpa.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(mappedBy = "art", fetch = FetchType.EAGER)
    private List<Like> like = new ArrayList<>();

    @OneToMany(mappedBy = "art", fetch = FetchType.EAGER)
    private List<Ownership> ownership = new ArrayList<>();

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

    public List<Like> getLike() {
        return like;
    }

    public List<Ownership> getOwnership() {
        return ownership;
    }
}
