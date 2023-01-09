package dev.mhshahin.demosmallcompany.service.serviceimpl;

import dev.mhshahin.demosmallcompany.dto.requestdto.DepartmentRequestDTO;
import dev.mhshahin.demosmallcompany.dto.rsponsedto.DepartmentResponseDTO;
import dev.mhshahin.demosmallcompany.exceptions.ResourceNotFoundException;
import dev.mhshahin.demosmallcompany.model.Departments;
import dev.mhshahin.demosmallcompany.repository.DepartmentsRepo;
import dev.mhshahin.demosmallcompany.service.DepartmentService;
import dev.mhshahin.demosmallcompany.utils.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static dev.mhshahin.demosmallcompany.utils.APIExceptions.CODEC_RECORD_NOT_FOUND;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final Converter converter;
    private final DepartmentsRepo repo;

    public DepartmentServiceImpl(Converter converter, DepartmentsRepo repo) {
        this.converter = converter;
        this.repo = repo;
    }


    @Override
    public DepartmentResponseDTO save(DepartmentRequestDTO departmentRequestDTO) {
        Departments d = converter.convert(departmentRequestDTO, Departments.class);
        // CREATED BY & Updated by need some handling.
        Departments persisted= repo.save(d);
        return converter.convert(persisted, DepartmentResponseDTO.class);

    }

    @Override
    public List<DepartmentResponseDTO> findAll() {
        List<Departments> list = repo.findAll();
        return converter.toList(list, DepartmentResponseDTO.class);
    }

    @Override
    public DepartmentResponseDTO findById(UUID id) {
        Departments dept = repo.findById(id). orElseThrow(() -> new ResourceNotFoundException(CODEC_RECORD_NOT_FOUND));
        return converter.convert(dept, DepartmentResponseDTO.class);
    }



    //TBD the following two methods

    @Override
    public DepartmentResponseDTO update(UUID id, DepartmentRequestDTO skillsRequest) {
        return null;
    }

    @Override
    public DepartmentResponseDTO status(UUID id, DepartmentRequestDTO activeRequest) {
        return null;
    }
}
