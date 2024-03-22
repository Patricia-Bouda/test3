package com.dockdorsal.dockdorsal.CONTROLLER;

import com.dockdorsal.dockdorsal.DTO.CorrectionEntryDTO;
import com.dockdorsal.dockdorsal.SERVICES.CorrectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/corrections")
public class CorrectionController {

    private final CorrectionService correctionService;

    public CorrectionController(CorrectionService correctionService) {
        this.correctionService = correctionService;
    }

    @PostMapping("/{userEmail}")
    public ResponseEntity<String> createCorrectionEntry(@PathVariable String userEmail,
                                                        @RequestBody CorrectionEntryDTO correctionEntryDTO) {
        correctionService.createCorrectionEntry(userEmail, correctionEntryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Correction entry created successfully.");
    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<List<CorrectionEntryDTO>> getCorrectionEntriesByUser(@PathVariable String userEmail) {
        List<CorrectionEntryDTO> correctionEntries = correctionService.getCorrectionEntriesByUser(userEmail);
        if (correctionEntries.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(correctionEntries);
    }

    @PutMapping("/{userEmail}/{date}")
    public ResponseEntity<String> updateCorrectionEntry(@PathVariable String userEmail,
                                                        @PathVariable String date,
                                                        @RequestBody CorrectionEntryDTO correctionEntryDTO) {
        LocalDate localDate = LocalDate.parse(date);
        correctionService.updateCorrectionEntry(userEmail, localDate, correctionEntryDTO);
        return ResponseEntity.ok("Correction entry updated successfully.");
    }

    @DeleteMapping("/{userEmail}/{date}")
    public ResponseEntity<String> deleteCorrectionEntry(@PathVariable String userEmail,
                                                        @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        correctionService.deleteCorrectionEntry(userEmail, localDate);
        return ResponseEntity.ok("Correction entry deleted successfully.");
    }
}

