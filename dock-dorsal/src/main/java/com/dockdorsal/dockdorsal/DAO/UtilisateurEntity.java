package com.dockdorsal.dockdorsal.DAO;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UtilisateurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<CorrectionEntity> corrections;

    // Autres champs et méthodes si nécessaire

    // Exemple de méthode avec un type de retour autre que void
    public String getFullName() {
        return prenom + " " + nom;
    }

    // Méthodes setter et getter pour les autres champs
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {

    }
}

