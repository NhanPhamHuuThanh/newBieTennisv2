package com.example.demo.repository;

import com.example.demo.entity.RefereeMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeMatchRepository extends JpaRepository<RefereeMatch,Integer> {
}
