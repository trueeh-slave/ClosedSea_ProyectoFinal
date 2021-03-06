package co.edu.unbosque.closedsea_proyectofinal.jpa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Collection")
public class Collection {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "email")
    private UserApp userApp;

    // FetchType.EAGER
    @OneToMany(mappedBy = "collection", fetch = FetchType.EAGER)
    private List<Art> art = new ArrayList<>();

    public Collection() {
    }

    public Collection(String name, String description, String category, UserApp userApp) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.userApp = userApp;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
