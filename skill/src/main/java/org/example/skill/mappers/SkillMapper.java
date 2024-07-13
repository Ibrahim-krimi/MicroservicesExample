package org.example.skill.mappers;

import org.example.skill.dtos.SkillDto;
import org.example.skill.entites.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    SkillDto toDTO(Skill skill);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Skill toEntity(SkillDto skillDTO);
}
