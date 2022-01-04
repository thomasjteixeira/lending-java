package com.github.thomasjteixeira.lending.repository;

import com.github.thomasjteixeira.lending.entity.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending, Long> {

}
