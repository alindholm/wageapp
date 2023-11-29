package com.example.wageapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class OpintoTuki {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	    private int monthNumber;
	    private int support;

	    public OpintoTuki() {

	    }
	    public OpintoTuki(int month, int support) {
	        this.monthNumber = month;
	        this.support = support;
	    }

	    public int getSupport() {
	        return support;
	    }

	    public void setSupport(int support) {
	        this.support = support;
	    }

	    @Override
	    public String toString() {
	        return "OpintoTuki [month=" + monthNumber + ", support=" + support + "]";
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getMonthNumber() {
			return monthNumber;
		}

		public void setMonthNumber(int monthNumber) {
			this.monthNumber = monthNumber;
		}
	}


