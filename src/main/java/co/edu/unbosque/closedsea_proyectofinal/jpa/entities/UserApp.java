package co.edu.unbosque.closedsea_proyectofinal.jpa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "userapp")
public class UserApp {

    @Id
    @Column(name = "email")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "userapp", fetch = FetchType.EAGER)
    private List<Wallet_History> walletHistories = new ArrayList<>();

    @OneToMany(mappedBy = "userapp", fetch = FetchType.EAGER)
    private Set<Collection> collections = new HashSet<>();
    public UserApp(){}

    public UserApp(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Wallet_History> getWalletHistories() {
        return walletHistories;
    }

    public void setWalletHistories(List<Wallet_History> walletHistories) {
        this.walletHistories = walletHistories;
    }
}
