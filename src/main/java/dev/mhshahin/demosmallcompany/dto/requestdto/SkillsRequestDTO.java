package dev.mhshahin.demosmallcompany.dto.requestdto;

import jakarta.validation.constraints.NotNull;

public class SkillsRequestDTO {

    @NotNull
    public String skillName;
}
