package org.example.postion.entites;

import jakarta.persistence.*;
import lombok.*;
import org.example.postion.models.Skill;

import java.util.List;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString@Builder
@Entity
public class Postion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double averageSalary;

    @Transient
    private List<Skill> skills;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<Long> skillIds;
}
