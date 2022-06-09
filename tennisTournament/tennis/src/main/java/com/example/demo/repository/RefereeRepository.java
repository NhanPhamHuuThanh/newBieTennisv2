package com.example.demo.repository;

import com.example.demo.entity.Referee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface RefereeRepository extends JpaRepository<Referee, Integer> {
}
