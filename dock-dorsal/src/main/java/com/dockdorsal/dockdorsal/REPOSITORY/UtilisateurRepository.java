package com.dockdorsal.dockdorsal.REPOSITORY;

import com.dockdorsal.dockdorsal.DAO.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {
        UtilisateurEntity findByEmail(String email);
        void deleteByEmail(String email); // Assurez-vous que cette méthode est correctement définie
        // Autres méthodes personnalisées si nécessaire
}

