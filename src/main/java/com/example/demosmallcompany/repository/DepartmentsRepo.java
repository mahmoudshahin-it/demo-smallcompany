package com.example.demosmallcompany.repository;

import com.example.demosmallcompany.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentsRepo extends JpaRepository<Departments, UUID> {
}
