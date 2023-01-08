package dev.mhshahin.demosmallcompany.dto.requestdto;

import jakarta.validation.constraints.NotNull;

public class DepartmentRequestDTO {
    @NotNull
    public String departmentName;
}

