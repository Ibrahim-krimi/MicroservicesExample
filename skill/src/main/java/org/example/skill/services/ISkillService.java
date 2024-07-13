package org.example.skill.services;

import org.example.skill.dtos.SkillDto;

import java.util.List;

public interface ISkillService {
        List<SkillDto> findAll();
        SkillDto findById(Long id);

}
