package com.dockdorsal.dockdorsal.SERVICES;

import com.dockdorsal.dockdorsal.DTO.UtilisateurDTO;

import java.util.List;

public interface UtilisateurService {
    void createUser(UtilisateurDTO utilisateurDTO);
    UtilisateurDTO getUserByEmail(String email);
    void updateUser(UtilisateurDTO utilisateurDTO);
    void deleteUser(String email);
}

