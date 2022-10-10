package com.example.chicken.repository;

import com.example.chicken.domain.Chicken;
import com.example.chicken.entity.ChickenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ChickenRepository extends JpaRepository<ChickenEntity, Integer> {
}
