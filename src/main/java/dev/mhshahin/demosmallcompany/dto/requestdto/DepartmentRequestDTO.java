package dev.mhshahin.demosmallcompany.dto.requestdto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DepartmentRequestDTO {
    @NotNull
    @NotBlank(message = "Department Name is mandatory")
    private String departmentName;
}

