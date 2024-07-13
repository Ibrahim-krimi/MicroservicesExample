package org.example.skill.controllers;

import org.example.skill.dtos.SkillDto;
import org.example.skill.services.ISkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController@RequestMapping("skill")
public class SkillRestController {

    private final ISkillService skillService;


    public SkillRestController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @RequestMapping("/")
    public ResponseEntity<List<SkillDto>> getAll(){
        return ResponseEntity.ok(skillService.findAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<SkillDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(skillService.findById(id));
    }
}
