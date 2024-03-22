package com.dockdorsal.dockdorsal.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorrectionEntryDTO {
    private double correctionValue;
    private LocalDate date;
}
