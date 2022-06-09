package com.example.demo.repository;

import com.example.demo.entity.TennisSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisSetRepository extends JpaRepository<TennisSet, Integer> {
}
