package dev.mhshahin.demosmallcompany.dto.requestdto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class SkillsRequestDTO {

    @NotNull
    private String skillName;
}
