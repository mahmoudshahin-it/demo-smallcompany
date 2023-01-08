package dev.mhshahin.demosmallcompany.service;

import dev.mhshahin.demosmallcompany.dto.requestdto.SkillsRequestDTO;
import dev.mhshahin.demosmallcompany.dto.rsponsedto.SkillsResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SkillsService {

    SkillsResponseDTO save(SkillsRequestDTO codecsDTO);

    List<SkillsResponseDTO> findAll();

    SkillsResponseDTO findById(UUID id);

    SkillsResponseDTO update(UUID id, SkillsRequestDTO skillsRequest);

    SkillsResponseDTO status(UUID id, SkillsRequestDTO activeRequest);
}
