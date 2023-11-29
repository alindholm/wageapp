package com.example.wageapp.web;

import java.util.HashMap;
import java.util.Map;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.wageapp.domain.OpintoTuki;
import com.example.wageapp.domain.OpintoTukiRepository;
import com.example.wageapp.domain.Wage;
import com.example.wageapp.domain.WageRepository;

import jakarta.validation.Valid;

@Controller
public class WageController {
	@Autowired
	private WageRepository repository;
	@Autowired
	private OpintoTukiRepository orepository;

	@GetMapping("/")
	public String wageList(@RequestParam(name = "selectedMonth", defaultValue = "9") int selectedMonth, Model model) {
		OpintoTuki selectedOpintoTuki = orepository.findByMonthNumber(selectedMonth);

		int supportValue = selectedOpintoTuki.getSupport();
		int monthValue = selectedOpintoTuki.getMonthNumber();

		model.addAttribute("selectedMonthSupport", supportValue);
		model.addAttribute("selectedMonthNumber", monthValue);

		List<Wage> sortedWages = repository.findAllByOrderByYearAsc();
		model.addAttribute("wages", sortedWages);

		Map<String, Double> totalWagesByYear = new HashMap<>();
		for (Wage wage : sortedWages) {
			String year = wage.getYear();
			Double totalWages = totalWagesByYear.getOrDefault(year, 0.0);
			totalWages += wage.getPrice();
			totalWagesByYear.put(year, totalWages);
		}
		model.addAttribute("totalWagesByYear", totalWagesByYear);

		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/wagelist")
	public String wageListPage(Model model) {
		List<Wage> sortedWages = repository.findAllByOrderByYearAsc();
		model.addAttribute("wages", sortedWages);
	    return "wagelist";
	}

	@RequestMapping(value = "/addwage")
	public String addWage(Model model) {
		model.addAttribute("wage", new Wage());
		model.addAttribute("day", "");
		model.addAttribute("month", "");
		model.addAttribute("year", "");
		model.addAttribute("price", "");
		return "addwage";
	}

	@PostMapping("/save")
	public String saveWage(@Valid @ModelAttribute Wage wage, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		    return "addwage";
		}

		repository.save(wage);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteWage(@PathVariable("id") Long wageId, Model model) {
		repository.deleteById(wageId);
		return "redirect:../";
	}

	@GetMapping("/edit/{id}")
	public String editWage(@PathVariable("id") Long id, Model model) {
		Wage wage = repository.findById(id).orElse(null);
		model.addAttribute("wage", wage);
		return "editwage";
	}

	@PostMapping("/edit/{id}")
	public String updateWage(@PathVariable("id") Long id, @ModelAttribute Wage editedWage) {
		Wage existingWage = repository.findById(id).orElse(null);
		existingWage.setDay(editedWage.getDay());
		existingWage.setMonth(editedWage.getMonth());
		existingWage.setYear(editedWage.getYear());
		existingWage.setPrice(editedWage.getPrice());
		repository.save(existingWage);
		return "redirect:/";
	}

//rest
	@RequestMapping(value = "/wages", method = RequestMethod.GET)
	public @ResponseBody List<Wage> wageListRest() {
		return (List<Wage>) repository.findAll();
	}
	
	@RequestMapping(value = "/gaps", method = RequestMethod.GET)
	public @ResponseBody List<OpintoTuki> gapListRest() {
		return (List<OpintoTuki>) orepository.findAll();
	}
}
