package org.example.postion.controllers;

import org.example.postion.dtos.PostionDTO;
import org.example.postion.services.IPostionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postions")
public class PositionRestController {

    private final IPostionService postionService;

    public PositionRestController(IPostionService postionService) {
        this.postionService = postionService;
    }

    @GetMapping
    public ResponseEntity<List<PostionDTO>> findAll(){
        List <PostionDTO> postionDTOS = postionService.getAllPostionWithSkills();
        return ResponseEntity.ok(postionDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostionDTO> findById(@PathVariable Long id){
        PostionDTO postionDTO = postionService.getPostionByIdWithSkills(id);
        return ResponseEntity.ok(postionDTO);
    }
}
