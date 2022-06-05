package co.edu.unbosque.closedsea_proyectofinal.jpa.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "wallet_history")
public class Wallet_History {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "fcoins")
    private Double fcoins;

    @Column(name = "registered_at")
    private Date registered_at;

    @ManyToOne
    @JoinColumn(name = "email")
    private UserApp userApp;

    public Wallet_History() {}

    public Wallet_History(Integer id, String type, Double fcoins, Date registered_at, UserApp userApp) {
        this.id = id;
        this.type = type;
        this.fcoins = fcoins;
        this.registered_at = registered_at;
        this.userApp = userApp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getFcoins() {
        return fcoins;
    }

    public void setFcoins(Double fcoins) {
        this.fcoins = fcoins;
    }

    public Date getRegistered_at() {
        return registered_at;
    }

    public void setRegistered_at(Date registered_at) {
        this.registered_at = registered_at;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }
}
