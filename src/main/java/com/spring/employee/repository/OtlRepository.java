package com.spring.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employee.entity.Otl;


@Repository
public interface OtlRepository extends JpaRepository<Otl, Integer> 
{

	Otl save(int otlid);


}
