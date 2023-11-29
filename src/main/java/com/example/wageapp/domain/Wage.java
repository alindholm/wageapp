package com.example.wageapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Wage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	 @NotEmpty(message = "Day cannot be empty")
	    @Pattern(regexp = "^[1-9]|[12][0-9]|3[01]$", message = "Day must be between 1 and 31")
	    @Column(name = "wage_day")
	    private String day;

	    @NotEmpty(message = "Month cannot be empty")
	    @Pattern(regexp = "^(0?[1-9]|1[0-2])$", message = "Month must be between 1 and 12")
	    @Column(name = "wage_month")
	    private String month;

	    @NotEmpty(message = "Year cannot be empty")
	    @Pattern(regexp = "^[0-9]{4}$", message = "Year must be a 4-digit number")
	    @Column(name = "wage_year")
	    private String year;

	
	private double price;
	
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Wage() {
	}
	public Wage(String day,String month, String year, double price) {
		super();
		this.price=price;
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
			return "Wage=[ id=" + id + ", day=" + day +", month: "+month+ ", year:" +year+", price=" + price + "]";
}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}