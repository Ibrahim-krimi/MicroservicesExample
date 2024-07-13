package org.example.postion.mappers;

import org.example.postion.dtos.PostionDTO;
import org.example.postion.entites.Postion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostionMapper {
PostionMapper INSTANCE = Mappers.getMapper(PostionMapper.class);

@Mapping(source = "id",target = "id")
@Mapping(source = "name",target = "name")
@Mapping(source = "averageSalary",target = "averageSalary")
@Mapping(source = "skillIds",target = "skillIds")
@Mapping(target = "skills", ignore = true) // Ignore the extra field
PostionDTO toDto(Postion postion);
@Mapping(target = "id", ignore = true) // Ignore id for entity creation
@Mapping(source = "name", target = "name")
@Mapping(source = "averageSalary", target = "averageSalary")
@Mapping(source = "skillIds", target = "skillIds")
Postion toEntity(PostionDTO positionDTO) ;

}
