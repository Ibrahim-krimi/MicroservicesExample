package org.example.postion.dtos;

import org.example.postion.models.Skill;

import java.util.List;

public record PostionDTO(Long id , String name , Double averageSalary , List<Long> skillIds , List<Skill> skills) {
}
