package com.dockdorsal.dockdorsal.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {
    private String prenom;
    private String nom;
    private String email;
    private String role;


    // Autres champs et méthodes si nécessaire
}
