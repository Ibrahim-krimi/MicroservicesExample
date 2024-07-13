package org.example.skill.repositories;

import org.example.skill.entites.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepositories extends JpaRepository<Skill,Long> {

}
