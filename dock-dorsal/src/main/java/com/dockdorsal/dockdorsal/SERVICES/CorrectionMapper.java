package com.dockdorsal.dockdorsal.SERVICES;

import com.dockdorsal.dockdorsal.DAO.CorrectionEntity;
import com.dockdorsal.dockdorsal.DTO.CorrectionEntryDTO;
import org.springframework.stereotype.Component;

@Component

public class CorrectionMapper {
    public static CorrectionEntity correctionEntryDTOToCorrectionEntity(CorrectionEntryDTO dto) {
        if (dto == null) {
            return null;

        }
        CorrectionEntity entity = new CorrectionEntity();
        entity.setValeurCorrection((int) dto.getCorrectionValue());
        entity.setDate(dto.getDate());
        // Assurez-vous de définir l'utilisateur approprié en fonction de l'e-mail
        // entity.setUtilisateur(...);
        return entity;
    }

    public static CorrectionEntryDTO correctionEntityToCorrectionEntryDTO(CorrectionEntity entity) {
        if (entity == null) {
            return null;
        }
        CorrectionEntryDTO dto = new CorrectionEntryDTO();
        dto.setCorrectionValue(entity.getValeurCorrection());
        dto.setDate(entity.getDate());
        return dto;
    }
}

