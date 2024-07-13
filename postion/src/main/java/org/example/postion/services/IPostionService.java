package org.example.postion.services;

import org.example.postion.dtos.PostionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPostionService {
    List<PostionDTO> findAll();
    PostionDTO findById(Long id);

    PostionDTO getPostionByIdWithSkills(Long id );
    List<PostionDTO> getAllPostionWithSkills();

}
