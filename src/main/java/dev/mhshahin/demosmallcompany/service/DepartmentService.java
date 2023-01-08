package dev.mhshahin.demosmallcompany.service;

import dev.mhshahin.demosmallcompany.dto.requestdto.DepartmentRequestDTO;
import dev.mhshahin.demosmallcompany.dto.requestdto.SkillsRequestDTO;
import dev.mhshahin.demosmallcompany.dto.rsponsedto.DepartmentResponseDTO;
import dev.mhshahin.demosmallcompany.dto.rsponsedto.SkillsResponseDTO;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    DepartmentResponseDTO save(DepartmentRequestDTO codecsDTO);

    List<DepartmentResponseDTO> findAll();

    DepartmentResponseDTO findById(UUID id);

    DepartmentResponseDTO update(UUID id, DepartmentRequestDTO skillsRequest);

    DepartmentResponseDTO status(UUID id, DepartmentRequestDTO activeRequest);
}
