package dev.mhshahin.demosmallcompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "lookup_skills")
public class Skills  extends BaseEntity{

    private String skillName;

}
