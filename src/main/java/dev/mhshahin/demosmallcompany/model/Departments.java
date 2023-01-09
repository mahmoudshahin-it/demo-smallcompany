package dev.mhshahin.demosmallcompany.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "departments")
public class Departments  extends BaseEntity {

}
