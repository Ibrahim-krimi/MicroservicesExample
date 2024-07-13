package org.example.postion.clients;

import org.example.postion.models.Skill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "skill",url = "http://localhost:8092")
public interface SkillProxy  {

    @GetMapping("/skill/{id}")
    Skill getSkill (@PathVariable("id") Long id);

    @GetMapping("/skill")
    List<Skill> getSkills();

    default Skill getDefaultSkill(Long id, Exception exception) {
        return new Skill(id, "Default Skill");
    }
    default List<Skill> getDefaultSkills(Exception exception) {
        return List.of(new Skill(null, "Default Skill")); //
    }
}
