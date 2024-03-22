package com.dockdorsal.dockdorsal.SERVICES;

import com.dockdorsal.dockdorsal.DAO.UtilisateurEntity;
import com.dockdorsal.dockdorsal.DTO.CorrectionEntryDTO;
import com.dockdorsal.dockdorsal.DAO.CorrectionEntity;
import com.dockdorsal.dockdorsal.REPOSITORY.UtilisateurRepository;
import com.dockdorsal.dockdorsal.REPOSITORY.CorrectionEntityRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class CorrectionServiceImpl implements CorrectionService {

    private final CorrectionEntityRepository correctionEntityRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final CorrectionMapper correctionMapper;

    public CorrectionServiceImpl(CorrectionEntityRepository correctionEntityRepository,
                                 UtilisateurRepository utilisateurRepository,
                                 CorrectionMapper correctionMapper) {
        this.correctionEntityRepository = correctionEntityRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.correctionMapper = correctionMapper;
    }

    @Override
    public void createCorrectionEntry(String userEmail, CorrectionEntryDTO correctionEntryDTO) {
        CorrectionEntity correctionEntity = correctionMapper.correctionEntryDTOToCorrectionEntity(correctionEntryDTO);
        // Récupérer l'utilisateur à partir de l'e-mail
        UtilisateurEntity utilisateur = utilisateurRepository.findByEmail(userEmail);
        correctionEntity.setUtilisateur(new UtilisateurEntity());
        correctionEntityRepository.save(correctionEntity);
    }

    @Override
    public List<CorrectionEntryDTO> getCorrectionEntriesByUser(String userEmail) {
        return null;
    }

    @Override
    public void updateCorrectionEntry(String userEmail, LocalDate date, CorrectionEntryDTO correctionEntryDTO) {

    }

    @Override
    public void deleteCorrectionEntry(String userEmail, LocalDate date) {

    }

    // Autres méthodes implémentées
}
