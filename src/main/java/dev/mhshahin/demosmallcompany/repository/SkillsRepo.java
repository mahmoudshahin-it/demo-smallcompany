package dev.mhshahin.demosmallcompany.repository;

import dev.mhshahin.demosmallcompany.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillsRepo  extends JpaRepository<Skills, UUID> {
}
