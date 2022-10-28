package com.lec.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lec.spring.domain.rental.Car;
import com.lec.spring.domain.rental.Rental;
import com.lec.spring.service.RentalService;

@Controller
@RequestMapping("/rental")
public class RentalController {
	@Autowired
	private RentalService rentalService;
	
	public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}

    public RentalController() {
       System.out.println(getClass().getName() + "() 생성");
    }
 
   
	
	@GetMapping("/list") // /rental/list
	public String list(Model model) {
		model.addAttribute("regionList", rentalService.getRegionList());
		model.addAttribute("rentalList", rentalService.getRentalList());
		
		return "/rental/list";
	}
	
	/**
	 * rentalregion: 미국
in1: 2022-10-27
out1: 2022-10-28
	 * @param model
	 * @return
	 */
	@PostMapping("/list")
	public String rentalrList(Model model, 
			@RequestParam("rentalregion") String region,
			@RequestParam("in1") String sDate, 
			@RequestParam("out1") String eDate) {
		model.addAttribute("regionList", rentalService.getRegionList());
		model.addAttribute("rentalList", rentalService.getRentalRList(region, sDate.replace("-", ""), eDate.replace("-", "")));
		model.addAttribute("sDate", sDate);
		model.addAttribute("eDate", eDate);
		return "/rental/list";
	}
	
	@PostMapping("/cars/list") // /rental/cars/list
	public String carsList(String rentalId, Model model,
			@RequestParam("sDate") String sDate, 
			@RequestParam("eDate") String eDate) {
		Rental rental = rentalService.getRentalById(rentalId);
		List<Car> cars = rental.getCars().stream().filter(car -> car.enabled(sDate.replace("-", ""), eDate.replace("-", ""))).collect(Collectors.toList());
		rental.setCars(cars);
		
		model.addAttribute("rental", rental);
		model.addAttribute("regionList", rentalService.getRegionList());
		model.addAttribute("rentalList", rentalService.getRentalList());
//		model.addAttribute("carNameList", rentalService.getCarNameList());
		return "rental/cars/list";
		
	}
	
	@GetMapping("/cars/detail") // /rental/cars/detail
	public String carsDetail(String rentalId, Model model) {
		model.addAttribute("rental", rentalService.getRentalById(rentalId));
		model.addAttribute("regionList", rentalService.getRegionList());
		model.addAttribute("rentalList", rentalService.getRentalList());
		return "rental/cars/detail";
	}
	
	@PostMapping("/cars/reserv") // /rental/reserv
	public String reserv(String carId, Model model) {
		model.addAttribute("car", rentalService.getCarById(carId));
		model.addAttribute("user", rentalService.getUserData());
		
		
		return "rental/reserv";
	}

}
