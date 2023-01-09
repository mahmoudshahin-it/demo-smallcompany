package dev.mhshahin.demosmallcompany.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "lookup_skills")
public class Skills  extends BaseEntity{

    private String skillName;

}
