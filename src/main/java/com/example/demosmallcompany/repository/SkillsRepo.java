package com.example.demosmallcompany.repository;

import com.example.demosmallcompany.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillsRepo  extends JpaRepository<Skills, UUID> {
}
