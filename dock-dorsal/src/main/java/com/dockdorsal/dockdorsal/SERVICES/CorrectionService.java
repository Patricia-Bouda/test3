package com.dockdorsal.dockdorsal.SERVICES;

import com.dockdorsal.dockdorsal.DTO.CorrectionEntryDTO;

import java.time.LocalDate;
import java.util.List;

public interface CorrectionService {
    void createCorrectionEntry(String userEmail, CorrectionEntryDTO correctionEntryDTO);
    List<CorrectionEntryDTO> getCorrectionEntriesByUser(String userEmail);
    void updateCorrectionEntry(String userEmail, LocalDate date, CorrectionEntryDTO correctionEntryDTO);
    void deleteCorrectionEntry(String userEmail, LocalDate date);
}

