package com.dockdorsal.dockdorsal.REPOSITORY;

import com.dockdorsal.dockdorsal.DAO.CorrectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CorrectionEntityRepository extends JpaRepository<CorrectionEntity, Long> {
    List<CorrectionEntity> findByUtilisateurId(Long utilisateurId);
    List<CorrectionEntity> findByUtilisateurIdAndDateBetween(Long utilisateurId, LocalDate startDate, LocalDate endDate);
    // Autres méthodes personnalisées si nécessaire
}
