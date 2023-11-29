package com.example.wageapp.domain;

import org.springframework.data.repository.CrudRepository;

public interface OpintoTukiRepository extends CrudRepository<OpintoTuki, Long>{
OpintoTuki findByMonthNumber(int selectedMonth);

}
