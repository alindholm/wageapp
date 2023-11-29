package com.example.wageapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.wageapp.domain.WageRepository;
import com.example.wageapp.domain.Kayttaja;
import com.example.wageapp.domain.KayttajaRepository;
import com.example.wageapp.domain.OpintoTuki;
import com.example.wageapp.domain.OpintoTukiRepository;
import com.example.wageapp.domain.Wage;


@SpringBootApplication
public class WageappApplication {
	private static final Logger log = LoggerFactory.getLogger(WageappApplication.class);
public static void main(String[] args) {
		SpringApplication.run(WageappApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(WageRepository repository, OpintoTukiRepository orepository, KayttajaRepository krepository) {
		return (args) -> {


			Wage w1= new Wage("13","12","2022", 513.00);
			repository.save(w1);
			Wage w2= new Wage("5","2","2023", 412.00);
			repository.save(w2);
			Wage w3= new Wage("18","5","2023", 781.00);
			repository.save(w3);
			Wage w4= new Wage("22","7","2023", 1391.00);
			repository.save(w4);
			Wage w5= new Wage("24","11","2023", 719.00);
			repository.save(w5);

			
			log.info("fetch all wages");
			for (Wage wage : repository.findAll()) {
				log.info(wage.toString());
			}
			// Create instances of OpintoTuki
			OpintoTuki o1= new OpintoTuki(1, 35360);
			OpintoTuki o2=new OpintoTuki(2, 33280);
			OpintoTuki o3=new OpintoTuki(3, 31200);
			OpintoTuki o4=new OpintoTuki(4, 29120);
			OpintoTuki o5=new OpintoTuki(5, 27040);
			OpintoTuki o6=new OpintoTuki(6, 24960);
			OpintoTuki o7=new OpintoTuki(7, 22880);
			OpintoTuki o8=new OpintoTuki(8, 20800);
			OpintoTuki o9=new OpintoTuki(9, 18720);
			OpintoTuki o10=new OpintoTuki(10, 16640);
			OpintoTuki o11=new OpintoTuki(11, 14560);
			OpintoTuki o12=new OpintoTuki(12, 12480);

			orepository.save(o1);
			orepository.save(o2);
			orepository.save(o3);
			orepository.save(o4);
			orepository.save(o5);
			orepository.save(o6);
			orepository.save(o7);
			orepository.save(o8);
			orepository.save(o9);
			orepository.save(o10);
			orepository.save(o11);
			orepository.save(o12);



	        // Display all OpintoTuki instances
	        log.info("OpintoTuki instances:");
	        for (OpintoTuki opintoTuki : orepository.findAll()) {
	            log.info(opintoTuki.toString());
	        }
				Kayttaja k1 = new Kayttaja("admin", "$2a$12$uv0pjvLc.L/mr.nisKDOO.AavxHOR7dWz1AjydS2Eya83Ivryc1ce", "ADMIN");
				krepository.save(k1);

		};
		
	
	}

}
