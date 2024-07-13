package org.example.postion.services;

import org.example.postion.clients.SkillProxy;
import org.example.postion.dtos.PostionDTO;
import org.example.postion.entites.Postion;
import org.example.postion.mappers.PostionMapper;
import org.example.postion.models.Skill;
import org.example.postion.repositories.PostionRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service

public class PostionServiceImpl implements IPostionService{

    private final PostionRepositories postionRepositories;

    private final PostionMapper postionMapper;
    private final SkillProxy skillProxy;

    public PostionServiceImpl(PostionRepositories postionRepositories, PostionMapper postionMapper, SkillProxy skillProxy) {
        this.postionRepositories = postionRepositories;
        this.postionMapper = postionMapper;
        this.skillProxy = skillProxy;
    }


    @Override
    public List<PostionDTO> findAll() {
        return postionRepositories.findAll().stream().map(postionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PostionDTO findById(Long id) {
        return  postionRepositories.findById(id).map(postionMapper::toDto).orElse(null);
    }

    @Override
    public PostionDTO getPostionByIdWithSkills(Long id){
        return  convertPostionToDTO(Objects.requireNonNull(postionRepositories.findById(id).orElse(null)));
    }



    @Override
    public List<PostionDTO> getAllPostionWithSkills() {

        return postionRepositories.findAll().stream().map(this::convertPostionToDTO).collect(Collectors.toList());
    }

    private PostionDTO convertPostionToDTO(Postion postion){
        List<Skill> skills = postion.getSkillIds().stream().map(
                skillID -> {
                    try {
                        Skill skill = skillProxy.getSkill(skillID);
                        return new Skill(skill.getId(),skill.getName());
                    }catch (Exception e){
                        return new Skill(skillID, "Default Skill"); // Gestion d'erreur simplifiée

                    }
                }
        ).collect(Collectors.toList());
        return new PostionDTO(postion.getId(), postion.getName(), postion.getAverageSalary(), postion.getSkillIds(),skills);

    }

}
