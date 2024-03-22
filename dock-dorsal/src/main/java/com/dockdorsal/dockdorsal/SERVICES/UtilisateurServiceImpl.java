package com.dockdorsal.dockdorsal.SERVICES;

import com.dockdorsal.dockdorsal.DTO.UtilisateurDTO;
import com.dockdorsal.dockdorsal.DAO.UtilisateurEntity;
import com.dockdorsal.dockdorsal.REPOSITORY.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public void createUser(UtilisateurDTO utilisateurDTO) {
        UtilisateurEntity utilisateurEntity = mapToEntity(utilisateurDTO);
        utilisateurRepository.save(utilisateurEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public UtilisateurDTO getUserByEmail(String email) {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByEmail(email);
        return mapToDTO(utilisateurEntity);
    }

    @Override
    @Transactional
    public void updateUser(UtilisateurDTO utilisateurDTO) {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByEmail(utilisateurDTO.getEmail());
        if (utilisateurEntity != null) {
            utilisateurEntity.setPrenom(utilisateurDTO.getPrenom());
            utilisateurEntity.setNom(utilisateurDTO.getNom());
            utilisateurEntity.setRole(utilisateurDTO.getRole());
            utilisateurRepository.save(utilisateurEntity);
        }
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
        utilisateurRepository.deleteByEmail(email);
    }

    private UtilisateurDTO mapToDTO(UtilisateurEntity utilisateurEntity) {
        if (utilisateurEntity != null) {
            return new UtilisateurDTO(utilisateurEntity.getPrenom(), utilisateurEntity.getNom(), utilisateurEntity.getEmail(), utilisateurEntity.getRole());
        }
        return null;
    }

    private UtilisateurEntity mapToEntity(UtilisateurDTO utilisateurDTO) {
        if (utilisateurDTO != null) {
            UtilisateurEntity utilisateurEntity = new UtilisateurEntity();
            utilisateurEntity.setPrenom(utilisateurDTO.getPrenom());
            utilisateurEntity.setNom(utilisateurDTO.getNom());
            utilisateurEntity.setEmail(utilisateurDTO.getEmail());
            utilisateurEntity.setRole(utilisateurDTO.getRole());
            return utilisateurEntity;
        }
        return null;
    }
}
