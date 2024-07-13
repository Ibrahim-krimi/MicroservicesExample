package org.example.postion.repositories;

import org.example.postion.entites.Postion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostionRepositories  extends JpaRepository<Postion,Long> {
}
