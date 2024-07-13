package org.example.postion.services;

import org.example.postion.dtos.PostionDTO;
import org.example.postion.mappers.PostionMapper;
import org.example.postion.repositories.PostionRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class PostionServiceImpl implements IPostionService{

    private final PostionRepositories postionRepositories;

    private final PostionMapper postionMapper;

    public PostionServiceImpl(PostionRepositories postionRepositories, PostionMapper postionMapper) {
        this.postionRepositories = postionRepositories;
        this.postionMapper = postionMapper;
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
    public PostionDTO getPostionByIdWithSkills(Long id) {
        return null;
    }

    @Override
    public List<PostionDTO> getAllPostionWithSkills() {
        return null;
    }
}
