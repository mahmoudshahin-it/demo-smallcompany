package dev.mhshahin.demosmallcompany.repository;

import dev.mhshahin.demosmallcompany.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentsRepo extends JpaRepository<Departments, UUID> {

}
