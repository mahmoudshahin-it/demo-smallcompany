package dev.mhshahin.demosmallcompany.controller;


import dev.mhshahin.demosmallcompany.dto.requestdto.DepartmentRequestDTO;
import dev.mhshahin.demosmallcompany.dto.rsponsedto.DepartmentResponseDTO;
import dev.mhshahin.demosmallcompany.repository.DepartmentsRepo;
import dev.mhshahin.demosmallcompany.service.DepartmentService;
import dev.mhshahin.demosmallcompany.utils.APIResponse;
import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static dev.mhshahin.demosmallcompany.utils.APIHelperUtil.createUnifiedResponse;
import static dev.mhshahin.demosmallcompany.utils.APIMessages.Department_RECORD_CREATED_SUCCESSFULLY;
import static dev.mhshahin.demosmallcompany.utils.APIMessages.Department_RECORD_RETRIEVED_SUCCESSFULLY;
import static dev.mhshahin.demosmallcompany.utils.APIURI.departmentURI;

@RestController
@RequestMapping(departmentURI)
public class DepartmentsController {

    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<APIResponse> save(@Valid @RequestBody DepartmentRequestDTO departmentRequest){
        return createUnifiedResponse(departmentService.save(departmentRequest), HttpStatus.CREATED, Department_RECORD_CREATED_SUCCESSFULLY);
    }

    @GetMapping
    @ApiOperation(value = "Get all departments")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "API_201", response = DepartmentResponseDTO.class),
            @ApiResponse(code = 400, message = "API_400", response = APIResponse.class) })
    public ResponseEntity<APIResponse> findAll(){
        return createUnifiedResponse(departmentService.findAll(), HttpStatus.OK, Department_RECORD_RETRIEVED_SUCCESSFULLY);
    }
}
