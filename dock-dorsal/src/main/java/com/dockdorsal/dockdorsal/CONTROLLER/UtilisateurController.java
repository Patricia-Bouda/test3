package com.dockdorsal.dockdorsal.CONTROLLER;

import com.dockdorsal.dockdorsal.DTO.UtilisateurDTO;
import com.dockdorsal.dockdorsal.SERVICES.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        utilisateurService.createUser(utilisateurDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UtilisateurDTO> getUserByEmail(@PathVariable String email) {
        UtilisateurDTO utilisateurDTO = utilisateurService.getUserByEmail(email);
        if (utilisateurDTO != null) {
            return ResponseEntity.ok(utilisateurDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        utilisateurService.updateUser(utilisateurDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        utilisateurService.deleteUser(email);
        return ResponseEntity.ok().build();
    }
}
