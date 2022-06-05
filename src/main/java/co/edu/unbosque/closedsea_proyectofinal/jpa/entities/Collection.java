package co.edu.unbosque.closedsea_proyectofinal.jpa.entities;

import jakarta.persistence.*;

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
    private String category;

    @ManyToOne
    @JoinColumn(name = "email")
    private UserApp userApp;

    public Collection() {}

    public Collection(Integer id, String name, String category, UserApp userApp) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.userApp = userApp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }
}
