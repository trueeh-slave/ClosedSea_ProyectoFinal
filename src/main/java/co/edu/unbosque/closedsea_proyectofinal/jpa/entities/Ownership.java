package co.edu.unbosque.closedsea_proyectofinal.jpa.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Ownership")
public class Ownership {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "art")
    private Art art;

    @ManyToOne
    @JoinColumn(name = "email")
    private UserApp userApp;

    @Column(name = "registeredAt")
    private Date registeredAt;

    public Ownership(){

    }

    public Ownership(Art art, UserApp userApp, Date registeredAt) {
        this.art = art;
        this.userApp = userApp;
        this.registeredAt = registeredAt;
    }

    public Integer getId() {
        return id;
    }

    public Art getArt() {
        return art;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }
}
