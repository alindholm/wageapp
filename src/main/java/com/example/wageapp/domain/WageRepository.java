package com.example.wageapp.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WageRepository extends CrudRepository<Wage, Long>{
	 List<Wage> findAllByOrderByYearAsc();

	    @Query("SELECT SUM(price) FROM Wage WHERE year = :year")
	    Double getTotalWagesByYear(@Param("year") String year);
}
