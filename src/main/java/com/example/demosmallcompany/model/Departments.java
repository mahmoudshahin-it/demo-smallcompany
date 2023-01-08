package com.example.demosmallcompany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "departments")
public class Departments  extends BaseEntity {

}
