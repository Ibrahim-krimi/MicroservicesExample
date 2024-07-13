package org.example.skill.services;

import org.example.skill.dtos.SkillDto;
import org.example.skill.mappers.SkillMapper;
import org.example.skill.repositories.SkillRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements ISkillService{
    private final SkillRepositories skillRepositories;
    private final SkillMapper skillMapper;

    public SkillServiceImpl(SkillRepositories skillRepositories, SkillMapper skillMapper) {
        this.skillRepositories = skillRepositories;
        this.skillMapper = skillMapper;
    }

    @Override
    public List<SkillDto> findAll() {
        return skillRepositories.findAll().stream().map(skillMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public SkillDto findById(Long id) {
        return skillRepositories.findById(id).map(skillMapper::toDTO).orElse(null);
    }
}
