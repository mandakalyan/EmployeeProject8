package com.spring.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employee.entity.Timex;


@Repository
public interface TimexRepository extends JpaRepository<Timex, Integer> {

}
